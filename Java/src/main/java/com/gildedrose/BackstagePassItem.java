/**
 * @(#)BackstagePassItem.java, 12月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose;

/**
 * @author pw
 */
public class BackstagePassItem extends Item {
    public BackstagePassItem(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void doItemUpdate() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11 && quality < 50) {
                quality = quality + 1;
            }

            if (sellIn < 6 && quality < 50) {
                quality = quality + 1;
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }
}