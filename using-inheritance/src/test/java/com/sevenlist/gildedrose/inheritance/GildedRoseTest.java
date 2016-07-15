package com.sevenlist.gildedrose.inheritance;

import com.sevenlist.gildedrose.inheritance.item.UnboxedItem;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void updatesQuality() {
        // given
        Item agedBrieBoxed = new Item(AGED_BRIE, 1, 10);
        Item backstagePassesBoxed = new Item(BACKSTAGE_PASSES, 1, 10);
        Item[] boxedItems = new Item[] { agedBrieBoxed, backstagePassesBoxed };
        GildedRose gildedRose = new GildedRose(boxedItems);

        // when
        gildedRose.updateQuality();
        List<UnboxedItem> unboxedItems = gildedRose.getUnboxedItems();

        // then
        UnboxedItem agedBrieUnboxed = unboxedItems.get(0);
        assertUnboxedItemToHaveSellInAndQuality(agedBrieUnboxed, 0, 11);

        // and
        UnboxedItem backstagePassesUnboxed = unboxedItems.get(1);
        assertUnboxedItemToHaveSellInAndQuality(backstagePassesUnboxed, 0, 13);
    }

    private void assertUnboxedItemToHaveSellInAndQuality(UnboxedItem unboxedItem, int expectedSellIn, int expectedQuality) {
        assertThat(unboxedItem.getSellIn()).isEqualTo(expectedSellIn);
        assertThat(unboxedItem.getQuality()).isEqualTo(expectedQuality);
    }
}