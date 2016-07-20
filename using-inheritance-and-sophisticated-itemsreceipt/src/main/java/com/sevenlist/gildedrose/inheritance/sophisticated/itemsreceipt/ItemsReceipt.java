package com.sevenlist.gildedrose.inheritance.sophisticated.itemsreceipt;

import com.sevenlist.gildedrose.inheritance.sophisticated.Item;
import com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;
import java.util.List;

public interface ItemsReceipt {

    List<UnboxedItem> unboxItems(Item[] boxedItems);
}
