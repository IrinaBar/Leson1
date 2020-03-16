/**
 * Diese Klasse repraesentiert Oger.
 */
class Ogre implements Drawable {

    private int xPos;
    private int yPos;
    private String color;
    private int deltaX;
    private int deltaY;

    /**
     * Initialisert ein Oger-Objekt mit Werten fuer die Attribute.
     * @param xPos x-Position des Ogers im canvas-Fenster.
     * @param yPos y-Position des Ogers im canvas-Fenster.
     * @param color Farbe des Ogers.
     * @param deltaX
     * @param deltaY
     */
    Ogre(int xPos, int yPos, String color,int deltaX,int deltaY) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }




    /**
     * Zeichnet dieses Oger-Objekt.
     */
    public void draw() {
        Ellipse body = new Ellipse(xPos, yPos, 75, 90, this.color);
        Ellipse head = new Ellipse(xPos + 12, yPos - 45, 50, 60, this.color);


        Ellipse leftEar = new Ellipse(xPos + 7, yPos - 30, 12, 12, this.color);
        Ellipse rightEar = new Ellipse(xPos + 55, yPos - 30, 12, 12, this.color);

        Ellipse leftNostril = new Ellipse(xPos + 30, yPos - 15, 5, 5, "black");
        Ellipse rightNostril = new Ellipse(xPos + 40, yPos - 15, 5, 5, "black");

        Eye leftEye = new Eye(xPos + 22, yPos - 30);
        Eye rightEye = new Eye(xPos + 42, yPos - 30);

        body.draw();
        head.draw();
        leftEar.draw();
        rightEar.draw();
        leftNostril.draw();
        rightNostril.draw();
        leftEye.draw();
        rightEye.draw();

    }
        public void advancedTime(){
            this.xPos += this.deltaX;
            this.yPos += this.deltaY;
        }


    }




