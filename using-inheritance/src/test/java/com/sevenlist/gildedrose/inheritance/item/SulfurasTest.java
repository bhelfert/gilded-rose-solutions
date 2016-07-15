package com.sevenlist.gildedrose.inheritance.item;

import com.sevenlist.gildedrose.inheritance.Item;
import org.junit.Test;

public class SulfurasTest extends UnboxedItemTestCase {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Override
    protected UnboxedItem unboxedItem(Item boxedItem) {
        return new Sulfuras(boxedItem);
    }

    @Test
    public void sulfuras_will_never_be_sold() throws Exception {
        assertNewSellInAndQuality(SULFURAS, 20, 80, 20, 80);
    }
}