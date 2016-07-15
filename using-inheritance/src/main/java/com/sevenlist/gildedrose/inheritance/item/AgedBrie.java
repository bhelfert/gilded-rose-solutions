package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;

public class AgedBrie extends UnboxedItem {

    public AgedBrie(Item item) {
        super(item);
    }

    public void updateSellInAndQuality() {
        decreaseSellIn();
        increaseQuality();
        if (hasPassedSellIn()) {
            increaseQuality();
        }
    }
}
