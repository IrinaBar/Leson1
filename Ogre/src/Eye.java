/**
 * Diese Klasse repraesentiert einzelne Augen.
 */
public class Eye {

    int xPos;
    int yPos;

    /**
     * Initialisiert ein neues Auge mit seiner Bildschirmposition.
     *
     * @param xPos x-Position im canvas-Fenster.
     * @param yPos y-Position im canvas-Fenster.
     */
    Eye(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Zeichnet das Auge.
     */
    void draw() {
        Ellipse iris = new Ellipse(xPos, yPos, 20, 20, "black");
        Ellipse pupil = new Ellipse(xPos + 5, yPos + 5, 8, 8, "white");

        iris.draw();
        pupil.draw();
    }

}
