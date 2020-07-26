package de.bhelfert.gildedrose.inheritance.simple.unboxeditem;

import de.bhelfert.gildedrose.inheritance.simple.Item;

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
