package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        if (name.startsWith("Conjured ")) {
            return new ConjuredItem(name, sellIn, quality);
        }

        if ("Aged Brie".equals(name)) {
            return new AgedBrieItem(sellIn, quality);
        }

        if ("Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            return new BackstagePassItem(sellIn, quality);
        }

        if ("Sulfuras, Hand of Ragnaros".equals(name)) {
            return new SulfurasItem(sellIn, quality);
        }

        return new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected void doItemUpdate() {
        sellIn = sellIn - 1;

        if (quality > 0) {
            quality = quality - 1;
        }

        if (sellIn < 0 && quality > 0) {
            quality = quality - 1;
        }
    }
}
