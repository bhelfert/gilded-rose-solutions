package com.sevenlist.gildedrose.inheritance;

import com.sevenlist.gildedrose.inheritance.item.ItemsReceipt;
import com.sevenlist.gildedrose.inheritance.item.UnboxedItem;

import java.util.Collections;
import java.util.List;

class GildedRose {

    private List<UnboxedItem> items;

    public GildedRose(Item[] items) {
        this.items = new ItemsReceipt().unboxItems(items);
    }

    public void updateQuality() {
        items.forEach(item -> item.updateSellInAndQuality());
    }

    public List<UnboxedItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}