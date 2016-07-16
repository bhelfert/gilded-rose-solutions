package com.sevenlist.gildedrose.inheritance.unboxeditem;

import com.sevenlist.gildedrose.inheritance.Item;

public abstract class UnboxedItem {

    private static final int DEFAULT_MAX_QUALITY = 50;
    private static final int LOWEST_SELL_IN_VALUE_BEFORE_EXPIRATION = 0;

    protected int sellIn;
    protected int quality;

    public UnboxedItem(Item boxedItem) {
        sellIn = boxedItem.sellIn;
        quality = boxedItem.quality;
    }

    public final void updateSellInAndQuality() {
        updateSellIn();
        updateQuality();
    }

    protected void updateSellIn() {
        decreaseSellIn();
    }

    private void decreaseSellIn() {
        sellIn--;
    }

    protected abstract void updateQuality();

    public final int getSellIn() {
        return sellIn;
    }

    public final int getQuality() {
        return quality;
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
        return sellIn < LOWEST_SELL_IN_VALUE_BEFORE_EXPIRATION;
    }
}
