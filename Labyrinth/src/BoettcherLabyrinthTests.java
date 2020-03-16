import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Labyrinth. Prepared to run on courseware.
 * @author <a mailto:axel.boettcher@hm.edu>Axel B&ouml;ttcher</a>
 *
 */
class BoettcherLabyrinthTests {

    private static final int LAB_HEIGHT = 80;
    private static final int LAB_WIDTH = 90;
    private static final ByteArrayOutputStream SYSTEM_OUT_REPLACEMENT_STREAM = new ByteArrayOutputStream();

    private Labyrinth labyrinth = new Labyrinth(LAB_HEIGHT, LAB_WIDTH);

    /**
     * Feeds a {@code ByteArrayOutputStream}-based {@code PrintStream} to
     * {@code System.out/System.err}. All tests will eventually fail if the stream
     * contains characters afterwards.
     */
    @BeforeAll
    static void setUp() {
        final PrintStream ps = new PrintStream(SYSTEM_OUT_REPLACEMENT_STREAM);
        System.setOut(ps);
        System.setErr(ps);
    }

    /**
     * Makes tests fail if {@code System.out} (or {@code System.err})
     * was used.
     */
    @AfterAll
    static void tearDown() {
        final String printedOutput = SYSTEM_OUT_REPLACEMENT_STREAM.toString();
        if (!printedOutput.equals("")) {
            fail("Unallowed use of print(ln) to System.out or System.err detected:\n>>> "
                    + printedOutput);
        }
    }
    
    @Test
    void testConstructor() {
        assertEquals(LAB_WIDTH, labyrinth.getWidth(), "Width of Labyrinth not as expected");
        assertEquals(LAB_HEIGHT, labyrinth.getHeight(), "Height of Labyrinth not as expected");
    }

    @Test
    void testNumberOfNeighbors() {
        assertEquals(2, labyrinth.getNeighbors(new Cell(0, 0)).length);
        assertEquals(2, labyrinth.getNeighbors(new Cell(0, LAB_WIDTH - 1)).length);
        assertEquals(2, labyrinth.getNeighbors(new Cell(LAB_HEIGHT - 1, 0)).length);
        assertEquals(2, labyrinth.getNeighbors(new Cell(LAB_HEIGHT - 1, LAB_WIDTH - 1)).length);

        assertEquals(3, labyrinth.getNeighbors(new Cell(0, 5)).length);
        assertEquals(3, labyrinth.getNeighbors(new Cell(5, 0)).length);

        assertEquals(4, labyrinth.getNeighbors(new Cell(5, 5)).length);
    }

    @Test
    void testNeighborsNotNull() {
        Cell[] neighbors = labyrinth.getNeighbors(new Cell(5, 5));
        for (int index = 0; index < neighbors.length; index++) {
            assertNotNull(neighbors[index], "null neighbor entry at index " + index);
        }
    }

    @Test
    void testAllNeighborsVisited() {
        Cell[] neighbors = labyrinth.getNeighbors(new Cell(5, 5));
        assertFalse(allVisited(neighbors));
        neighbors[3].visit();
        assertFalse(allVisited(neighbors));
        for (int index = 0; index < neighbors.length; index++) {
            neighbors[index].visit();
        }
        assertTrue(allVisited(neighbors));
    }

    @Test
    void testGetReallyRandomNeighbor() {
        Cell cell = labyrinth.getCell(5, 5); // Argumente: Zeile, Spalte
        Cell firstNeighbor = labyrinth.randomUnvisitedNeighbor(cell);
        Cell otherNeighbor = null;
        for (int count = 0; count < 10 * LAB_WIDTH; count++) {
            Cell neighbor = labyrinth.randomUnvisitedNeighbor(cell);
            if (neighbor != firstNeighbor) {
                otherNeighbor = neighbor;
                break;
            }
        }
        assertNotNull(otherNeighbor, "randomUnvisitedNeighbor always seems to return the same neighbor");
    }

    @Test
    void testGetUnvisitedNeighbors() {
        Cell[] neighbors = labyrinth.getNeighbors(new Cell(5, 5));
        neighbors[1].visit();
        neighbors[3].visit();
        assertEquals(2, labyrinth.getNeighbors(labyrinth.getCell(5, 5), false).length);
    }

    @Test
    void findRandomUnvisitedNeighborWhenAllAreVisited() {
        for (int row = 0; row < labyrinth.getHeight(); row++) {
            for (int col = 0; col < labyrinth.getWidth(); col++) {
                labyrinth.getCell(row, col).visit();
            }
        }
        assertNull(labyrinth.randomUnvisitedNeighbor(labyrinth.getCell(5, 5)));
    }

