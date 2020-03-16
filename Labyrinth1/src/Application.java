import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * GUI for Labyrinth class.
 * Implementation is optimized to live in one file.
 * Uses Dijkstra class to generate the labyrinth and to retrieve paths from.
 * @author <a mailto:ab@cs.hm.edu>Axel B&ouml;ttcher</a>
 *
 */
@SuppressWarnings("serial")
public class Application extends JPanel {

    public static final Color BACKGROUND = new Color(102, 150, 36);
    public static final Color WAY_COLOR = new Color(220, 20, 20);
    private static final int MAX_RGB_VALUE = 255;
    private static final int LAB_ROWS = 30;
    private static final int LAB_COLS = 40;
    private static final int LINE_LENGTH = 20;

    private final Labyrinth labyrinth;
    private int startCol = 0;
    private int startRow = 0;
    private int endCol = LAB_COLS - 1;
    private int endRow = LAB_ROWS - 1;

    /**
     * Default ctor to initialize the labyrinth object.
     */
    public Application() {
        this.labyrinth = new Labyrinth(LAB_ROWS, LAB_COLS);
        labyrinth.createLabyrinth();
        this.setPreferredSize(new Dimension(LAB_COLS * LINE_LENGTH + 1, LAB_ROWS * LINE_LENGTH + 1));
    }

    /**
     * Paints the labyrinth.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;

        Dijkstra dijk = new Dijkstra(labyrinth, startRow, startCol);
        dijk.calcDistances();
        int maxDist = 0;
        for (int row = 0; row < LAB_ROWS; row++) {
            for (int col = 0; col < LAB_COLS; col++) {
                if (dijk.getDistanceTo(row, col) > maxDist) {
                    maxDist = dijk.getDistanceTo(row, col);
                }
            }
        }
        graphics.drawLine(0, 0, LINE_LENGTH * LAB_COLS, 0);
        graphics.drawLine(0, 0, 0, LINE_LENGTH * LAB_ROWS);
        for (int row = 0; row < LAB_ROWS; row++) {
            for (int col = 0; col < LAB_COLS; col++) {
                if (dijk.getDistanceTo(row, col) == Integer.MAX_VALUE) {
                    graphics.setPaint(new Color(MAX_RGB_VALUE, 0, 0));
                } else {
                    int grayValue = MAX_RGB_VALUE - (dijk.getDistanceTo(row, col) * MAX_RGB_VALUE) / maxDist;
                    graphics.setPaint(new Color(grayValue, grayValue, grayValue));
                }
                graphics.fillRect(col * LINE_LENGTH, row * LINE_LENGTH, LINE_LENGTH, LINE_LENGTH);
            }
        }
        drawPath(graphics, dijk);
        graphics.setColor(Color.BLACK);
        for (int row = 0; row < LAB_ROWS; row++) {
            for (int col = 0; col < LAB_COLS; col++) {
                Cell cell = labyrinth.getCell(row, col);
                if (cell.isWallDown()) {
                    int startX = col * LINE_LENGTH;
                    int startY = (row + 1) * LINE_LENGTH;
                    graphics.drawLine(startX, startY, startX + LINE_LENGTH, startY);
                }
                if (cell.isWallRight()) {
                    int startX = (col + 1) * LINE_LENGTH;
                    int startY = row * LINE_LENGTH;
                    graphics.drawLine(startX, startY, startX, startY + LINE_LENGTH);
                }
            }
        }
    }

    /**
     * Draws the path between current start and end position.
     * @param graphics Graphics context to draw on.
     * @param dijkstra Instance where Dijkstras Algorithm is encapsulated to.
     */
    private void drawPath(Graphics2D graphics, Dijkstra dijkstra) {
        graphics.setPaint(WAY_COLOR);
        Cell current = labyrinth.getCell(this.endRow, this.endCol);
        while (current != null) {
            graphics.fillRect(current.getRow() * LINE_LENGTH, current.getColumn() * LINE_LENGTH, LINE_LENGTH, LINE_LENGTH);
            current = dijkstra.getPredecessor(current.getColumn(), current.getRow());
        }
    }

    /**
     * Called to set start and end positions as attributes.
     * @param startCol Starting column.
     * @param startRow Starting row
     * @param endCol End position's column.
     * @param endRow End position's row.
     */
    void setStartAndEndPositions(int startCol, int startRow, int endCol, int endRow) {
        if (startCol >= LAB_COLS || endCol >= LAB_COLS || startRow >= LAB_ROWS || endRow >= LAB_ROWS) {
            return; // silently return!
        }
        this.startCol = startCol;
        this.startRow = startRow;
        this.endCol = endCol;
        this.endRow = endRow;
        this.repaint();
    }

    /**
     * Application entry point. Fires up the frame.
     * @param args Commandline arguments. None used herein.
     */
    public static void main(String[] args) {
        Application app = new Application();
        JFrame f = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(BACKGROUND);
        panel.add(app);
        panel.add(new ControlPanel(app));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(panel);
        f.pack();
        f.setVisible(true);
    }

    /**
     * Inner class for control panel to set start and end of way through the labyrinth.
     */
    private static class ControlPanel extends JPanel {
        private final JTextField startRow = new JTextField();
        private final JTextField startCol = new JTextField();
        private final JTextField endRow = new JTextField();
        private final JTextField endCol = new JTextField();
        private final JLabel distLabel = new JLabel("(" + LAB_ROWS + ", " + LAB_COLS + ")");
        private final JLabel rowLabel = new JLabel("  Row");
        private final JLabel colLabel = new JLabel(" Column");
        private final JLabel startLabel = new JLabel("Start");
        private final JLabel endLabel = new JLabel("End");

        /**
         * Panel's constructor.
         * @param app Application instance - to get asccess to the instances for start and end point.
         */
        ControlPanel(Application app) {
            ActionListener listener = (event) -> {
                try {
                    int sR = Integer.parseInt(startRow.getText());
                    int sC = Integer.parseInt(startCol.getText());
                    int eR = Integer.parseInt(endRow.getText());
                    int eC = Integer.parseInt(endCol.getText());
                    app.setStartAndEndPositions(sC, sR, eC, eR);
                } catch (Exception e) { /* Mainly int format exception. We just don't do anything in this case. */ }
            };
            startCol.addActionListener(listener);
            startRow.addActionListener(listener);
            endCol.addActionListener(listener);
            endRow.addActionListener(listener);
            this.setLayout(new GridLayout(3, 3));
            this.setBackground(BACKGROUND);
            this.add(distLabel);
            this.add(rowLabel);
            this.add(colLabel);
            this.add(startLabel);
            this.add(startRow);
            this.add(startCol);
            this.add(endLabel);
            this.add(endRow);
            this.add(endCol);
            startCol.setText("0");
            startRow.setText("0");
            endCol.setText((LAB_COLS - 1) + "");
            endRow.setText((LAB_ROWS - 1) + "");
            startCol.addActionListener(listener);
        }
    }
}
