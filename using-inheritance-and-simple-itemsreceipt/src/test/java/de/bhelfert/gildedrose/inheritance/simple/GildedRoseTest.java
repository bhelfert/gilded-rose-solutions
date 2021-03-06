package de.bhelfert.gildedrose.inheritance.simple;

import de.bhelfert.gildedrose.inheritance.simple.unboxeditem.AgedBrie;
import de.bhelfert.gildedrose.inheritance.simple.unboxeditem.BackstagePass;
import de.bhelfert.gildedrose.inheritance.simple.unboxeditem.UnboxedItem;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    public void updatesQuality() {
        // given
        Item agedBrieBoxed = new Item(AgedBrie.NAME, 1, 10);
        Item backstagePassesBoxed = new Item(BackstagePass.NAME, 1, 10);
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
