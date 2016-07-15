package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;
import org.junit.Test;

public class AgedBrieTest extends UnboxedItemTestCase {

    private static final String AGED_BRIE = "Aged Brie";

    @Override
    protected UnboxedItem unboxedItem(Item boxedItem) {
        return new AgedBrie(boxedItem);
    }

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
}