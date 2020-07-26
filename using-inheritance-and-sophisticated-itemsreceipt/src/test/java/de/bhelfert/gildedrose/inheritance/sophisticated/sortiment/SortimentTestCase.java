package de.bhelfert.gildedrose.inheritance.sophisticated.sortiment;

import de.bhelfert.gildedrose.inheritance.sophisticated.unboxeditem.AgedBrie;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public abstract class SortimentTestCase {

    private Sortiment sortiment = createSortiment();

    protected abstract Sortiment createSortiment();

    @Test
    public void returns_unboxed_item_type_if_item_name_is_known() throws Exception {
        assertThat(sortiment.getUnboxedItemType(AgedBrie.NAME)).isPresent();
    }

    @Test
    public void returns_empty_unboxed_item_type_if_item_name_is_unknown() throws Exception {
        assertThat(sortiment.getUnboxedItemType("unknownItemName")).isEmpty();
    }
}
