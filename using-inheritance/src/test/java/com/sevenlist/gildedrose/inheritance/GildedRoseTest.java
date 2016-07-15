package com.sevenlist.gildedrose.inheritance;

import com.sevenlist.gildedrose.inheritance.item.UnboxedItem;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String SOME_ITEM = "Some Item";

    @Test
    public void aged_brie_quality_is_50_at_max() throws Exception {
        assertNewSellInAndQuality(AGED_BRIE, 1, 50, 0, 50);
    }

    @Test
    public void aged_brie_quality_increases_while_aging() throws Exception {
        assertNewSellInAndQuality(AGED_BRIE, 1, 49, 0, 50);
    }

    @Test
    public void aged_brie_quality_increases_by_2_while_sellin_has_passed() throws Exception {
        assertNewSellInAndQuality(AGED_BRIE, -1, 48, -2, 50);
    }

    @Test
    public void backstage_passes_quality_is_50_at_max() throws Exception {
        assertNewSellInAndQuality(BACKSTAGE_PASSES, 1, 50, 0, 50);
    }

    @Test
    public void backstage_passes_quality_increases_while_aging() throws Exception {
        assertNewSellInAndQuality(BACKSTAGE_PASSES, 11, 49, 10, 50);
    }

    @Test
    public void backstage_passes_quality_increases_by_2_when_sellin_is_between_6_and_10_days() throws Exception {
        assertNewSellInAndQuality(BACKSTAGE_PASSES, 10, 48, 9, 50);
    }

    @Test
    public void backstage_passes_quality_increases_by_3_when_sellin_is_in_5_days_or_less() throws Exception {
        assertNewSellInAndQuality(BACKSTAGE_PASSES, 5, 47, 4, 50);
    }

    @Test
    public void backstage_passes_quality_is_0_after_sellin_has_passed() throws Exception {
        assertNewSellInAndQuality(BACKSTAGE_PASSES, -1, 20, -2, 0);
    }

    @Test
    public void sulfuras_will_never_be_sold() throws Exception {
        assertNewSellInAndQuality(SULFURAS, 20, 80, 20, 80);
    }

    @Test
    public void some_item_quality_degrades() throws Exception {
        assertNewSellInAndQuality(SOME_ITEM, 1, 1, 0, 0);
    }

    @Test
    public void some_item_quality_degrades_twice_as_fast_when_sellin_has_passed() throws Exception {
        assertNewSellInAndQuality(SOME_ITEM, -1, 2, -2, 0);
    }

    @Test
    public void some_item_quality_is_0_at_min() throws Exception {
        assertNewSellInAndQuality(SOME_ITEM, 1, 0, 0, 0);
    }

    private void assertNewSellInAndQuality(String itemName, int sellIn, int quality, int newSellIn, int newQuality) {
        // given
        Item boxedItem = new Item(itemName, sellIn, quality);
        GildedRose gildedRose = new GildedRose(new Item[] { boxedItem });

        // when
        gildedRose.updateQuality();

        // then
        UnboxedItem unboxedItem = gildedRose.getItems().get(0);
        assertThat(unboxedItem.getSellIn()).isEqualTo(newSellIn);
        assertThat(unboxedItem.getQuality()).isEqualTo(newQuality);
    }
}