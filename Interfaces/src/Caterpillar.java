/**
 * Diese Klasse repraesentiert Raupen in der Welt der Oger.
 */
class Caterpillar implements Drawable{

    private static final String BODY_COLOR = "green";

    private int xPos;
    private int yPos;
    private String color;
    private int deltaX;
    private int deltaY;

    /**
     * Initialisiert die Attribute der Raupe.
     * @param xPos x-Position im Canvas.
     * @param yPos y-Position im Canvas.
     * @param color Farbe der Raupe (fuer alle Teile ausser Koerper).
     */
    Caterpillar(int xPos, int yPos, String color, int deltaX, int deltaY ) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public void draw() {
        // Koerper
        new Ellipse(this.xPos + 15, this.yPos + 10, 18, 18, BODY_COLOR).draw();
        new Ellipse(this.xPos + 20, this.yPos + 10, 18, 18, BODY_COLOR).draw();

        // Kopf
        new Ellipse(this.xPos, this.yPos, 20, 20, this.color).draw();

        // Fuehler
        new Ellipse(this.xPos + 4, this.yPos - 5, 6, 12, this.color).draw();
        new Ellipse(this.xPos + 12, this.yPos - 5, 6, 12, this.color).draw();
    }

    @Override
    public void advanceTime() {

    }

    public void advancedTime(){
        this.xPos += this.deltaX;
        this.yPos += this.deltaY;
    }

}
