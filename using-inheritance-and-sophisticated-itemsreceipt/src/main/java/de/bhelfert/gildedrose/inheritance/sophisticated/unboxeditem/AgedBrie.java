package de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem;

import de.bhelfert.gildedrose.inheritance.sophisticated.Item;

public class AgedBrie extends AbstractUnboxedItem {

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
