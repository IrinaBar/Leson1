import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamUrnTests {

    TeamsUrn urn = new TeamsUrn("WM 2022");

    @Test
    void enterLotteryItems() {
        urn.enterTeamFlags(new TeamFlag("Deutschland"),
                new TeamFlag("Italien"),
                new TeamFlag("Niederlande")
        );
        assertEquals(3, urn.getNumberOfTeamFlags());
        urn.enterTeamFlags(new TeamFlag("Argentinien"),
                new TeamFlag("Brasilien")
        );
        assertEquals(5, urn.getNumberOfTeamFlags());
    }

    @Test
    void drawItem() {
        for (int i = 1; i <= 5; i++) {
            urn.enterTeamFlags(new TeamFlag("Land" + i));
            assertEquals(i, urn.getNumberOfTeamFlags());
        }
        for (int i = 1; i <= 5; i++) {
            TeamFlag item = urn.drawTeamFlag();
            assertNotNull(item);
            assertEquals(5 - i, urn.getNumberOfTeamFlags());
        }
        assertNull(urn.drawTeamFlag());
    }
}