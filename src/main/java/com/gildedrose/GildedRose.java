package com.gildedrose;

import java.util.Arrays;
import java.util.Optional;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private SpecialItem selectSpecialItem(Item item){
        for(SpecialItem specialItem : SpecialItem.values()){
            if(specialItem.isSpecial() && item.name.contains(specialItem.getName())){
                return specialItem;
            }
        }
        return SpecialItem.COMMON_ITEM;
    }

    public void updateQuality() {
        for(Item item : items){
            selectSpecialItem(item).updateQuality(item);
        }
    }
}