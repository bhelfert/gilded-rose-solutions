package de.bhelfert.gildedrose.inheritance.simple.unboxeditem;

import de.bhelfert.gildedrose.inheritance.simple.Item;

import static org.assertj.core.api.Assertions.*;

public abstract class UnboxedItemTestCase {

    protected void assertNewSellInAndQuality(String itemName, int sellIn, int quality, int newSellIn, int newQuality) {
        // given
        Item boxedItem = new Item(itemName, sellIn, quality);
        UnboxedItem unboxedItem = unboxItem(boxedItem);

        // when
        unboxedItem.updateSellInAndQuality();

        // then
        assertThat(unboxedItem.getSellIn()).isEqualTo(newSellIn);
        assertThat(unboxedItem.getQuality()).isEqualTo(newQuality);
    }

    protected abstract UnboxedItem unboxItem(Item boxedItem);
}
