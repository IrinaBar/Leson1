/**
 * Class represents and draws ellipses in a window. The half axes of the
 * ellipses run parallel to the cartesian coordinate system underlying the
 * window, whose origin is positioned in its upper left corner.
 *
 * The ellipse's position denotes the upper left corner of the (virtual)
 * rectangle which circumscribes the ellipse.
 *
 * @author <a mailto:axel.boettcher@hm.edu>Axel B&ouml;ttcher</a>
 * @author Veronika Thurner
 * @author Daniela Zehetmeier
 */
public class Ellipse {


    /** Length of horizontal axis */
    private int width;

    /** Length of vertical axis */
    private int height;

    /**
     * The x- and y-coordinates describing the ellipse's position, denoting the
     * top left corner of its surrounding rectangle.
     */
    private int xPos;
    private int yPos;

    /**
     * The ellipse's colour. Available colours are enumerated in Type Colour.
     */
    private String colour;

    /**
     * Creates the ellipse, initializes all its attributes and draws it.
     *
     * @param width
     *            Horizontal Length
     * @param height
     *            Vertical Length
     * @param xPos
     *            x-coordinate
     * @param yPos
     *            y-coordinate
     * @param initialColour
     *            Initial color
     */
    public Ellipse(int xPos, int yPos, int width, int height, String initialColour) {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        colour = initialColour;
    }

    /**
     * Reset horizontalLength to a new value.
     *
     * @param h
     *            New horizontal length.
     */
    void setHorizontalLength(int h) {
        width = h;
    }

    /**
     * Reset verticalLength to a new value.
     *
     * @param v
     *            New vertical length.
     */
    void setVerticalLength(int v) {
        height = v;
    }

    ///////////////////////////////////////////////////////////////////
    // Alles was ab hier kommt wurde in der Vorlesung nicht besprochen
    ///////////////////////////////////////////////////////////////////

    /**
     * Draws the ellipse on the canvas.
     */
    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, colour, new java.awt.geom.Ellipse2D.Double(xPos, yPos, width, height));
        canvas.wait(0);
    }

    
}
