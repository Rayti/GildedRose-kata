package com.gildedrose;

import com.gildedrose.functions.ItemQualityFunction;

public class ItemQualityContext {

    private ItemQualityFunction itemQualityFunction;

    public ItemQualityContext(ItemQualityFunction itemQualityFunction) {
        this.itemQualityFunction = itemQualityFunction;
    }

    public void updateQuality(Item item){
        if(item.name.contains("Conjured")){
            itemQualityFunction.updateQuality(item, 2);
        }else{
            itemQualityFunction.updateQuality(item, 1);
        }
    }
}
