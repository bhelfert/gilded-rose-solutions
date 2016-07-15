package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemsReceipt {

    private Map<String, Class<? extends UnboxedItem>> itemsWeSell = new HashMap<>();

    public ItemsReceipt() {
        itemsWeSell.put("Aged Brie", AgedBrie.class);
        itemsWeSell.put("Backstage passes to a TAFKAL80ETC concert", BackstagePass.class);
        itemsWeSell.put("Sulfuras, Hand of Ragnaros", Sulfuras.class);
        itemsWeSell.put("Some Item", SomeItem.class);
    }

    public List<UnboxedItem> unboxItems(Item[] items) {
        return Arrays.stream(items).map(this::unboxItem).collect(Collectors.toList());
    }

    private UnboxedItem unboxItem(Item item) {
        try {
            return itemsWeSell.get(item.name).getDeclaredConstructor(Item.class).newInstance(item);
        }
        catch (NullPointerException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("received item that we do not sell: " + item, e);
        }
    }
}
