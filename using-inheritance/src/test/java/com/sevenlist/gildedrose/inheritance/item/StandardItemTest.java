package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;
import org.junit.Test;

public class StandardItemTest extends UnboxedItemTestCase {

    @Override
    protected UnboxedItem unboxItem(Item boxedItem) {
        return new StandardItem(boxedItem);
    }

    @Test
    public void standard_item_quality_degrades() throws Exception {
        assertNewSellInAndQuality(StandardItem.NAME, 1, 1, 0, 0);
    }

    @Test
    public void standard_item_quality_degrades_twice_as_fast_when_sellin_has_passed() throws Exception {
        assertNewSellInAndQuality(StandardItem.NAME, -1, 2, -2, 0);
    }

    @Test
    public void standard_item_quality_is_0_at_min() throws Exception {
        assertNewSellInAndQuality(StandardItem.NAME, 1, 0, 0, 0);
    }
}