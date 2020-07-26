package de.bhelfert.gildedrose.inheritance.sophisticated;

import de.bhelfert.gildedrose.inheritance.sophisticated.sortiment.ManualSortiment;
import de.bhelfert.gildedrose.inheritance.sophisticated.sortiment.Sortiment;

public class GildedRoseManualSortimentIT extends GildedRoseIntegrationTestCase {

    @Override
    protected Sortiment createSortiment() {
        return new ManualSortiment();
    }
}
