package com.sevenlist.gildedrose;

import com.sevenlist.gildedrose.item.AbstractItem;
import com.sevenlist.gildedrose.item.ItemFactory;
import java.util.Collections;
import java.util.List;

class GildedRose {

    private List<AbstractItem> items;

    public GildedRose(Item[] items) {
        this.items = new ItemFactory().createItems(items);
    }

    public void updateQuality() {
        items.forEach(item -> item.updateSellInAndQuality());
    }

    public List<AbstractItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
