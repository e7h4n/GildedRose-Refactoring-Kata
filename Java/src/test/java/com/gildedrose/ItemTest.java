/**
 * @(#)ItemTest.java, 12月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pw
 */
public class ItemTest {

    @Test
    public void conjuredItemShouldTwiceSpeedDowngradeQuality() {
        int initQuality = 10;
        Item normalItem = Item.createItem("Mana Cake", 10, initQuality);
        Item conjuredItem = Item.createItem("Conjured Mana Cake", 10, initQuality);

        normalItem.doItemUpdate();
        conjuredItem.doItemUpdate();
        Assertions.assertEquals(2 * (initQuality - normalItem.quality),
            initQuality - conjuredItem.quality);
    }

    @Test
    public void conjuredAgedBrieShouldNotTwiceUpgradeQuality() {
        int initQuality = 10;
        Item normalItem = Item.createItem("Aged Brie", 10, initQuality);
        Item conjuredItem = Item.createItem("Conjured Aged Brie", 10, initQuality);

        normalItem.doItemUpdate();
        conjuredItem.doItemUpdate();
        Assertions.assertEquals(normalItem.quality, conjuredItem.quality);
    }

    @Test
    public void conjuredItemShouldNotDowngradeBelowZero() {
        Item conjuredItem = Item.createItem("Conjured Mana Cake", 10, 1);
        conjuredItem.doItemUpdate();
        Assertions.assertEquals(0, conjuredItem.quality);
    }
}
