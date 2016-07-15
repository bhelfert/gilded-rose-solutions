package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemsReceipt {

    private Map<String, Class<? extends UnboxedItem>> sortiment = new HashMap<>();

    public ItemsReceipt() {
        sortiment.put("Aged Brie", AgedBrie.class);
        sortiment.put("Backstage passes to a TAFKAL80ETC concert", BackstagePass.class);
        sortiment.put("Sulfuras, Hand of Ragnaros", Sulfuras.class);
        sortiment.put("Some Item", SomeItem.class);
    }

    public List<UnboxedItem> unboxItems(Item[] items) {
        return Arrays.stream(items).map(this::unboxItem).collect(Collectors.toList());
    }

    private UnboxedItem unboxItem(Item item) {
        try {
            return sortiment.get(item.name).getDeclaredConstructor(Item.class).newInstance(item);
        }
        catch (NullPointerException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("received item unknown to our sortiment: " + item, e);
        }
    }
}
