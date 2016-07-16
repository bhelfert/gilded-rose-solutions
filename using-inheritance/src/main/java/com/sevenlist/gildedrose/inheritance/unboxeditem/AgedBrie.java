package com.sevenlist.gildedrose.inheritance.unboxeditem;

import com.sevenlist.gildedrose.inheritance.Item;

public class AgedBrie extends UnboxedItem {

    public static final String NAME = "Aged Brie";

    public AgedBrie(Item boxedItem) {
        super(boxedItem);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (hasPassedSellIn()) {
            increaseQuality();
        }
    }
}
