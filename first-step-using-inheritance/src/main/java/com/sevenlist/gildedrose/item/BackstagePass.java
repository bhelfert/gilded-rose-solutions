package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;

public class BackstagePass extends AbstractItem {

    public BackstagePass(Item item) {
        super(item);
    }

    public void updateSellInAndQuality() {
        decreaseSellIn();
        if (hasPassedSellIn()) {
            quality = 0;
            return;
        }
        increaseQuality();
        if (isSellInLessThanElevenDays()) {
            increaseQuality();
        }
        if (isSellInLessThanSixDays()) {
            increaseQuality();
        }
    }

    private boolean isSellInLessThanElevenDays() {
        return sellIn < 11;
    }

    private boolean isSellInLessThanSixDays() {
        return sellIn < 6;
    }
}
