package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;
import org.junit.Test;

public class SomeItemTest extends UnboxedItemTestCase {

    private static final String SOME_ITEM = "Some Item";

    @Override
    protected UnboxedItem unboxedItem(Item boxedItem) {
        return new SomeItem(boxedItem);
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
}