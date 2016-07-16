package com.sevenlist.gildedrose.inheritance;

import com.sevenlist.gildedrose.inheritance.unboxeditem.*;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ItemsReceiptTest {

    @Test
    public void unboxesItemsWeSell() throws Exception {
        // given
        Item[] boxedItems = createItems(AgedBrie.NAME, BackstagePass.NAME, StandardItem.NAME, Sulfuras.NAME);

        // when
        List<UnboxedItem> unboxedItems = new ItemsReceipt().unboxItems(boxedItems);

        // then
        assertThat(unboxedItems).hasSize(4);
        unboxedItems.forEach(item -> assertThat(item).isOfAnyClassIn(AgedBrie.class, BackstagePass.class, StandardItem.class, Sulfuras.class));
    }

    @Test(expected = RuntimeException.class)
    public void throwsRuntimeExceptionWhenItemReceivedThatDoesNotBelongsToSortiment() throws Exception {
        // given
        Item[] unknownItem = createItems("not sold by us");

        // when
        new ItemsReceipt().unboxItems(unknownItem);
    }

    private Item[] createItems(String... names) {
        return Stream.of(names).map(this::createItem).toArray(Item[]::new);
    }

    private Item createItem(String name) {
        final int doesNotMatter = 0;
        return new Item(name, doesNotMatter, doesNotMatter);
    }
}