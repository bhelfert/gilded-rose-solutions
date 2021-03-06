package de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem;

import de.bhelfert.gildedrose.inheritance.sophisticated.Item;

public abstract class AbstractUnboxedItem implements UnboxedItem {

    private static final int DEFAULT_MAX_QUALITY = 50;
    private static final int LOWEST_SELL_IN_VALUE_BEFORE_EXPIRATION = 0;

    protected int sellIn;
    protected int quality;

    public AbstractUnboxedItem(Item boxedItem) {
        sellIn = boxedItem.sellIn;
        quality = boxedItem.quality;
    }

    @Override
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

    @Override
    public final int getSellIn() {
        return sellIn;
    }

    @Override
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(sellIn: " + sellIn + ", quality: " + quality + ")";
    }
}
