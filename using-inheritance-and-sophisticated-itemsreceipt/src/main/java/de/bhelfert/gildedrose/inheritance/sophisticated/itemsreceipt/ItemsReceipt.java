package de.bhelfert.gildedrose.inheritance.sophisticated.itemsreceipt;

import de.bhelfert.gildedrose.inheritance.sophisticated.Item;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;

import java.util.List;

public interface ItemsReceipt {

    List<UnboxedItem> unboxItems(Item[] boxedItems);
}
