package com.gildedrose.functions;

import com.gildedrose.Item;

public class SulfurasQualityFunction implements ItemQualityFunction {
    @Override
    public void updateQuality(Item item, float multiplier) {
        item.quality = 80;
    }
}
