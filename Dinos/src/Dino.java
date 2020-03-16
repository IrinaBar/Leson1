/**
 * Diese abstrakte Klasse repraesentiert die Gemeinsamkeiten aller Dinosaurier
 * in diesem Projekt.
 */
public abstract class Dino {

    int healthPoints;
    int strength;

    /**
     * Initialisiert einen Dinosaurier mit Gesundheit und Staerke.
     * @param healthPoints Initiale Gesundheit (Lebenspunkte) eines Dinosauriers.
     * @param strength Staerke eines Dinosauriers.
     */
    protected Dino(int healthPoints, int strength) {
        if (healthPoints < 0 || strength < 0) {
            throw new IllegalArgumentException("health and strength must be at least 0");
        }
        this.healthPoints = healthPoints;
        this.strength = strength;
    }

    /**
     * Gibt die Information zurueck, ob ein Dino noch am Leben ist.
     * @return true genau dann, wenn der Dino noch lebt 
     * (also wenn er noch Gesundheitspunkte hat).
     */
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * Diese Methode wird aufgerufen, wenn dieser Dino einen anderen angreift. 
     * Die beiden Dinos kaempfen dann also gegeneinander. 
     * Der Angreifer ist immer this.
     * @param other Der Dinosaurier, gegen den dieser Dino kaempft.
     */
    public abstract void attack(Dino other);


}
