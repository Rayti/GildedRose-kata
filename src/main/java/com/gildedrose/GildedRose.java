package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private ItemType selectSpecialItem(Item item){
        for(ItemType itemType : ItemType.values()){
            if(itemType.isSpecial() && item.name.contains(itemType.getName())){
                return itemType;
            }
        }
        return ItemType.COMMON_ITEM;
    }

    public void updateQuality() {
        for(Item item : items){
            selectSpecialItem(item).getItemQualityContext().updateQuality(item);
        }
    }
}