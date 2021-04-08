package com.gildedrose.functions;

import com.gildedrose.Item;

public class CommonItemQualityFunction implements ItemQualityFunction {
    @Override
    public void updateQuality(Item item, float multiplier) {
        if(item.sellIn <= 0){
            item.quality -= 2 * multiplier;
        }else{
            item.quality -= 1 * multiplier;
        }
        item.sellIn--;
        checkQualityBoundaries(item);
    }
}
