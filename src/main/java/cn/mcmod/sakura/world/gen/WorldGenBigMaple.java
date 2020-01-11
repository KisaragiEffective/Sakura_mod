package cn.mcmod.sakura.world.gen;

import com.google.common.collect.Lists;

import cn.mcmod.sakura.block.BlockLoader;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

public class WorldGenBigMaple extends WorldGenAbstractTree{
    private Random rand;
    private World world;
    private BlockPos basePos = BlockPos.ORIGIN;
    int heightLimit;
    int height;
    double heightAttenuation = 0.618D;
    double branchSlope = 0.381D;
    double scaleWidth = 1.0D;
    double leafDensity = 1.0D;
    int trunkSize = 1;
    int heightLimitLimit = 12;
    /** Sets the distance limit for how far away the generator will populate leaves from the base leaf node. */
    int leafDistanceLimit = 4;
    List<WorldGenBigMaple.FoliageCoordinates> foliageCoords;

    private final boolean generateSap;
    private final IBlockState metaWood;
    private final IBlockState metaSapling;
    private final IBlockState metaLeaves;
    private final IBlockState metaFallenLeaves;
    
    public WorldGenBigMaple(boolean notify,IBlockState woodMeta,IBlockState saplingMeta, IBlockState leafMeta,IBlockState fallenMeta, boolean sap) {
        super(notify);
        this.metaWood = woodMeta;
        this.metaSapling = saplingMeta;
        this.metaLeaves = leafMeta;
        this.metaFallenLeaves = fallenMeta;
        this.generateSap = sap;
    }

    /**
     * Generates a list of leaf nodes for the tree, to be populated by generateLeaves.
     */
    void generateLeafNodeList()
    {
        this.height = (int)(this.heightLimit * this.heightAttenuation);

        if (this.height >= this.heightLimit)
        {
            this.height = this.heightLimit - 1;
        }

        int i = (int)(1.382D + Math.pow(this.leafDensity * this.heightLimit / 13.0D, 2.0D));

        if (i < 1)
        {
            i = 1;
        }

        int j = this.basePos.getY() + this.height;
        int k = this.heightLimit - this.leafDistanceLimit;
        this.foliageCoords = Lists.<WorldGenBigMaple.FoliageCoordinates>newArrayList();
        this.foliageCoords.add(new WorldGenBigMaple.FoliageCoordinates(this.basePos.up(k), j));

        for (; k >= 0; --k)
        {
            float f = this.layerSize(k);

            if (f >= 0.0F)
            {
                for (int l = 0; l < i; ++l)
                {
                    double d0 = this.scaleWidth * f * (this.rand.nextFloat() + 0.328D);
                    double d1 = this.rand.nextFloat() * 2.0F * Math.PI;
                    double d2 = d0 * Math.sin(d1) + 0.5D;
                    double d3 = d0 * Math.cos(d1) + 0.5D;
                    BlockPos blockpos = this.basePos.add(d2, k - 1, d3);
                    BlockPos blockpos1 = blockpos.up(this.leafDistanceLimit);

                    if (this.checkBlockLine(blockpos, blockpos1) == -1)
                    {
                        int i1 = this.basePos.getX() - blockpos.getX();
                        int j1 = this.basePos.getZ() - blockpos.getZ();
                        double d4 = blockpos.getY() - Math.sqrt(i1 * i1 + j1 * j1) * this.branchSlope;
                        int k1 = d4 > j ? j : (int)d4;
                        BlockPos blockpos2 = new BlockPos(this.basePos.getX(), k1, this.basePos.getZ());

                        if (this.checkBlockLine(blockpos2, blockpos) == -1)
                        {
                            this.foliageCoords.add(new WorldGenBigMaple.FoliageCoordinates(blockpos, blockpos2.getY()));
                        }
                    }
                }
            }
        }
    }

