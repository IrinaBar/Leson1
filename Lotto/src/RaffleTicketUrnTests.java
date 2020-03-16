import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaffleTicketUrnTests {

    RaffleTicketUrn urn = new RaffleTicketUrn("Kindergarten-Tombola");

    @Test
    void enterLotteryItems() {
        urn.enterRaffleTickets(new RaffleTicket("Niete1"),
                new RaffleTicket("Niete2"),
                new RaffleTicket("Hauptgewinn")
        );
        assertEquals(3, urn.getNumberOfRaffleTickets());
        urn.enterRaffleTickets(new RaffleTicket("Niete3"),
                new RaffleTicket("Niete4")
        );
        assertEquals(5, urn.getNumberOfRaffleTickets());
    }

    @Test
    void drawItem() {
        for (int i = 1; i <= 5; i++) {
            urn.enterRaffleTickets(new RaffleTicket("Niete" + i));
            assertEquals(i, urn.getNumberOfRaffleTickets());
        }
        for (int i = 1; i <= 5; i++) {
            RaffleTicket item = urn.drawRaffleTicket();
            assertNotNull(item);
            assertEquals(5 - i, urn.getNumberOfRaffleTickets());
        }
        assertNull(urn.drawRaffleTicket());
    }
}