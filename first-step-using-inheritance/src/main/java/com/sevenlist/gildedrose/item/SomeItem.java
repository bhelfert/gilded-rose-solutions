package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;

public class SomeItem extends AbstractItem {

    private static final int DEFAULT_MIN_QUALITY = 0;

    public SomeItem(Item item) {
        super(item);
    }

    public void updateSellInAndQuality() {
        decreaseSellIn();
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
