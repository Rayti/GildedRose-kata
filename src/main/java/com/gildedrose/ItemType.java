package com.gildedrose;

import com.gildedrose.functions.*;

public enum ItemType {
    SULFURAS(true, "Sulfuras, Hand of Ragnaros", new SulfurasQualityFunction()),
    AGED_BRIE(true, "Aged Brie", new AgedBrieQualityFunction()),
    BACKSTAGE_PASSES(true,"Backstage passes", new BackstagePassesQualityFunction()),
    COMMON_ITEM(false, "", new CommonItemQualityFunction());

    private ItemQualityContext itemQualityContext;
    private String name;

    public boolean isSpecial() {
        return isSpecial;
    }

    private boolean isSpecial;

    ItemType(boolean isSpecial, String name, ItemQualityFunction function) {
        this.isSpecial = isSpecial;
        this.name = name;
        this.itemQualityContext = new ItemQualityContext(function);
    }

    public ItemQualityContext getItemQualityContext() {
        return itemQualityContext;
    }

    public String getName() {
        return name;
    }
}
