/**
 * @(#)ConjuredItem.java, 12月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose;

/**
 * @author pw
 */
public class ConjuredItem extends Item {
    private static final int CONJURED_LEN = "Conjured ".length();

    private final Item item;

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);

        this.item = Item.createItem(name.substring(CONJURED_LEN), sellIn, quality);
    }

    @Override
    protected void doItemUpdate() {
        item.doItemUpdate();

        syncSellIn();
        syncQuality();
    }

    private void syncQuality() {
        int qualityDiff = this.quality - item.quality;
        boolean isDowngradeQuality = qualityDiff > 0;

        if (isDowngradeQuality && item.quality > 1) {
            this.quality = item.quality - (qualityDiff);
            item.quality = this.quality;
        } else {
            this.quality = item.quality;
        }
    }

    private void syncSellIn() {
        this.sellIn = item.sellIn;
    }
}
