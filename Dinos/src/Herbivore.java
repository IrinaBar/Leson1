/**
 * Diese Klasse repraesentiert pflanzenfressende Dinos.
 */
public class Herbivore extends Dino {

    /**
     * Konstruktor, der einen pflanzenfressenden Dino mit einer
     * Gesundheit von 100 und gegebener Staerke initialisiert.
     * @param strength Initiale Staerke des Dinos.
     */
    public Herbivore(int strength) {
        super(100, strength);
    }

    /**
     * Beim Angriff eines Pflanzenfressers auf einen anderen Pflanzenfresser 
     * wird dem Angegriffenen ein Gesundheitspunkt abgezogen. Beim Angriff 
     * auf einen fleischfressenden Dino passiert nichts.
     * @param other Der Dinosaurier, gegen den dieser Dino kaempft.
     */
    @Override
    public void attack(Dino other) {
        if (other instanceof Herbivore) {
            other.healthPoints--;
        }
    }

}
