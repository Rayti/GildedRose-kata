package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    private GildedRose gildedRose;

    //naming strategy: UnitOfWork_StateUnderTest_ExpectedBehavior
    @Test
    void updateQualitySulfurasQualityConstantQuality(){
        String sulfurasName = "Sulfuras, Hand of Ragnaros";
        int quality = 80;
        Item [] items = new Item[] {new Item(sulfurasName, -5, quality),
            new Item(sulfurasName, 0, quality),
            new Item(sulfurasName, 10, quality)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(quality, gildedRose.items[0].quality);
        assertEquals(quality, gildedRose.items[1].quality);
        assertEquals(quality, gildedRose.items[2].quality);
    }

    @Test
    void updateQualityConjuredSulfurasQualityConstantQuality(){
        String sulfurasName = "Conjured Sulfuras, Hand of Ragnaros";
        int quality = 80;
        Item [] items = new Item[] {new Item(sulfurasName, -5, quality),
                new Item(sulfurasName, 0, quality),
                new Item(sulfurasName, 10, quality)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(quality, gildedRose.items[0].quality);
        assertEquals(quality, gildedRose.items[1].quality);
        assertEquals(quality, gildedRose.items[2].quality);
    }

    @Test
    void updateQualitySulfurasSellInConstantSellIn(){
        String sulfurasName = "Sulfuras, Hand of Ragnaros";
        int quality = 80;
        Item [] items = new Item[] {new Item(sulfurasName, -5, quality),
                new Item(sulfurasName, 0, quality),
                new Item(sulfurasName, 10, quality)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(-5, gildedRose.items[0].sellIn);
        assertEquals(0, gildedRose.items[1].sellIn);
        assertEquals(10, gildedRose.items[2].sellIn);
    }

    @Test
    void updateQualityDefaultItemQualityLowerBoundaryDoesNotExceedBoundaryLimit(){
        Item [] items = new Item[] {new Item("common item", 10, 10),
                new Item("common item 2", 10, 0), new Item("common item 3", 0,  10),
                new Item("common item 4", 0, 0), new Item("common item 5", -5, 10),
                new Item("common item 5", -5, 0), new Item("Conjured common item", 10, 10),
                new Item("Conjured common item 2", 10, 0), new Item("Conjured common item 3", 0,  10),
                new Item("Conjured common item 4", 0, 0), new Item("Conjured common item 5", -5, 10),
                new Item("Conjured common item 5", -5, 0)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Arrays.stream(gildedRose.items)
                .forEach(item -> assertTrue(item.quality >=  0) );
    }

    @Test
    void updateQualityDefaultItemQualityUpperBoundaryDoesNotExceedBoundaryLimit(){
        Item [] items = new Item[] {new Item("common item", 10, 51),
                new Item("common item 2", 10, 50), new Item("common item 3", 0,  10),
                new Item("common item 4", 0, 49), new Item("common item 5", -5, 10),
                new Item("common item 5", -5, 51), new Item("Conjured common item", 10, 51),
                new Item("Conjured common item 2", 10, 50), new Item("Conjured common item 3", 0,  10),
                new Item("Conjured common item 4", 0, 49), new Item("Conjured common item 5", -5, 10),
                new Item("Conjured common item 5", -5, 51) };
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Arrays.stream(gildedRose.items)
                .forEach(item -> assertTrue(item.quality <=  50) );
    }

    @Test
    void updateQualityDefaultItemQualityChangeQualityDecreased(){
        Item [] items = new Item[] {new Item("common item", 10, 10),
                new Item("common item 2", 0, 10), new Item("common item 3", -5,  10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].quality, 9);
        assertEquals(gildedRose.items[1].quality, 8);
        assertEquals(gildedRose.items[2].quality, 8);
    }

    @Test
    void updateQualityConjuredDefaultItemQualityChangeQualityDecreased(){
        Item [] items = new Item[] {new Item("Conjured common item", 10, 10),
                new Item("Conjured common item 2", 0, 10), new Item("Conjured common item 3", -5,  10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].quality, 8);
        assertEquals(gildedRose.items[1].quality, 6);
        assertEquals(gildedRose.items[2].quality, 6);
    }

    @Test
    void updateQualityAgedBrieSellInSellInDecreased(){
        String name= "Aged Brie";
        Item[] items = new Item[] {new Item(name, 10, 10), new Item(name, 0, 10),
            new Item(name, -5, 10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].sellIn, 9);
        assertEquals(gildedRose.items[1].sellIn, -1);
        assertEquals(gildedRose.items[2].sellIn, -6);
    }

    @Test
    void updateQualityAgedBrieQualityQualityIncreased() {
        String name = "Aged Brie";
        Item[] items = new Item [] {new Item(name, 10, 10),
            new Item(name, 0, 10), new Item(name, -5, 10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].quality, 11);
        assertEquals(gildedRose.items[1].quality, 12);
        assertEquals(gildedRose.items[2].quality, 12);
    }

    @Test
    void updateQualityConjuredAgedBrieQualityQualityIncreased(){
        String name = "Conjured Aged Brie";
        Item[] items = new Item [] {new Item(name, 10, 10),
                new Item(name, 0, 10), new Item(name, -5, 10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].quality, 12);
        assertEquals(gildedRose.items[1].quality, 14);
        assertEquals(gildedRose.items[2].quality, 14);
    }

    @Test
    void updateQualityBackstagePassesSellInSellInDecreased(){
        String name = "Backstage passes";
        Item[] items = new Item[] {new Item(name, 10, 10), new Item(name, 0, 10),
                new Item(name, -5, 10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].sellIn, 9);
        assertEquals(gildedRose.items[1].sellIn, -1);
        assertEquals(gildedRose.items[2].sellIn, -6);
    }

    @Test
    void updateQualityBackstagePassesQualityQualityDependingOnSellIn(){
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] {new Item(name, 20, 10), new Item(name, 10, 10),
                new Item(name, 7, 10), new Item(name, 5, 10), new Item(name, 2, 10),
                new Item(name, 0, 10), new Item(name, -5, 10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].quality, 11);
        assertEquals(gildedRose.items[1].quality, 12);
        assertEquals(gildedRose.items[2].quality, 12);
        assertEquals(gildedRose.items[3].quality, 13);
        assertEquals(gildedRose.items[4].quality, 13);
        assertEquals(gildedRose.items[5].quality, 0);
        assertEquals(gildedRose.items[6].quality, 0);
    }

    @Test
    void updateQualityConjuredBackstagePassesQualityQualityDependingOnSellIn(){
        String name = "Conjured Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] {new Item(name, 20, 10), new Item(name, 10, 10),
                new Item(name, 7, 10), new Item(name, 5, 10), new Item(name, 2, 10),
                new Item(name, 0, 10), new Item(name, -5, 10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items[0].quality, 12);
        assertEquals(gildedRose.items[1].quality, 14);
        assertEquals(gildedRose.items[2].quality, 14);
        assertEquals(gildedRose.items[3].quality, 16);
        assertEquals(gildedRose.items[4].quality, 16);
        assertEquals(gildedRose.items[5].quality, 0);
        assertEquals(gildedRose.items[6].quality, 0);
    }

    @Test
    void updateQualityEmptyListOfItemsListRemainsEmpty(){
        gildedRose = new GildedRose(new Item[0]);
        gildedRose.updateQuality();
        assertEquals(gildedRose.items.length, 0);
    }

    @Test
    void updateQualityNullListOfItemsThrowNullPointerException(){
        gildedRose = new GildedRose(null);
        assertThrows(NullPointerException.class, () -> gildedRose.updateQuality());
    }

    @Test
    void updateQualityNullItemNameThrowNullPointerException(){
        gildedRose = new GildedRose(new Item[]{new Item(null, 5, 5)});
        assertThrows(NullPointerException.class, () -> gildedRose.updateQuality());
    }
}
