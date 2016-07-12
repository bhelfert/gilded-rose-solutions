package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;
import java.util.List;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemFactoryTest {

    private static final int DOES_NOT_MATTER = 0;

    @Test
    public void createsItemsFromInventory() throws Exception {
        // given
        Item[] items = {
                new Item("Aged Brie", DOES_NOT_MATTER, DOES_NOT_MATTER),
                new Item("Backstage passes to a TAFKAL80ETC concert", DOES_NOT_MATTER, DOES_NOT_MATTER),
                new Item("Sulfuras, Hand of Ragnaros", DOES_NOT_MATTER, DOES_NOT_MATTER),
                new Item("Some Item", DOES_NOT_MATTER, DOES_NOT_MATTER)
        };

        // when
        List<AbstractItem> itemList = new ItemFactory().createItems(items);

        // then
        assertThat(itemList).hasSize(4);
        itemList.forEach(item -> assertThat(item).isOfAnyClassIn(AgedBrie.class, BackstagePass.class, Sulfuras.class, SomeItem.class));
    }

    @Test(expected = RuntimeException.class)
    public void throwsRuntimeExceptionWhenItemDoesNotExistInInventory() throws Exception {
        // given
        Item[] items = { new Item("Does not exist", DOES_NOT_MATTER, DOES_NOT_MATTER) };

        // when
        new ItemFactory().createItems(items);
    }
}