    void crosSection(BlockPos pos, float p_181631_2_, IBlockState p_181631_3_)
    {
        int i = (int)(p_181631_2_ + 0.618D);

        for (int j = -i; j <= i; ++j)
        {
            for (int k = -i; k <= i; ++k)
            {
                if (Math.pow(Math.abs(j) + 0.5D, 2.0D) + Math.pow(Math.abs(k) + 0.5D, 2.0D) <= p_181631_2_ * p_181631_2_)
                {
                    BlockPos blockpos = pos.add(j, 0, k);
                    IBlockState state = this.world.getBlockState(blockpos);

                    if (state.getBlock().isAir(state, world, blockpos) || state.getBlock().isLeaves(state, world, blockpos))
                    {
                        this.setBlockAndNotifyAdequately(this.world, blockpos, p_181631_3_);
                    }
                }
            }
        }
    }

    /**
     * Gets the rough size of a layer of the tree.
     */
    float layerSize(int y)
    {
        if (y < this.heightLimit * 0.3F)
        {
            return -1.0F;
        }
		float f = this.heightLimit / 2.0F;
		float f1 = f - y;
		float f2 = MathHelper.sqrt(f * f - f1 * f1);

		if (f1 == 0.0F)
		{
		    f2 = f;
		}
		else if (Math.abs(f1) >= f)
		{
		    return 0.0F;
		}

		return f2 * 0.5F;
    }

    float leafSize(int y)
    {
        if (y >= 0 && y < this.leafDistanceLimit)
        {
            return y != 0 && y != this.leafDistanceLimit - 1 ? 3.0F : 2.0F;
        }
		return -1.0F;
    }

