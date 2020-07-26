package de.bhelfert.gildedrose.inheritance.simple.unboxeditem;

import de.bhelfert.gildedrose.inheritance.simple.Item;

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
