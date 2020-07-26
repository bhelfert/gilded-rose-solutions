package de.bhelfert.gildedrose.inheritance.sophisticated.sortiment;

import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;

import java.util.Optional;

public interface Sortiment {

    Optional<Class<? extends UnboxedItem>> getUnboxedItemType(String itemName);
}
