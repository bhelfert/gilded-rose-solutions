package com.sevenlist.gildedrose.inheritance.sophisticated.unboxeditem;

import com.sevenlist.gildedrose.inheritance.sophisticated.Item;
import org.junit.Test;

public class SulfurasTest extends UnboxedItemTestCase {

    @Override
    protected UnboxedItem unboxItem(Item boxedItem) {
        return new Sulfuras(boxedItem);
    }

    @Test
    public void is_never_sold() throws Exception {
        assertNewSellInAndQuality(Sulfuras.NAME, 20, 80, 20, 80);
    }
}