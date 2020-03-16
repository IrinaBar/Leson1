
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class PznCheckerTest {

    @Parameterized.Parameters(name = "ziffern={0} vollstaendigePZN => {1}")
    public static Iterable<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"0487780", "04877800"},
                {"0158024", "01580241"},
                {"0762658", "07626582"},
                {"0649394", "06493943"},
                {"0435625", "04356254"},
                {"0122897", "01228975"},
                {"0350794", "03507946"},
                {"1421156", "14211568"},
                {"0279928", "02799289"},
                {"01580241", ""},
                {"0815", ""},
                {"", ""},
        });
    }

    @Parameterized.Parameter(0)
    public String givenPrefix;
    @Parameterized.Parameter(1)
    public String wantCheckdigit;


    @Test(timeout = 100)
    public void testPzn() {
        assertEquals(wantCheckdigit, PznChecker.pznCheckDigit(givenPrefix));
    }

}
