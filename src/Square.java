

import java.awt.geom.Rectangle2D;

/**
 * Class represents and draws squares in a window. The half axes of the
 * ellipses run parallel to the cartesian coordinate system underlying the
 * window, whose origin is positioned in its upper left corner.
 * 
 * The square's position denotes the upper left corner of the (virtual)
 * rectangle which circumscribes the square.
 * 
 * @author Axel Boettcher
 * @author Veronika Thurner
 * 
 * 
 */

public class Square {
    /** Length of horizontal axis */
    private int width;

    /** Length of vertical axis */
    private int height;

    /**
     * The x- and y-coordinates describing the square's position, denoting the
     * top left corner of its surrounding rectangle.
     */
    private int xPos;
    private int yPos;

    /**
     * The square's colour. Available colours are enumerated in Type Colour.
     */
    private String colour;

    /**
     * Creates the square, initializes all its attributes and draws it.
     * 
     * @param xPos
     *            x-coordinate
     * @param yPos
     *            y-coordinate 
     * @param dimension
     *            width
     * @param initialColour
     *            Initial color
     */
    public Square(int xPos, int yPos, int dimension, String initialColour) {
        this.width = dimension;
        this.height = dimension;
        this.xPos = xPos;
        this.yPos = yPos;
        colour = initialColour;
    }

    ///////////////////////////////////////////////////////////////////
    // Alles was ab hier kommt wurde in der Vorlesung nicht besprochen
    ///////////////////////////////////////////////////////////////////

    /**
     * Draws the square onto canvas.
     */
    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "black", new Rectangle2D.Double(xPos, yPos, width, height));
        canvas.draw(this, colour, new Rectangle2D.Double(xPos + 1, yPos + 1, width - 2, height - 2));
        canvas.wait(0);
    }

}
