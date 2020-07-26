package de.bhelfert.gildedrose.inheritance.sophisticated.sortiment;

public class ManualSortimentTest extends SortimentTestCase {

    @Override
    protected Sortiment createSortiment() {
        return new ManualSortiment();
    }
}
