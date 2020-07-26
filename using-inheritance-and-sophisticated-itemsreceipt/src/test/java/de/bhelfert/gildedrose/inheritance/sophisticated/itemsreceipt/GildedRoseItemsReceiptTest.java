package de.bhelfert.gildedrose.inheritance.sophisticated.itemsreceipt;

import de.bhelfert.gildedrose.inheritance.sophisticated.Item;
import de.bhelfert.gildedrose.inheritance.sophisticated.sortiment.Sortiment;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.AgedBrie;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.StandardItem;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.Sulfuras;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseItemsReceiptTest {

    @Mock
    private Sortiment sortimentMock;

    @InjectMocks
    private GildedRoseItemsReceipt itemsReceipt;

    @Test
    public void unboxes_items_we_sell() throws Exception {
        // given
        Item[] boxedItems = createBoxedItems(StandardItem.NAME, Sulfuras.NAME);

        // and
        when(sortimentMock.getUnboxedItemType(StandardItem.NAME)).thenReturn(Optional.of(StandardItem.class));
        when(sortimentMock.getUnboxedItemType(Sulfuras.NAME)).thenReturn(Optional.of(Sulfuras.class));

        // when
        List<UnboxedItem> unboxedItems = itemsReceipt.unboxItems(boxedItems);

        // then
        assertThat(unboxedItems).hasSize(2);
        unboxedItems.forEach(item -> assertThat(item).isOfAnyClassIn(StandardItem.class, Sulfuras.class));
    }

    @Test
    public void unboxes_items_even_if_an_unknown_is_among_them() throws Exception {
        // given
        final String unknownItemName = "not sold by us";
        Item[] boxedItems = createBoxedItems(AgedBrie.NAME, unknownItemName);

        // and
        when(sortimentMock.getUnboxedItemType(AgedBrie.NAME)).thenReturn(Optional.of(AgedBrie.class));
        when(sortimentMock.getUnboxedItemType(unknownItemName)).thenReturn(Optional.empty());

        // when
        List<UnboxedItem> unboxedItems = itemsReceipt.unboxItems(boxedItems);

        // then
        assertThat(unboxedItems).hasSize(1);
        assertThat(unboxedItems.get(0)).isInstanceOf(AgedBrie.class);
    }

    public Item[] createBoxedItems(String... names) {
        return Stream.of(names).map(this::createBoxedItem).toArray(Item[]::new);
    }

    private Item createBoxedItem(String name) {
        final int doesNotMatter = 0;
        return new Item(name, doesNotMatter, doesNotMatter);
    }
}
