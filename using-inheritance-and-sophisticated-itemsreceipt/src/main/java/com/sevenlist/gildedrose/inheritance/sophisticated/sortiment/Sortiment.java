package com.sevenlist.gildedrose.inheritance.sophisticated.sortiment;

import com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;
import java.util.Optional;

public interface Sortiment {

    Optional<Class<? extends UnboxedItem>> getUnboxedItemType(String itemName);
}
