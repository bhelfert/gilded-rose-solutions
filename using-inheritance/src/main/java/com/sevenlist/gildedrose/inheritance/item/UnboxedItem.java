package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;

public abstract class UnboxedItem {

    private static final int DEFAULT_MAX_QUALITY = 50;

    protected int sellIn;
    protected int quality;

    public UnboxedItem(Item item) {
        sellIn = item.sellIn;
        quality = item.quality;
    }

    public abstract void updateSellInAndQuality();

    public final int getSellIn() {
        return sellIn;
    }

    public final int getQuality() {
        return quality;
    }

    protected final void decreaseSellIn() {
        sellIn--;
    }

    protected final void increaseQuality() {
        if (hasMaxQuality()) {
            return;
        }
        quality++;
    }

    private boolean hasMaxQuality() {
        return quality == DEFAULT_MAX_QUALITY;
    }

    protected final boolean hasPassedSellIn() {
        return sellIn < 0;
    }
}