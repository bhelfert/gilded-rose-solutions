package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;

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
