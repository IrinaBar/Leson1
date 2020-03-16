import org.junit.Test;

import static org.junit.Assert.*;

public class OgreTest {
    Ogre shrek = new Ogre(100, 100, "green", 30, 40);
    Ogre fiona = new Ogre(200, 100, "red", 40, 60);
    Ogre monster = new Ogre(300, 100, "brown", 10, 90);
    Ogre dead = new Ogre(400, 100, "blue", -2, 10);

    @Test
    public void setColor() {
        shrek.setColor("red");
        assertEquals("red", shrek.getColor());
        assertNotEquals("green", shrek.getColor());
    }

    @Test
    public void meet() {
        shrek.meet(fiona);
        assertEquals(fiona, shrek.getCompanion());
        assertEquals(shrek, fiona.getCompanion());
        shrek.meet(monster);
        assertEquals(0, monster.getLifePoints());
        assertEquals(30, shrek.getLifePoints());
        assertEquals("black", monster.getColor());
    }

    @Test
    public void drinkElixir() {
        Elixir magic = new Elixir("X");
        shrek.drinkElixir(magic);
        assertEquals("white", shrek.getColor());
        dead.drinkElixir(magic);
        assertEquals("blue", dead.getColor());
        Elixir nonMagic = new Elixir("A");
        fiona.drinkElixir(nonMagic);
        assertEquals("red", fiona.getColor());
    }

    public void setLifePoints() {
        dead.setLifePoints(-1);
        assertEquals("black", dead.getColor());
    }

    public void getLifePoints() {
        assertEquals(0, dead.getLifePoints());
    }

}
