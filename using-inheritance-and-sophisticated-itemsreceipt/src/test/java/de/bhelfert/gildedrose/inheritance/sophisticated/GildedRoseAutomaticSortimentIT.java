package de.bhelfert.gildedrose.inheritance.sophisticated;

import de.bhelfert.gildedrose.inheritance.sophisticated.sortiment.AutomaticSortiment;
import de.bhelfert.gildedrose.inheritance.sophisticated.sortiment.Sortiment;

public class GildedRoseAutomaticSortimentIT extends GildedRoseIntegrationTestCase {

    @Override
    protected Sortiment createSortiment() {
        return new AutomaticSortiment();
    }
}
