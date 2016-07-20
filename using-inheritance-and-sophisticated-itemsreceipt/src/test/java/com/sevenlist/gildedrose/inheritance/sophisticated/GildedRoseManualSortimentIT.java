package com.sevenlist.gildedrose.inheritance.sophisticated;

import com.sevenlist.gildedrose.inheritance.sophisticated.sortiment.ManualSortiment;
import com.sevenlist.gildedrose.inheritance.sophisticated.sortiment.Sortiment;

public class GildedRoseManualSortimentIT extends GildedRoseIntegrationTestCase {

    @Override
    protected Sortiment createSortiment() {
        return new ManualSortiment();
    }
}
