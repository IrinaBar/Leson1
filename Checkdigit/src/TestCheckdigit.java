import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCheckdigit {
String my = new String("12345");

    @Test

    public void checksum() {
        assertEquals(7,Checkdigit.checksum( "4731248257"));
    }
}