package de.bhelfert.gildedrose.inheritance.simple.unboxeditem;

import de.bhelfert.gildedrose.inheritance.simple.Item;

public class StandardItem extends UnboxedItem {

    public static final String NAME = "Standard Item";

    private static final int DEFAULT_MIN_QUALITY = 0;

    public StandardItem(Item boxedItem) {
        super(boxedItem);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
        if (hasPassedSellIn()) {
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        if (hasMinQuality()) {
            return;
        }
        quality--;
    }

    private boolean hasMinQuality() {
        return quality == DEFAULT_MIN_QUALITY;
    }
}
