package de.bhelfert.gildedrose.inheritance.sophisticated;

import de.bhelfert.gildedrose.inheritance.sophisticated.itemsreceipt.GildedRoseItemsReceipt;
import de.bhelfert.gildedrose.inheritance.sophisticated.sortiment.Sortiment;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.AgedBrie;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.BackstagePass;
import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.UnboxedItem;
import java.util.List;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public abstract class GildedRoseIntegrationTestCase {

    private Sortiment sortiment = createSortiment();

    protected abstract Sortiment createSortiment();

    @Test
    public void updatesQuality() {
        // given
        Item agedBrieBoxed = new Item(AgedBrie.NAME, 1, 10);
        Item backstagePassesBoxed = new Item(BackstagePass.NAME, 1, 10);
        Item[] boxedItems = new Item[]{agedBrieBoxed, backstagePassesBoxed};

        // and
        GildedRose gildedRose = new GildedRose(new GildedRoseItemsReceipt(sortiment), boxedItems);

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
