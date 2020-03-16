

import java.awt.Polygon;

/**
 * Class represents and draws ellipses in a window. The half axes of the
 * ellipses run parallel to the cartesian coordinate system underlying the
 * window, whose origin is positioned in its upper left corner.
 * 
 * The triangle's position denotes the upper left corner of the (virtual)
 * rectangle which circumscribes the triangle.
 * 
 * @author Axel Boettcher
 * @author Veronika Thurner
 */
public class Triangle {
    /** Length of horizontal axis */
    private int width;

    /** Length of vertical axis */
    private int height;

    /**
     * The x- and y-coordinates describing the triangle's position, denoting the
     * top left corner of its surrounding rectangle.
     */
    private int xPos;
    private int yPos;

    /**
     * The triangle's colour. Available colours are enumerated in Type Colour.
     */
    private String colour;

    /**
     * Creates the triangle, initializes all its attributes and draws it.
     * 
     * 
     * @param xPos
     *            x-coordinate
     * @param yPos
     *            y-coordinate 
     * @param width
     *            width
     * @param height
     *            height
     * @param initialColour
     *            Initial color
     */
    public Triangle(int xPos, int yPos, int width, int height, String initialColour) {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.colour = initialColour;
    }

    ///////////////////////////////////////////////////////////////////
    // Alles was ab hier kommt wurde in der Vorlesung nicht besprochen
    ///////////////////////////////////////////////////////////////////

    /**
     * Draws the triangle onto the canvas.
     */
    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        // canvas.draw(this, colour, new Arc2D.Double(xPos, yPos,
        // verticalLength, horizontalLength, 0, 180, Arc2D.PIE));
        canvas.draw(this, colour, new Polygon(new int[] {xPos + width / 2,  xPos, xPos + width },
                new int[] {yPos, yPos + height,  yPos + height }, 3));
        canvas.wait(0);
    }

}
