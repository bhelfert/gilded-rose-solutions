package com.sevenlist.gildedrose.inheritance.sophisticated;

import com.sevenlist.gildedrose.inheritance.sophisticated.sortiment.AutomaticSortiment;
import com.sevenlist.gildedrose.inheritance.sophisticated.sortiment.Sortiment;

public class GildedRoseAutomaticSortimentIT extends GildedRoseIntegrationTestCase {

    @Override
    protected Sortiment createSortiment() {
        return new AutomaticSortiment();
    }
}
