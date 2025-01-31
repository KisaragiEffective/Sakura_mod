package cn.mcmod.sakura.item.enums;

import cn.mcmod_mmf.mmlib.item.info.FoodInfo;

public enum SakuraFoodSet {
    SHRIMP(FoodInfo.builder().name("shrimp").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F)
            .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TOMATO(FoodInfo.builder().name("tomato").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RADISH(FoodInfo.builder().name("radish").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    EGGPLANT(FoodInfo.builder().name("eggplant").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CABBAGE(FoodInfo.builder().name("cabbage").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    ONION(FoodInfo.builder().name("onion").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    FISHCAKE(FoodInfo.builder().name("fishcake").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F)
            .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    SLICED_CABBAGE(FoodInfo.builder().name("sliced_cabbage").amountAndCalories(2, 0.2F).water(5F)
            .nutrients(0F, 0F, 2F, 0F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    TOMATO_SAUCE(FoodInfo.builder().name("tomato_sauce").amountAndCalories(2, 0.2F).water(5F)
            .nutrients(0F, 0F, 2F, 0F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    EGGPLANT_BAKED(FoodInfo.builder().name("eggplant_baked").amountAndCalories(4, 0.5F).water(0F)
            .nutrients(0F, 0F, 3F, 0F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    TARO_BAKED(FoodInfo.builder().name("taro_baked").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 2F, 0F, 0F, 0F)
            .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE(FoodInfo.builder().name("cheese").amountAndCalories(2, 0.2F).water(1F).nutrients(0F, 0F, 0F, 0F, 2F)
            .decayModifier(2F).heatCapacity(0F).cookingTemp(-1F).build()),
    BUN(FoodInfo.builder().name("bun").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F)
            .decayModifier(0.8F).heatCapacity(1F).cookingTemp(480F).build()),
    BUCKWHEAT_BREAD(FoodInfo.builder().name("buckwheat_bread").amountAndCalories(5, 0.6F).water(0F)
            .nutrients(2F, 0F, 0F, 0F, 0F).decayModifier(0.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_BREAD(FoodInfo.builder().name("rice_bread").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F)
            .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build()),
    REDBEAN_PASTE(FoodInfo.builder().name("red_bean_paste").amountAndCalories(4, 0.25F).water(4F)
            .nutrients(0.25F, 0F, 1F, 0F, 0F).decayModifier(4F).heatCapacity(0F).cookingTemp(-1F).build()),
    BREADCRUMBS(FoodInfo.builder().name("breadcrumbs").amountAndCalories(1, 0.1F).water(0F)
            .nutrients(0.25F, 0F, 0F, 0F, 0F).decayModifier(4F).heatCapacity(0F).cookingTemp(-1F).build()),
    TEMPURA(FoodInfo.builder().name("tempura").amountAndCalories(5, 0.6F).water(0F).nutrients(1F, 0F, 0F, 2F, 0F)
            .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    BROWN_RICE_COOKED(FoodInfo.builder().name("brown_rice_cooked").amountAndCalories(4, 0.5F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_COOKED(FoodInfo.builder().name("rice_cooked").amountAndCalories(4, 0.5F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_REDBEAN(FoodInfo.builder().name("rice_redbean").amountAndCalories(6, 0.6F).water(0.5F)
            .nutrients(4F, 0F, 2F, 0F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_BAMBOO(FoodInfo.builder().name("rice_bamboo").amountAndCalories(5, 0.6F).water(0.5F)
            .nutrients(1.5F, 1F, 0F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_BEEF(FoodInfo.builder().name("rice_beef").amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_FISH(FoodInfo.builder().name("rice_fish").amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 2F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_PORK(FoodInfo.builder().name("rice_pork").amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_MUSHROOM(FoodInfo.builder().name("rice_mushroom").amountAndCalories(6, 0.6F).water(0.5F)
            .nutrients(1.5F, 0F, 2F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_EGG(FoodInfo.builder().name("rice_egg").amountAndCalories(5, 0.6F).water(0.5F).nutrients(1.5F, 0F, 0F, 0F, 2F)
            .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_BEEF_EGG(FoodInfo.builder().name("rice_beef_egg").amountAndCalories(10, 1F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_PORK_EGG(FoodInfo.builder().name("rice_pork_egg").amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_OYAKO(FoodInfo.builder().name("rice_oyako").amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_OYAKO_FISH(FoodInfo.builder().name("rice_oyako_fish").amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),

    ONIGIRI(FoodInfo.builder().name("onigiri").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2F, 0F, 1F, 0F, 0F)
            .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    ONIGIRI_BAMBOO(FoodInfo.builder().name("onigiri_bamboo").amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    ONIGIRI_FISH(FoodInfo.builder().name("onigiri_fish").amountAndCalories(8, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 1F, 2F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    ONIGIRI_MUSHROOM(FoodInfo.builder().name("onigiri_mushroom").amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    ONIGIRI_SEAWEED(FoodInfo.builder().name("onigiri_seaweed").amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    ODEN(FoodInfo.builder().name("oden").amountAndCalories(8, 0.6F).water(1F).nutrients(1F, 0F, 3F, 3F, 0F)
            .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    MOCHI(FoodInfo.builder().name("mochi").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F)
            .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    MOCHI_TOASTED(FoodInfo.builder().name("mochi_toasted").amountAndCalories(4, 0.6F).water(0.5F)
            .nutrients(3F, 0F, 0F, 0F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    MOCHI_SAKURA(FoodInfo.builder().name("mochi_sakura").amountAndCalories(4, 0.6F).water(0.5F)
            .nutrients(3F, 0F, 1F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    OHAGI(FoodInfo.builder().name("ohagi").amountAndCalories(6, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F)
            .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    DAIFUKU(FoodInfo.builder().name("daifuku").amountAndCalories(4, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F)
            .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    KUSA_DAIFUKU(FoodInfo.builder().name("kusa_daifuku").amountAndCalories(6, 0.6F).water(0.5F)
            .nutrients(3F, 0F, 1.5F, 0F, 0.5F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    DANGO(FoodInfo.builder().name("dango").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F)
            .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANANKO(FoodInfo.builder().name("dananko").amountAndCalories(6, 0.6F).water(1F).nutrients(3F, 0F, 0F, 0F, 1F)
            .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANMITARASHI(FoodInfo.builder().name("danmitarashi").amountAndCalories(6, 0.4F).water(1F)
            .nutrients(3F, 0F, 0F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANSANSYOKU(FoodInfo.builder().name("dansansyoku").amountAndCalories(6, 0.6F).water(1F)
            .nutrients(3F, 0F, 0F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    SOUP_REDBEAN(FoodInfo.builder().name("soup_red_bean").amountAndCalories(6, 0.6F).water(50F)
            .nutrients(2F, 0F, 2F, 0F, 2F).decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build()),
    BURGER_RAW(FoodInfo.builder().name("burger_raw").amountAndCalories(2, 0.2F).water(1F)
            .nutrients(0.5F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    BURGER(FoodInfo.builder().name("burger").amountAndCalories(6, 0.6F).water(2F).nutrients(0.5F, 0F, 0F, 4F, 0F)
            .decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    BURGER_DISH(FoodInfo.builder().name("burger_dish").amountAndCalories(10, 0.8F).water(2.5F)
            .nutrients(0.5F, 0F, 2F, 4F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    HAMBURGER(FoodInfo.builder().name("hamburger").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 2F, 4F, 1F)
            .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE_BURGER(FoodInfo.builder().name("cheese_burger").amountAndCalories(10, 0.8F).water(0.5F)
            .nutrients(2F, 0F, 2F, 4F, 3F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    CABBAGE_ROLL(FoodInfo.builder().name("cabbage_roll").amountAndCalories(4, 0.4F).water(25F)
            .nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    FISH_BAKE_SALT(FoodInfo.builder().name("fish_bake_salt").amountAndCalories(8, 0.8F).water(0.5F)
            .nutrients(0F, 0F, 0F, 4F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    FISH_BAKE(FoodInfo.builder().name("fish_bake").amountAndCalories(9, 0.8F).water(0.5F).nutrients(0F, 0F, 0F, 4F, 0F)
            .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build());

    private final FoodInfo info;

    private SakuraFoodSet(FoodInfo info) {
        this.info = info;
    }

    public FoodInfo getFoodInfo() {
        return info;
    }
}
