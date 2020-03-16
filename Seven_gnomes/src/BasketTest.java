import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    @Test
    public void addToBasket() {
        Basket basket = makeBasket(10, 9);
        assertEquals(45, basket.calculateCalories());
        assertFalse(basket.addFood(new Mushroom()));
        assertEquals(45, basket.calculateCalories());
        assertFalse(basket.addFood(new Vegetable("Artischocke", 10, 20)));
        assertEquals(45, basket.calculateCalories());
    }

    @Test
    public void isFull() {
        Basket basket = makeBasket(10, 9);
        assertFalse(basket.isFull());
        basket = makeBasket(10, 10);
        assertTrue(basket.isFull());
    }

    /**
     * Hilfsmethode, um einen definierten Basket herzustellen.
     *
     * @param size Groesse des Korbs.
     * @param fill Fuellgrad
     * @returnBasket der Groesse {@code size}, mit {@code fill} Elementen gefuellt.
     */
    private Basket makeBasket(final int size, final int fill) {
        Basket basket = new Basket(size);
        for (int item = 1; item <= fill; item++) {
            assertTrue("basket of size " + size + " should accept " + item + "th item.",
                    basket.addFood(new Fruit(item)));
        }
        return basket;
    }
}