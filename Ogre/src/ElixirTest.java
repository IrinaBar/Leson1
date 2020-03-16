import org.junit.*;

import static org.junit.Assert.*;

public class ElixirTest {
    Elixir yo = new Elixir("YO");
    Elixir nonYo = new Elixir("AAA");
    @Test
    public void makesInvisible() {
        assertTrue("should will be invisible", yo.makesInvisible());
        assertFalse("Fiona should not be invisible", nonYo.makesInvisible());
    }
    @Test
    public void heal() {
        assertEquals("It will be the length of this characteristic", 2, yo.heal());
        assertEquals("It will be the length of this characteristic*2", 6,nonYo.heal());
    }
}

