/**
 * Class that represents ogres.
 * @author <a mailto:axel.boettcher@hm.edu>Axel B&ouml;ttcher</a>
 */
class Ogre {

    private int xPos;
    private int yPos;
    private String colour;
    private Head head;

    /**
     * Ctor for ogres.
     * @param xPos Initial position of ogre on x-axis.
     * @param yPos Initial position of ogre on y-axis.
     * @param colour Initial Color of the ogre.
     */
    Ogre(int xPos, int yPos, String colour) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.colour = colour;
        this.head = new Head(xPos + 25, yPos - 90, this.colour);
    }

    /**
     * Draws the ogre at its current coordinates.
     */
    void draw() {
        Ellipse body = new Ellipse(xPos, yPos, 150, 180, this.colour);
        body.draw();
        head.draw();
    }

    /**
     * Moves the ogre to a new position by applying deltas in x and y-direction.
     * @param deltaX Delta to move ogre on x-axis.
     * @param deltaY Delta to move ogre on y-axis.
     */
    public void move(int deltaX, int deltaY) {
        this.xPos += deltaX;
        this.yPos += deltaY;
        this.head.move(deltaX, deltaY);
    }

    /**
     * Setter method for colour.
     * @param newColour New colour for the ogre.
     */
    public void setColour(String newColour) {
        this.colour = newColour;
        this.head.setColour(newColour);
    }

}
