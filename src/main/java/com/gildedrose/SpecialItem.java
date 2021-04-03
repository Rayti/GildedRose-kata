package com.gildedrose;

public enum SpecialItem {
    SULFURAS(true, "Sulfuras, Hand of Ragnaros", (item, multiplier) -> item.quality = 80),
    AGED_BRIE(true, "Aged Brie", (item, multiplier) -> {
        if(item.sellIn > 0){
            item.quality += 1 * multiplier;
        }else{
            item.quality += 2 * multiplier;
        }
        checkQualityBoundaries(item);
        item.sellIn--;
    }),
    BACKSTAGE_PASSES(true,"Backstage passes", (item, multiplier) -> {
        if(item.sellIn <= 0){
            item.quality = 0;
        }else if (item.sellIn <= 5){
            item.quality += 3 * multiplier;
        }else if (item.sellIn <= 10){
            item.quality += 2 * multiplier;
        }else{
            item.quality += 1 * multiplier;
        }
        checkQualityBoundaries(item);
        item.sellIn--;
    }),
    COMMON_ITEM(false, "", ((item, multiplier) -> {
        if(item.sellIn <= 0){
            item.quality -= 2 * multiplier;
        }else{
            item.quality -= 1 * multiplier;
        }
        item.sellIn--;
        checkQualityBoundaries(item);
    }));

    private SpecialItemQualityFunction function;
    private String name;

    public boolean isSpecial() {
        return isSpecial;
    }

    private boolean isSpecial;

    SpecialItem(boolean isSpecial, String name, SpecialItemQualityFunction function) {
        this.isSpecial = isSpecial;
        this.name = name;
        this.function = function;
    }

    private static void checkQualityBoundaries(Item item){
        if (item.quality < 0){
            item.quality = 0;
        }
        if(item.quality > 50){
            item.quality = 50;
        }
    }

    public void updateQuality(Item item){
        if(item.name.contains("Conjured")){
            function.updateQuality(item, 2);
        }else{
            function.updateQuality(item, 1);
        }
    }

    public String getName() {
        return name;
    }
}
