/**
 * Diese Klasse repraesentiert Fleisch fressende Dinos.
 */
public class Carnivore extends Dino {

    /**
     * Konstruktor, der alle initialen Attributwerte fuer Gesundheit und Staerke
     * an den Basisklassenkonstruktor durchreicht.
     * @param healthPoints Initiale Gesundheit
     * @param strength Initiale Staerke
     */
	public Carnivore(int healthPoints, int strength) {
		super(healthPoints, strength);
	}

    /**
     * Beim Angriff eines Fleischfressers auf einen anderen Dino wird 
     * die Staerke der beiden Dinos verglichen. Von der Gesundheit 
     * des Dinosauriers mit der geringeren Staerke wird die Staerke des 
     * staerkeren abgezogen. Falls beide gleich stark sind, passiert nichts. 
     * @param other Der Dinosaurier, gegen den dieser Dino kaempft.
     */
    @Override
    public void attack(Dino other) {
        Dino strongerDino;
        Dino weakerDino;
        if (!this.isAlive() || !other.isAlive()) {
            return;
        }
        if (this.strength == other.strength) {
            return;
        }
        if (this.strength > other.strength) {
            strongerDino = this;
            weakerDino = other;
        } else {
            strongerDino = other;
            weakerDino = this;
        }
        weakerDino.healthPoints = weakerDino.healthPoints - strongerDino.strength;
    }

}