    @Test
    void testWalkRandom() {
        visitAllBut2x2AtTheBottomRight();
        labyrinth.getCell(LAB_HEIGHT - 2, LAB_WIDTH - 2).visit();
        labyrinth.walkRandom(labyrinth.getCell(LAB_HEIGHT - 2, LAB_WIDTH - 2));
        assertNull(allVisited());
    }

    @Test
    void testHunt() {
        visitAllBut2x2AtTheBottomRight();
        Cell cell = labyrinth.hunt();
        assertNotNull(cell, "In labyrinth sized " + stringifySize(labyrinth) + " I visited all but 4x4 at bottom right and hunt returns null");
        boolean b = cell.getRow() == LAB_HEIGHT - 2 && cell.getColumn() == LAB_WIDTH - 2;
        assertTrue(b, "In labyrinth sized " + stringifySize(labyrinth) + " I visited all but 4x4 at bottom right and hunt returns unexpected cell \"" + cell.toString() + "\"");
        assertFalse(cell.isVisited(), "hunt must return an unvisited cell (or null)");
    }

    @Test
    void testHuntLeftTop() {
        labyrinth.getCell(0, 0).visit();
        Cell cell = labyrinth.hunt();
        assertNotNull(cell, "In labyrinth sized " + stringifySize(labyrinth) + " only 1st cell is visited and hunt returns null");
        assertEquals(0, cell.getRow(),
                "In labyrinth sized " + stringifySize(labyrinth) + " only 1st cell is visited; hunt should return (0, 1). Indead returned: " + stringify(cell));
        assertEquals(1, cell.getColumn(),
                "In labyrinth sized " + stringifySize(labyrinth) + " only 1st cell is visited; hunt should return (0, 1). Indead returned: " + stringify(cell));
        assertFalse(cell.isVisited(), "hunt must return an unvisited cell (or null)");
    }

    /*
     * Each step of the algorithm is expeted to remove one wall.
     */
    @Test
    void testNumberOfWalls() {
        labyrinth.createLabyrinth();
        assertEquals(LAB_HEIGHT * LAB_WIDTH + 1, this.numberOfwalls(labyrinth), "Number of still existing walls does not match expectation: ");
    }

    @Test
    void testAllVisited() {
        labyrinth.createLabyrinth();
        Cell cell = allVisited();
        assertNull(cell, "Unvisited cell " + cell);
    }
    
    /**
     * More than a unit test. Starts the Dijkstra machinery!
     */
    @Test
    void testConnected() {
        Labyrinth labyrinth = new Labyrinth(LAB_HEIGHT, LAB_WIDTH);
        labyrinth.createLabyrinth();
        Dijkstra dijk = new Dijkstra(labyrinth, 0, 0);
        dijk.calcDistances();
        assertTrue(dijk.allVisited(), "Seems that not all cells are connected!");
    }

    private void visitAllBut2x2AtTheBottomRight() {
        for (int row = 0; row < labyrinth.getHeight(); row++) {
            for (int col = 0; col < labyrinth.getWidth(); col++) {
                if ((row < LAB_HEIGHT - 2) || (col < LAB_WIDTH - 2)) {
                    labyrinth.getCell(row, col).visit();
                }
            }
        }
    }
    
    private Cell allVisited() {
        for (int row = 0; row < labyrinth.getHeight(); row++) {
            for (int col = 0; col < labyrinth.getWidth(); col++) {
                Cell cell = labyrinth.getCell(row, col);
                if (!cell.isVisited()) {
                    return cell;
                }
            }
        }
        return null;
    }

    private boolean allVisited(Cell[] cells) {
        for (Cell cell : cells) {
            if (!cell.isVisited()) {
                return false;
            }
        }
        return true;
    }

    private int numberOfwalls(Labyrinth labyrinth) {
        int number = 0;
        for (int row = 0; row < labyrinth.getHeight(); row++) {
            for (int col = 0; col < labyrinth.getWidth(); col++) {
                Cell cell = labyrinth.getCell(row, col);
                if (cell.isWallDown()) {
                    number++;
                }
                if (cell.isWallRight()) {
                    number++;
                }
            }
        }
        return number;
    }

    private String stringifySize(Labyrinth labyrinth) {
        return "(" + labyrinth.getHeight() + ", " + labyrinth.getWidth() + ")";
    }

    private String stringify(Cell cell) {
        return "(" + cell.getRow() + ", " + cell.getColumn() + ")";
    }

}