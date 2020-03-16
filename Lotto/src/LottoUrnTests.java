import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoUrnTests {

    LottoUrn urn = new LottoUrn("6 aus 49");

    @Test
    void testEnterLottoItems() {
        urn.enterLottoItems(new LottoItem("1"),
                new LottoItem("2"),
                new LottoItem("49")
        );
        assertEquals(3, urn.getNumberOfLottoItems());
        urn.enterLottoItems(new LottoItem("3"),
                new LottoItem("4")
        );
        assertEquals(5, urn.getNumberOfLottoItems());
    }

    @Test
    void testDrawItem() {
        for (int i = 1; i <= 5; i++) {
            urn.enterLottoItems(new LottoItem("" + i));
            assertEquals(i, urn.getNumberOfLottoItems());
        }
        for (int i = 1; i <= 5; i++) {
            LottoItem item = urn.drawLottoItem();
            assertNotNull(item);
            assertEquals(5 - i, urn.getNumberOfLottoItems());
        }
        assertNull(urn.drawLottoItem());
    }
}