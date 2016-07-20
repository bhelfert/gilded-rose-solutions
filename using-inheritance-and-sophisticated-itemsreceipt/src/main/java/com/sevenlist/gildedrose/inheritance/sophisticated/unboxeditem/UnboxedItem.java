package com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem;

/**
 * Implementations need to add a "public static final String NAME" constant to be automatically added to a sortiment.
 */
public interface UnboxedItem {

    void updateSellInAndQuality();

    int getSellIn();

    int getQuality();
}
