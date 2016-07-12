package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemFactory {

    private Map<String, Class<? extends AbstractItem>> inventory = new HashMap<>();

    public ItemFactory() {
        inventory.put("Aged Brie", AgedBrie.class);
        inventory.put("Backstage passes to a TAFKAL80ETC concert", BackstagePass.class);
        inventory.put("Sulfuras, Hand of Ragnaros", Sulfuras.class);
        inventory.put("Some Item", SomeItem.class);
    }

    public List<AbstractItem> createItems(Item[] items) {
        return Arrays.stream(items).map(this::createItem).collect(Collectors.toList());
    }

    private AbstractItem createItem(Item item) {
        try {
            return inventory.get(item.name).getDeclaredConstructor(Item.class).newInstance(item);
        } catch (NullPointerException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("could not create item from inventory: " + item, e);
        }
    }
}
