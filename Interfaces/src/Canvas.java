
import java.awt.Color;

import javax.swing.JFrame;

/**
 * Canvas to draw everything on.
 *
 */
public final class Canvas {
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary.
    // This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational
    // purposes.

    private static final int CANVAS_WIDTH = 1280;
    private static final int CANVAS_HEIGHT = 800;
    private static final int BASIC_COLOR_STEPSIZE = 25;

    private static Canvas canvasSingleton;

    // ----- instance part -----

    java.awt.Color backgroundColor;
    private javax.swing.JFrame frame;
    private CanvasPane canvas;
    private java.awt.Graphics2D graphic;
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setPreferredSize(new java.awt.Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new java.util.ArrayList<Object>();
        shapes = new java.util.HashMap<Object, ShapeDescription>();
    }

    /**
     * Factory method to get the canvas singleton object.
     * 
     * @return The canvas singleotn-instance.
     */
    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("Scenary", CANVAS_WIDTH, CANVAS_HEIGHT, java.awt.Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen when
     * made visible. This method can also be used to bring an already visible
     * canvas to the front of other windows.
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
    // interfaces in this project clean and simple for educational purposes.
    public void draw(Object referenceObject, String colour, java.awt.Shape shape) {
        objects.remove(referenceObject); // just in case it was already
        // there
        objects.add(referenceObject); // add at the end
        shapes.put(referenceObject, new ShapeDescription(shape, colour));
        this.redraw();
    }

    /**
     * Method to draw a String to the canvas.
     * 
     * @param string
     *            Text to draw
     * @param xCoord
     *            x-coordinate where text will appear
     * @param yCoord
     *            y-coordinate where text will appear
     */
    public void drawString(String string, int xCoord, int yCoord) {
        graphic.drawString(string, xCoord, yCoord);
    }

    /**
     * Set the foreground color of the Canvas.
     * 
     * @param colorString
     *            The color for the foreground of the Canvas
     */
    public void setForegroundColor(String colorString) {
        switch (colorString) {
            case "red":
                graphic.setColor(Color.RED);
                break;
            case "black":
                graphic.setColor(java.awt.Color.BLACK);
                break;
            case "blue":
                graphic.setColor(Color.BLUE);
                break;
            case "yellow":
                graphic.setColor(Color.YELLOW);
                break;
            case "magenta":
                graphic.setColor(java.awt.Color.MAGENTA);
                break;
            case "white":
                graphic.setColor(java.awt.Color.WHITE);
                break;
            case "gray":
                graphic.setColor(java.awt.Color.GRAY);
                break;
            case "brown":
                graphic.setColor(new Color(8 * BASIC_COLOR_STEPSIZE, 5 * BASIC_COLOR_STEPSIZE, 3 * BASIC_COLOR_STEPSIZE));
                break;
            case "green":
                graphic.setColor(new Color(7 * BASIC_COLOR_STEPSIZE, 9 * BASIC_COLOR_STEPSIZE, 3 * BASIC_COLOR_STEPSIZE));
                break;
            case "camouflageGreen":
                graphic.setColor(new Color(4 * BASIC_COLOR_STEPSIZE, 6 * BASIC_COLOR_STEPSIZE,  BASIC_COLOR_STEPSIZE));
                break;
            case "firGreen":
                graphic.setColor(new Color(3 * BASIC_COLOR_STEPSIZE, 4 * BASIC_COLOR_STEPSIZE, 2 * BASIC_COLOR_STEPSIZE));
                break;
            default:
                graphic.setColor(java.awt.Color.BLACK);
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
        // this.erase();
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

        /**
         * Paint the image.
         * 
         * @param graphics
         *            The graphics context.
         */
        public void paint(java.awt.Graphics graphics) {
            graphics.drawImage(canvasImage, 0, 0, null);
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

        /**
         * Set shape.
         * 
         * @param shape
         *            Shape to set.
         * @param colour
         *            Colour to use.
         */
        ShapeDescription(java.awt.Shape shape, String colour) {
            this.shape = shape;
            colourString = colour;
        }

        /**
         * Draw the shape.
         * 
         * @param graphic
         *            Graphics context to draw on.
         */
        public void draw(java.awt.Graphics2D graphic) {
            Canvas.this.setForegroundColor(colourString);
            graphic.fill(shape);
        }
    }

}