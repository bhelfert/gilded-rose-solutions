package com.sevenlist.gildedrose.inheritance.unboxeditem;

import com.sevenlist.gildedrose.inheritance.Item;

public class Sulfuras extends UnboxedItem {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item boxedItem) {
        super(boxedItem);
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
