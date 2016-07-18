package com.sevenlist.gildedrose.inheritance.simple.unboxeditem;

import com.sevenlist.gildedrose.inheritance.simple.Item;

public class BackstagePass extends UnboxedItem {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    private static final int SIX_DAYS = 6;
    private static final int ELEVEN_DAYS = 11;

    public BackstagePass(Item boxedItem) {
        super(boxedItem);
    }

    @Override
    protected void updateQuality() {
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
