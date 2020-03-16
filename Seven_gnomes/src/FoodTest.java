import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FoodTest {

    @Parameterized.Parameters(name = "Food = {0} posisonous => {1} calories => {2}")
    public static Iterable<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {new Mushroom(), true, 0},
                {new Fruit(100), false, 100},
                {new Fruit(50), false, 50},
                {new Vegetable("Karotte", 15, 25), false, 15 * 25},
                {new Vegetable("Kohl", 10, 20), false, 10 * 20},
                {new Vegetable("Blumenkohl", 10, 20), false, 10 * 20},
                {new Vegetable("", 2, 3), true, 2 * 3},
                {new Vegetable("Artischocke", 2, 3), true, 2 * 3},
        });
    }

    @Parameterized.Parameter(0)
    public Food givenFood;
    @Parameterized.Parameter(1)
    public boolean wantPoisonous;
    @Parameterized.Parameter(2)
    public int wantTotalCalories;

    @Test
    public void isPoisonous() {
        assertEquals(wantPoisonous, givenFood.isPoisonous());
    }

    @Test
    public void getCalories() {
        assertEquals(wantTotalCalories, givenFood.calories());
    }

}