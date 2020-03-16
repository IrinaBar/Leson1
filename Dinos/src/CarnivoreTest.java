import org.junit.Assert;
import org.junit.Test;

public class CarnivoreTest {
    Carnivore dead = new Carnivore(0, 20);
    Carnivore zombi = new Carnivore(0, 20);
    Carnivore thirst = new Carnivore(15, 5);

    Carnivore second = new Carnivore(7, 10);
    Carnivore second1 = new Carnivore(7, 10);

    Carnivore third = new Carnivore(20, 10);
    Herbivore weak = new Herbivore(5);
    Herbivore strong = new Herbivore(10);

    @Test
    public void TestisAlive() {
        Assert.assertEquals(false, dead.isAlive());
        Assert.assertEquals(true, thirst.isAlive());
    }


    @Test
    public void TestHerbivoreAttack() {
        strong.attack(weak);
        Assert.assertEquals(99, weak.healthPoints);
        strong.attack(thirst);
        Assert.assertEquals(15, thirst.healthPoints);

    }

    @Test
    public void TestCarnivoreAttack() {
        zombi.attack(dead);
        Assert.assertEquals(0,dead.healthPoints); //beide sind tod, weil healthPoints == 0 sind, passiert nichts;
        second.attack(second1);
        Assert.assertEquals(7, second1.healthPoints);//this healthPoints = other healthPoints, passiert nichts;
        third.attack(thirst);
        Assert.assertEquals(5, thirst.healthPoints); //third strength==10, thirst strength==5;
        Assert.assertEquals(20, third.healthPoints);//passiert mit seinem healthPoints nichts, bleibt unverendert
    }


}

