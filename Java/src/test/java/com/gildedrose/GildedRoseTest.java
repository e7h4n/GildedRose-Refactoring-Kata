package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    @UseReporter(QuietReporter.class)
    void testItemQualityUpdate() {
        CombinationApprovals.verifyAllCombinations(this::updateItem, new String[]{
            "foo",
            "Aged Brie",
            "Sulfuras, Hand of Ragnaros",
            "Backstage passes to a TAFKAL80ETC concert",
        }, new Integer[]{
            0,
            5,
            10,
            11,
        }, new Integer[]{
            0,
            10,
            49,
            50,
            51,
            80,
        });
    }

    private Item updateItem(String name, int sellIn, int quality) {
        Item[] items = new Item[]{Item.createItem(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.items[0];
        return item;
    }
}
