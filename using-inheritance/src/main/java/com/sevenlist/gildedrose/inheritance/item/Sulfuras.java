package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;

public class Sulfuras extends UnboxedItem {

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void updateSellIn() {
        // will never be sold
    }

    @Override
    protected void updateQuality() {
        // will never decreases in quality
    }
}
