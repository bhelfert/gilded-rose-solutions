package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;

public class Sulfuras extends AbstractItem {

    public Sulfuras(Item item) {
        super(item);
    }

    public void updateSellInAndQuality() {
        // will never be sold and never decreases in quality
    }
}
