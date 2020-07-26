package de.bhelfert.gildedrose.inheritance.sophisticated.sortiment;

import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManualSortiment implements Sortiment {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManualSortiment.class);

    private static final Map<String, Class<? extends UnboxedItem>> sortiment = new HashMap<>();

    static {
        sortiment.put(AgedBrie.NAME, AgedBrie.class);
        sortiment.put(BackstagePass.NAME, BackstagePass.class);
        sortiment.put(StandardItem.NAME, StandardItem.class);
        sortiment.put(Sulfuras.NAME, Sulfuras.class);
    }

    public ManualSortiment() {
        LOGGER.info("sortiment: {}", sortiment.keySet());
    }

    @Override
    public Optional<Class<? extends UnboxedItem>> getUnboxedItemType(String itemName) {
        return Optional.ofNullable(sortiment.get(itemName));
    }
}
