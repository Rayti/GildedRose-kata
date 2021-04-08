package com.gildedrose.functions;

import com.gildedrose.Item;

public class BackstagePassesQualityFunction implements ItemQualityFunction {
    @Override
    public void updateQuality(Item item, float multiplier) {
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
    }
}
