package de.bhelfert.gildedrose.inheritance.sophisticated;

import de.bhelfert.gildedrose.inheritance.sophisticated.itemsreceipt.ItemsReceipt;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;

import java.util.Collections;
import java.util.List;

public class GildedRose {

    private List<UnboxedItem> unboxedItems;

    public GildedRose(ItemsReceipt itemsReceipt, Item[] boxedItems) {
        unboxedItems = itemsReceipt.unboxItems(boxedItems);
    }

    public void updateQuality() {
        unboxedItems.forEach(item -> item.updateSellInAndQuality());
    }

    public List<UnboxedItem> getUnboxedItems() {
        return Collections.unmodifiableList(unboxedItems);
    }
}
