package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;
import org.junit.Test;

public class BackstagePassTest extends UnboxedItemTestCase {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    protected UnboxedItem unboxedItem(Item boxedItem) {
        return new BackstagePass(boxedItem);
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
}