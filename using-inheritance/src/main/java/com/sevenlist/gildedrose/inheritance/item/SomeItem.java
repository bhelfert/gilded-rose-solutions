package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;

public class SomeItem extends UnboxedItem {

    private static final int DEFAULT_MIN_QUALITY = 0;

    public SomeItem(Item item) {
        super(item);
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
