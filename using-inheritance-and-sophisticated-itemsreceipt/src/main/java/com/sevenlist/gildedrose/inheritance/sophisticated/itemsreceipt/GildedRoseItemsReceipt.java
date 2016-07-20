package com.sevenlist.gildedrose.inheritance.sophisticated.itemsreceipt;

import com.sevenlist.gildedrose.inheritance.sophisticated.Item;
import com.sevenlist.gildedrose.inheritance.sophisticated.sortiment.Sortiment;
import com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.stream.Collectors.toList;

public class GildedRoseItemsReceipt implements ItemsReceipt {

    private static final Logger LOGGER = LoggerFactory.getLogger(GildedRoseItemsReceipt.class);

    private final Sortiment sortiment;

    public GildedRoseItemsReceipt(Sortiment sortiment) {
        this.sortiment = sortiment;
    }

    @Override
    public List<UnboxedItem> unboxItems(Item[] boxedItems) {
        List<UnboxedItem> unboxedItems = Stream.of(boxedItems).map(this::unboxItem).filter(Optional::isPresent).map(Optional::get).collect(toList());
        LOGGER.info("unboxed items: {}", unboxedItems);
        return unboxedItems;
    }

    private Optional<UnboxedItem> unboxItem(Item boxedItem) {
        Optional<Class<? extends UnboxedItem>> unboxedItemType = sortiment.getUnboxedItemType(boxedItem.name);
        if (!unboxedItemType.isPresent()) {
            LOGGER.warn("could not unbox item: {}", boxedItem);
            return Optional.empty();
        }

        try {
            return Optional.of(unboxedItemType.get().getDeclaredConstructor(Item.class).newInstance(boxedItem));
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            LOGGER.warn("could not unbox item: {}", boxedItem, e);
            return Optional.empty();
        }
    }
}
