import javax.swing.JFrame;

/**
 * Class represents and draws ellipses in a window. The half axes of the
 * ellipses run parallel to the cartesian coordinate system underlying the
 * window, whose origin is positioned in its upper left corner.
 *
 * The ellipse's position denotes the upper left corner of the (virtual)
 * rectangle which circumscribes the ellipse.
 *
 * @author Axel Boettcher
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
    private int xPos, yPos;

    /**
     * The ellipse's colour. Available colours are enumerated in Type Colour.
     */
    private String colour;

    /**
     * Creates the ellipse, initializes all its attributes and draws it.
     *
     * @param h
     *            Horizontal Length
     * @param v
     *            Vertical Length
     * @param x
     *            x-coordinate
     * @param y
     *            y-coordinate
     * @param initialColour
     *            Initial color
     */
    public Ellipse(int x, int y, int h, int v, String initialColour) {
        width = h;
        height = v;
        xPos = x;
        yPos = y;
        colour = initialColour;
    }

    /**
     * Sets the ellipse's color to a new value and redraws the ellipse.
     *
     * @param newColour
     */
    void setColour(String newColour) {
        colour = newColour;
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

    /**
     * Erases existing ellipse. Moves the ellipse by resetting its coordinates.
     * Redraws moved ellipse.
     *
     * @param xDelta
     *            Denotes horizontal movement
     * @param yDelta
     *            Denotes vertical movement
     */
    void move(int xDelta, int yDelta) {
        xPos = xPos + xDelta;
        yPos = yPos + yDelta;
    }

    ///////////////////////////////////////////////////////////////////
    // Alles was ab hier kommt wurde in der Vorlesung nicht besprochen
    ///////////////////////////////////////////////////////////////////

    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, colour, new java.awt.geom.Ellipse2D.Double(xPos, yPos, width, height));
        canvas.wait(0);
    }

    public void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(this);
    }

    static class Canvas {
        // Note: The implementation of this class (specifically the handling of
        // shape identity and colors) is slightly more complex than necessary.
        // This
        // is done on purpose to keep the interface and instance fields of the
        // shape objects in this project clean and simple for educational
        // purposes.

        private static Canvas canvasSingleton;

        /**
         * Factory method to get the canvas singleton object.
         */
        public static Canvas getCanvas() {
            if (canvasSingleton == null) {
                canvasSingleton = new Canvas("Scratchpad", 1200, 600, java.awt.Color.white);
            }
            canvasSingleton.setVisible(true);
            return canvasSingleton;
        }

        // ----- instance part -----

        private javax.swing.JFrame frame;
        private CanvasPane canvas;
        private java.awt.Graphics2D graphic;
        private java.awt.Color backgroundColor;
        private java.awt.Image canvasImage;
        private java.util.List<Object> objects;
        private java.util.HashMap<Object, ShapeDescription> shapes;

        /**
         * Create a Canvas.
         * 
         * @param title
         *            title to appear in Canvas Frame
         * @param width
         *            the desired width for the canvas
         * @param height
         *            the desired height for the canvas
         * @param bgColor
         *            the desired background color of the canvas
         */
        private Canvas(String title, int width, int height, java.awt.Color bgColor) {
            frame = new javax.swing.JFrame();
            frame.setResizable(false);
            canvas = new CanvasPane();
            frame.setContentPane(canvas);
            frame.setTitle(title);
            frame.setLocation(30, 30);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvas.setPreferredSize(new java.awt.Dimension(width, height));
            backgroundColor = bgColor;
            frame.pack();
            objects = new java.util.ArrayList<Object>();
            shapes = new java.util.HashMap<Object, ShapeDescription>();
        }

        /**
         * Set the canvas visibility and brings canvas to the front of screen
         * when made visible. This method can also be used to bring an already
         * visible canvas to the front of other windows.
         * 
         * @param visible
         *            boolean value representing the desired visibility of the
         *            canvas (true or false)
         */
        public void setVisible(boolean visible) {
            if (graphic == null) {
                // first time: instantiate the offscreen image and fill it with
                // the background color
                java.awt.Dimension size = canvas.getSize();
                canvasImage = canvas.createImage(size.width, size.height);
                graphic = (java.awt.Graphics2D) canvasImage.getGraphics();
                graphic.setColor(backgroundColor);
                graphic.fillRect(0, 0, size.width, size.height);
                graphic.setColor(java.awt.Color.black);
            }
            frame.setVisible(visible);
        }

        /**
         * Draw a given shape onto the canvas.
         * 
         * @param referenceObject
         *            an object to define identity for this shape
         * @param colour
         *            the color of the shape
         * @param shape
         *            the shape object to be drawn on the canvas
         */
        // Note: this is a slightly backwards way of maintaining the shape
        // objects. It is carefully designed to keep the visible shape
        // interfaces
        // in this project clean and simple for educational purposes.
        public void draw(Object referenceObject, String colour, java.awt.Shape shape) {
            objects.remove(referenceObject); // just in case it was already
                                                // there
            objects.add(referenceObject); // add at the end
            shapes.put(referenceObject, new ShapeDescription(shape, colour));
            this.redraw();
        }

        /**
         * Erase a given shape's from the screen.
         * 
         * @param referenceObject
         *            the shape object to be erased
         */
        public void erase(Object referenceObject) {
            objects.remove(referenceObject); // just in case it was already
                                                // there
            shapes.remove(referenceObject);
            this.redraw();
        }

        /**
         * Set the foreground color of the Canvas.
         * 
         * @param newColor
         *            the new color for the foreground of the Canvas
         */
        public void setForegroundColor(String colorString) {
            if (colorString.equals("red")) {
                graphic.setColor(new java.awt.Color(235, 25, 25));
            } else if (colorString.equals("black")) {
                graphic.setColor(java.awt.Color.black);
            } else if (colorString.equals("blue")) {
                graphic.setColor(new java.awt.Color(30, 75, 220));
            } else if (colorString.equals("yellow")) {
                graphic.setColor(new java.awt.Color(255, 230, 0));
            } else if (colorString.equals("green")) {
                graphic.setColor(new java.awt.Color(80, 160, 60));
            } else if (colorString.equals("magenta")) {
                graphic.setColor(java.awt.Color.magenta);
            } else if (colorString.equals("white")) {
                graphic.setColor(java.awt.Color.white);
            } else {
                graphic.setColor(java.awt.Color.black);
            }
        }

        /**
         * Wait for a specified number of milliseconds before finishing. This
         * provides an easy way to specify a small delay which can be used when
         * producing animations.
         * 
         * @param milliseconds
         *            the number
         */
        public void wait(int milliseconds) {
            try {
                Thread.sleep(milliseconds);
            } catch (Exception e) {
                // ignoring exception at the moment
            }
        }

        /**
         * Redraw ell shapes currently on the Canvas.
         */
        private void redraw() {
//            this.erase();
            for (Object shape : objects) {
                shapes.get(shape).draw(graphic);
            }
            canvas.repaint();
        }

        /**
         * Erase the whole canvas. (Does not repaint.)
         */
        void erase() {
            java.awt.Color original = graphic.getColor();
            graphic.setColor(backgroundColor);
            java.awt.Dimension size = canvas.getSize();
            graphic.fill(new java.awt.Rectangle(0, 0, size.width, size.height));
            graphic.setColor(original);
            objects.clear();
            canvas.repaint();
        }

        /************************************************************************
         * Inner class CanvasPane - the actual canvas component contained in the
         * Canvas frame. This is essentially a JPanel with added capability to
         * refresh the image drawn on it.
         */
        private class CanvasPane extends javax.swing.JPanel {
            private static final long serialVersionUID = 1L;

            public void paint(java.awt.Graphics g) {
                g.drawImage(canvasImage, 0, 0, null);
            }
        }

        /************************************************************************
         * Inner class CanvasPane - the actual canvas component contained in the
         * Canvas frame. This is essentially a JPanel with added capability to
         * refresh the image drawn on it.
         */
        private class ShapeDescription {
            private java.awt.Shape shape;
            private String colourString;

            public ShapeDescription(java.awt.Shape shape, String colour) {
                this.shape = shape;
                colourString = colour;
            }

            public void draw(java.awt.Graphics2D graphic) {
                Canvas.this.setForegroundColor(colourString);
                graphic.fill(shape);
            }
        }

    }

}
