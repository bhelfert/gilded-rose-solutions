package com.sevenlist.gildedrose.inheritance;

import com.sevenlist.gildedrose.inheritance.item.ItemsReceipt;
import com.sevenlist.gildedrose.inheritance.item.UnboxedItem;

import java.util.Collections;
import java.util.List;

class GildedRose {

    private List<UnboxedItem> unboxedItems;

    public GildedRose(Item[] boxedItems) {
        unboxedItems = new ItemsReceipt().unboxItems(boxedItems);
    }

    public void updateQuality() {
        unboxedItems.forEach(item -> item.updateSellInAndQuality());
    }

    public List<UnboxedItem> getUnboxedItems() {
        return Collections.unmodifiableList(unboxedItems);
    }
}
