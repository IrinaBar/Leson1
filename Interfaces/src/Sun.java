/**
 * Diese Klasse repraesentiert Sonnen in der Welt der Oger.
 */
public abstract class Sun implements Drawable {

    public static final int DIAMETER = 60;

    private int xPos;
    private int yPos;

    Sun(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Zeichnet die Sonne an vorgegebener Position.
     */
    public void draw() {
        new Ellipse(this.xPos, this.yPos, DIAMETER, DIAMETER, "yellow").draw();
    }

}
