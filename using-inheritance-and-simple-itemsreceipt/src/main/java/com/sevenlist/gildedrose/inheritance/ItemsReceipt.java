package com.sevenlist.gildedrose.inheritance;

import com.sevenlist.gildedrose.inheritance.unboxeditem.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemsReceipt {

    private Map<String, Class<? extends UnboxedItem>> sortiment = new HashMap<>();

    public ItemsReceipt() {
        sortiment.put(AgedBrie.NAME, AgedBrie.class);
        sortiment.put(BackstagePass.NAME, BackstagePass.class);
        sortiment.put(StandardItem.NAME, StandardItem.class);
        sortiment.put(Sulfuras.NAME, Sulfuras.class);
    }

    public List<UnboxedItem> unboxItems(Item[] items) {
        return Stream.of(items).map(this::unboxItem).collect(Collectors.toList());
    }

    private UnboxedItem unboxItem(Item item) {
        try {
            return sortiment.get(item.name).getDeclaredConstructor(Item.class).newInstance(item);
        }
        catch (NullPointerException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("received unboxeditem unknown to our sortiment: " + item, e);
        }
    }
}