    /**
     * Generates the leaves surrounding an individual entry in the leafNodes list.
     */
    void generateLeafNode(BlockPos pos)
    {
        for (int i = 0; i < this.leafDistanceLimit; ++i)
        {
            this.crosSection(pos.up(i), this.leafSize(i), metaLeaves.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)));
        }
    }

    void limb(BlockPos p_175937_1_, BlockPos p_175937_2_, Block p_175937_3_)
    {
        BlockPos blockpos = p_175937_2_.add(-p_175937_1_.getX(), -p_175937_1_.getY(), -p_175937_1_.getZ());
        int i = this.getGreatestDistance(blockpos);
        float f = (float)blockpos.getX() / (float)i;
        float f1 = (float)blockpos.getY() / (float)i;
        float f2 = (float)blockpos.getZ() / (float)i;

        for (int j = 0; j <= i; ++j)
        {
            BlockPos blockpos1 = p_175937_1_.add(0.5F + j * f, 0.5F + j * f1, 0.5F + j * f2);
            BlockLog.EnumAxis blocklog$enumaxis = this.getLogAxis(p_175937_1_, blockpos1);
            this.setBlockAndNotifyAdequately(this.world, blockpos1, p_175937_3_.getDefaultState().withProperty(BlockLog.LOG_AXIS, blocklog$enumaxis));
            if (this.generateSap && j == 1) {
                if (this.world.getBlockState(blockpos1.add(0, j, 0))==this.metaWood) {
                    this.addSapLog(this.world, blockpos1.add(0, j, 0));
                }

            }
        }
    }

    /**
     * Returns the absolute greatest distance in the BlockPos object.
     */
    private int getGreatestDistance(BlockPos posIn)
    {
        int i = MathHelper.abs(posIn.getX());
        int j = MathHelper.abs(posIn.getY());
        int k = MathHelper.abs(posIn.getZ());

        if (k > i && k > j)
        {
            return k;
        }
		return j > i ? j : i;
    }

    private BlockLog.EnumAxis getLogAxis(BlockPos p_175938_1_, BlockPos p_175938_2_)
    {
        BlockLog.EnumAxis blocklog$enumaxis = BlockLog.EnumAxis.Y;
        int i = Math.abs(p_175938_2_.getX() - p_175938_1_.getX());
        int j = Math.abs(p_175938_2_.getZ() - p_175938_1_.getZ());
        int k = Math.max(i, j);

        if (k > 0)
        {
            if (i == k)
            {
                blocklog$enumaxis = BlockLog.EnumAxis.X;
            }
            else if (j == k)
            {
                blocklog$enumaxis = BlockLog.EnumAxis.Z;
            }
        }

        return blocklog$enumaxis;
    }

    /**
     * Generates the leaf portion of the tree as specified by the leafNodes list.
     */
    void generateLeaves()
    {
        for (WorldGenBigMaple.FoliageCoordinates worldgenbigtree$foliagecoordinates : this.foliageCoords)
        {
            this.generateLeafNode(worldgenbigtree$foliagecoordinates);
        }
    }

    /**
     * Indicates whether or not a leaf node requires additional wood to be added to preserve integrity.
     */
    boolean leafNodeNeedsBase(int p_76493_1_)
    {
        return p_76493_1_ >= this.heightLimit * 0.2D;
    }

    /**
     * Places the trunk for the big tree that is being generated. Able to generate double-sized trunks by changing a
     * field that is always 1 to 2.
     */
    void generateTrunk()
    {
        BlockPos blockpos = this.basePos;
        BlockPos blockpos1 = this.basePos.up(this.height);
        Block block = metaWood.getBlock();
        this.limb(blockpos, blockpos1, block);

        if (this.trunkSize == 2)
        {
            this.limb(blockpos.east(), blockpos1.east(), block);
            this.limb(blockpos.east().south(), blockpos1.east().south(), block);
            this.limb(blockpos.south(), blockpos1.south(), block);
        }
    }

    /**
     * Generates additional wood blocks to fill out the bases of different leaf nodes that would otherwise degrade.
     */
    void generateLeafNodeBases()
    {
        for (WorldGenBigMaple.FoliageCoordinates worldgenbigtree$foliagecoordinates : this.foliageCoords)
        {
            int i = worldgenbigtree$foliagecoordinates.getBranchBase();
            BlockPos blockpos = new BlockPos(this.basePos.getX(), i, this.basePos.getZ());

            if (!blockpos.equals(worldgenbigtree$foliagecoordinates) && this.leafNodeNeedsBase(i - this.basePos.getY()))
            {
                this.limb(blockpos, worldgenbigtree$foliagecoordinates,metaWood.getBlock());
            }
        }
    }

    /**
     * Checks a line of blocks in the world from the first coordinate to triplet to the second, returning the distance
     * (in blocks) before a non-air, non-leaf block is encountered and/or the end is encountered.
     */
    int checkBlockLine(BlockPos posOne, BlockPos posTwo)
    {
        BlockPos blockpos = posTwo.add(-posOne.getX(), -posOne.getY(), -posOne.getZ());
        int i = this.getGreatestDistance(blockpos);
        float f = (float)blockpos.getX() / (float)i;
        float f1 = (float)blockpos.getY() / (float)i;
        float f2 = (float)blockpos.getZ() / (float)i;

        if (i == 0)
        {
            return -1;
        }
		for (int j = 0; j <= i; ++j)
		{
		    BlockPos blockpos1 = posOne.add(0.5F + j * f, 0.5F + j * f1, 0.5F + j * f2);

		    if (!this.isReplaceable(world, blockpos1))
		    {
		        return j;
		    }
		}

		return -1;
    }

    public void setDecorationDefaults()
    {
        this.leafDistanceLimit = 5;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        this.world = worldIn;
        this.basePos = position;
        this.rand = new Random(rand.nextLong());

        if (this.heightLimit == 0)
        {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }

        if (!this.validTreeLocation())
        {
            this.world = null; //Fix vanilla Mem leak, holds latest world
            return false;
        }
		this.generateLeafNodeList();
		this.generateLeaves();
		this.generateTrunk();
		this.generateLeafNodeBases();
		this.fallenLeaves(worldIn, position, 6, 3, 6, this.metaFallenLeaves);
		
		this.world = null; //Fix vanilla Mem leak, holds latest world
		
		return true;
    }

    /**
     * Returns a boolean indicating whether or not the current location for the tree, spanning basePos to to the height
     * limit, is valid.
     */
    private boolean validTreeLocation()
    {
        BlockPos down = this.basePos.down();
        net.minecraft.block.state.IBlockState state = this.world.getBlockState(down);
        boolean isSoil = state.getBlock().canSustainPlant(state, this.world, down, net.minecraft.util.EnumFacing.UP, ((IPlantable)metaSapling.getBlock()));

        if (!isSoil)
        {
            return false;
        }
		int i = this.checkBlockLine(this.basePos, this.basePos.up(this.heightLimit - 1));

		if (i == -1)
		{
		    return true;
		}
		else if (i < 6)
		{
		    return false;
		}
		else
		{
		    this.heightLimit = i;
		    return true;
		}
    }

    static class FoliageCoordinates extends BlockPos
        {
            private final int branchBase;

            public FoliageCoordinates(BlockPos pos, int p_i45635_2_)
            {
                super(pos.getX(), pos.getY(), pos.getZ());
                this.branchBase = p_i45635_2_;
            }

            public int getBranchBase()
            {
                return this.branchBase;
            }
        }
    /**
     * Fill the given area with the selected blocks
     */
    private void fallenLeaves(World worldIn,BlockPos pos, int xADD, int yADD, int zADD, IBlockState insideBlockState){
    	int xx = pos.getX();
        int yy = pos.getY();
        int zz = pos.getZ();
        
        boolean setFlg = false;
        int YEND = 4;
        for (int xx1 = xx - xADD; xx1 <= xx + xADD; xx1++) {
          for (int zz1 = zz - zADD; zz1 <= zz + zADD; zz1++) {
            if (((xx1 != xx - xADD) || (zz1 != zz - zADD)) && ((xx1 != xx + xADD) || (zz1 != zz - zADD)) && ((xx1 != xx - xADD) || (zz1 != zz + zADD)) && ((xx1 != xx + xADD) || (zz1 != zz + zADD)) && (((xx1 >= xx - xADD + 1) && (xx1 <= xx + xADD - 1) && (zz1 >= zz - zADD + 1) && (zz1 <= zz + zADD - 1)) || (worldIn.rand.nextInt(2) != 0)))
            {
              setFlg = false;
              int yy1 = yy + yADD;
              Block cBl = worldIn.getBlockState(new BlockPos(xx1, yy + yADD, zz1)).getBlock();
              
              if ((cBl == Blocks.AIR) || (cBl instanceof BlockLeaves) || (cBl == BlockLoader.CHESTNUTBURR)) {
                for (yy1 = yy + yADD; yy1 >= yy - YEND; yy1--)
                {
                  boolean cAir = worldIn.isAirBlock(new BlockPos(xx1, yy1, zz1));
                  cBl = worldIn.getBlockState(new BlockPos(xx1, yy1 - 1, zz1)).getBlock();
                  if ((cBl == Blocks.AIR) || ((cBl != Blocks.GRASS) && !(cBl instanceof BlockLeaves) && (!worldIn.getBlockState(new BlockPos(xx1, yy1 - 1, zz1)).isOpaqueCube())))
                  {
                    if (cBl != Blocks.AIR) {
                      break;
                    }
                  }
                  else if (cAir)
                  {
                    setFlg = true;
                    break;
                  }
                }
              }
              if (setFlg) {
                setBlockAndNotifyAdequately(worldIn, new BlockPos(xx1, yy1, zz1), insideBlockState);
              }
            }
          }
        }
    }
    
    private void addSapLog(World worldIn, BlockPos pos) {
        this.setBlockAndNotifyAdequately(worldIn, pos, BlockLoader.MAPLE_LOG_SAP.getDefaultState());
    }
}