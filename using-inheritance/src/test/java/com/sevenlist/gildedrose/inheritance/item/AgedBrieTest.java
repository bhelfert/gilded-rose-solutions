package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;
import org.junit.Test;

public class AgedBrieTest extends UnboxedItemTestCase {

    @Override
    protected UnboxedItem unboxItem(Item boxedItem) {
        return new AgedBrie(boxedItem);
    }

    @Test
    public void quality_is_50_at_max() throws Exception {
        assertNewSellInAndQuality(AgedBrie.NAME, 1, 50, 0, 50);
    }

    @Test
    public void quality_increases_while_aging() throws Exception {
        assertNewSellInAndQuality(AgedBrie.NAME, 1, 49, 0, 50);
    }

    @Test
    public void quality_increases_by_2_while_sellin_has_passed() throws Exception {
        assertNewSellInAndQuality(AgedBrie.NAME, -1, 48, -2, 50);
    }
}