package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;

public class AgedBrie extends UnboxedItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (hasPassedSellIn()) {
            increaseQuality();
        }
    }
}
