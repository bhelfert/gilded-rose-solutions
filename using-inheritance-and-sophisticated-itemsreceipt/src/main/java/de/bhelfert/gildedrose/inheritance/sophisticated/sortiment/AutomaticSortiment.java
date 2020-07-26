package de.bhelfert.gildedrose.inheritance.sophisticated.sortiment;

import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;
import io.atlassian.fugue.Pair;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AutomaticSortiment implements Sortiment {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutomaticSortiment.class);

    private final Map<String, Class<? extends UnboxedItem>> itemNameToClass = autoBuildSortiment();

    private Map<String, Class<? extends UnboxedItem>> autoBuildSortiment() {
        Set<Class<? extends UnboxedItem>> unboxedItemClasses = getUnboxedItemClassesInClasspath();
        Map<String, Class<? extends UnboxedItem>> sortiment = unboxedItemClasses.stream()
                .map(clazz -> Pair.pair(getStaticNameField(clazz), clazz))
                .filter(pair -> pair.left().isPresent())
                .collect(Collectors.toMap(pair -> pair.left().get(), Pair::right));
        LOGGER.info("sortiment: {}", sortiment.keySet());
        return sortiment;
    }

    private Set<Class<? extends UnboxedItem>> getUnboxedItemClassesInClasspath() {
        Reflections reflections = new Reflections("de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem");
        return reflections.getSubTypesOf(UnboxedItem.class);
    }

    private Optional<String> getStaticNameField(Class<? extends UnboxedItem> itemClass) {
        try {
            return Optional.of((String) itemClass.getDeclaredField("NAME").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LOGGER.warn("unboxed item of type " + itemClass.getSimpleName() + " cannot be added to sortiment; " +
                    "to fix this please declare a 'public static final String NAME' field in that class", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Class<? extends UnboxedItem>> getUnboxedItemType(String itemName) {
        return Optional.ofNullable(itemNameToClass.get(itemName));
    }
}
