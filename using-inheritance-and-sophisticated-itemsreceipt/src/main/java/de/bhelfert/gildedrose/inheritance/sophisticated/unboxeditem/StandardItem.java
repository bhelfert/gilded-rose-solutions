package de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem;

import de.bhelfert.gildedrose.inheritance.sophisticated.Item;

public class StandardItem extends AbstractUnboxedItem {

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
