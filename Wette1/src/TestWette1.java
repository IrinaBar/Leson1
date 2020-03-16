import org.junit.Assert;
import org.junit.Test;

public class TestWette1 {
    String bana = new String("banana");

    @Test
    public void TestLastTwo() {
        Assert.assertEquals("banaan", bana.lastTwo());
    }
}


