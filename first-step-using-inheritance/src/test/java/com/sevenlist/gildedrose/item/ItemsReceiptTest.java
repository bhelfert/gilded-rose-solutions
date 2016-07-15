package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemsReceiptTest {

    private static final int DOES_NOT_MATTER = 0;

    @Test
    public void unboxesItemsWeSell() throws Exception {
        // given
        Item[] boxedItems = {
                new Item("Aged Brie", DOES_NOT_MATTER, DOES_NOT_MATTER),
                new Item("Backstage passes to a TAFKAL80ETC concert", DOES_NOT_MATTER, DOES_NOT_MATTER),
                new Item("Sulfuras, Hand of Ragnaros", DOES_NOT_MATTER, DOES_NOT_MATTER),
                new Item("Some Item", DOES_NOT_MATTER, DOES_NOT_MATTER)
        };

        // when
        List<UnboxedItem> unboxedItems = new ItemsReceipt().unboxItems(boxedItems);

        // then
        assertThat(unboxedItems).hasSize(4);
        unboxedItems.forEach(item -> assertThat(item).isOfAnyClassIn(AgedBrie.class, BackstagePass.class, Sulfuras.class, SomeItem.class));
    }

    @Test(expected = RuntimeException.class)
    public void throwsRuntimeExceptionWhenItemReceivedThatIsNotSoldByUs() throws Exception {
        // given
        Item[] boxedNotSoldByUsItem = { new Item("not sold by us", DOES_NOT_MATTER, DOES_NOT_MATTER) };

        // when
        new ItemsReceipt().unboxItems(boxedNotSoldByUsItem);
    }
}