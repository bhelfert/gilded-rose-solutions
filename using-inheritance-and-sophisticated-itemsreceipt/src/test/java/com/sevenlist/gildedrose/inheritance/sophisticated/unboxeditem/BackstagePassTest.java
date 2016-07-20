package com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem;

import com.sevenlist.gildedrose.inheritance.sophisticated.Item;
import org.junit.Test;

public class BackstagePassTest extends UnboxedItemTestCase {

    @Override
    protected UnboxedItem unboxItem(Item boxedItem) {
        return new BackstagePass(boxedItem);
    }

    @Test
    public void quality_is_50_at_max() throws Exception {
        assertNewSellInAndQuality(BackstagePass.NAME, 1, 50, 0, 50);
    }

    @Test
    public void quality_increases_while_aging() throws Exception {
        assertNewSellInAndQuality(BackstagePass.NAME, 11, 49, 10, 50);
    }

    @Test
    public void quality_increases_by_2_when_sellin_is_between_6_and_10_days() throws Exception {
        assertNewSellInAndQuality(BackstagePass.NAME, 10, 48, 9, 50);
    }

    @Test
    public void quality_increases_by_3_when_sellin_is_in_5_days_or_less() throws Exception {
        assertNewSellInAndQuality(BackstagePass.NAME, 5, 47, 4, 50);
    }

    @Test
    public void quality_is_0_after_sellin_has_passed() throws Exception {
        assertNewSellInAndQuality(BackstagePass.NAME, -1, 20, -2, 0);
    }
}