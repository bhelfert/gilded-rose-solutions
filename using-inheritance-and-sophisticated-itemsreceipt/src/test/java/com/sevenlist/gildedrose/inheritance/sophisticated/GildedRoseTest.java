package com.sevenlist.gildedrose.inheritance.sophisticated;

import com.sevenlist.gildedrose.inheritance.sophisticated.itemsreceipt.ItemsReceipt;
import com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem.StandardItem;
import com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {

    @Mock
    private ItemsReceipt itemsReceiptMock;

    @Test
    public void uses_items_receipt_to_unbox_items() throws Exception {
        // given
        Item[] boxedItems = new Item[]{new Item(StandardItem.NAME, 23, 42)};

        // when
        new GildedRose(itemsReceiptMock, boxedItems);

        // then
        verify(itemsReceiptMock).unboxItems(boxedItems);
    }

    @Test
    public void updates_sell_in_and_quality_on_every_item() throws Exception {
        // given
        UnboxedItem unboxedItemMock = mock(UnboxedItem.class);
        when(itemsReceiptMock.unboxItems(anyObject())).thenReturn(Arrays.asList(unboxedItemMock, unboxedItemMock));

        // and
        Item[] doesNotMatter = new Item[0];

        // when
        new GildedRose(itemsReceiptMock, doesNotMatter).updateQuality();

        // then
        verify(unboxedItemMock, times(2)).updateSellInAndQuality();
    }
}