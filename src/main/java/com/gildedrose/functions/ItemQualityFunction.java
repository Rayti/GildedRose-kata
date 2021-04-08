package com.gildedrose.functions;

import com.gildedrose.Item;

public interface ItemQualityFunction {

    void updateQuality(Item item, float multiplier);

    default void checkQualityBoundaries(Item item){
        if (item.quality < 0){
            item.quality = 0;
        }
        if(item.quality > 50){
            item.quality = 50;
        }
    }
}
