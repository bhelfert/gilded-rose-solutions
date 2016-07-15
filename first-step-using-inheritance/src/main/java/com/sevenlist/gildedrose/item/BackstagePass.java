package com.sevenlist.gildedrose.item;

import com.sevenlist.gildedrose.Item;

public class BackstagePass extends AbstractItem {

    private static final int SIX_DAYS = 6;
    private static final int ELEVEN_DAYS = 11;

    public BackstagePass(Item item) {
        super(item);
    }

    public void updateSellInAndQuality() {
        decreaseSellIn();
        if (hasPassedSellIn()) {
            makeWorthless();
            return;
        }
        increaseQualityUpToThreeValues();
    }

    private void makeWorthless() {
        quality = 0;
    }

    private void increaseQualityUpToThreeValues() {
        increaseQuality();
        if (isSellInLessThanElevenDays()) {
            increaseQuality();
        }
        if (isSellInLessThanSixDays()) {
            increaseQuality();
        }
    }

    private boolean isSellInLessThanElevenDays() {
        return sellIn < ELEVEN_DAYS;
    }

    private boolean isSellInLessThanSixDays() {
        return sellIn < SIX_DAYS;
    }
}
