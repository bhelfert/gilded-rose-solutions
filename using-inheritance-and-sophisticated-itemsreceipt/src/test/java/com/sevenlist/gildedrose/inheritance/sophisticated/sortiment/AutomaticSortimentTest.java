package com.sevenlist.gildedrose.inheritance.sophisticated.sortiment;

public class AutomaticSortimentTest extends SortimentTestCase {

    @Override
    protected Sortiment createSortiment() {
        return new AutomaticSortiment();
    }
}