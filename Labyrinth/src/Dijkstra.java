/**
 * Quick implementation of Dijksttra's algorithm on Labyrinths.
 * Yet only detects distances from a starting point to any other point. 
 * @author <a mailto:axel.boettcher@hm.edu>Axel B&ouml;ttcher</a>
 *
 */
public class Dijkstra {

    private final Labyrinth labyrinth;
    private final int startRow;
    private final int startColumn;

    private final boolean[][] visited;
    private final int[][] distances;
    private final Cell[][] predecessors;



    /**
     * Constructor to set relevant parameters.
     * @param labyrinth Labyrinth to work with.
     * @param startRow Row (y) coordinate of starting cell.
     * @param startColumn Column (x) coordinate of starting cell.
     */
    public Dijkstra(Labyrinth labyrinth, int startRow, int startColumn) {
        this.labyrinth = labyrinth;
        this.startRow = startRow;
        this.startColumn = startColumn;
        visited = new boolean[labyrinth.getHeight()][labyrinth.getWidth()];
        distances = new int[labyrinth.getHeight()][labyrinth.getWidth()];
        predecessors = new Cell[labyrinth.getHeight()][labyrinth.getWidth()];
        for (int row = 0; row < distances.length; row++) {
            for (int col = 0; col < distances[row].length; col++) {
                distances[row][col] = Integer.MAX_VALUE;
            }
        }
    }

    /**
     * Executes Dijkstra's algorithm by visiting all cells and calculating 
     * distances though.
     */
    public void calcDistances() {
        distances[startRow][startColumn] = 0;
        visited[startRow][startColumn] = true;
        int numberVisited = 1;
        updateNeighbors(startRow, startColumn);
        while (numberVisited < labyrinth.getWidth() * labyrinth.getHeight()) {
            // search cell with minimum distance
            int minDist = Integer.MAX_VALUE;
            int nextRow = 0;
            int nextCol = 0;
            for (int row = 0; row < labyrinth.getHeight(); row++) {
                for (int col = 0; col < labyrinth.getWidth(); col++) {
                    if (!visited[row][col] && distances[row][col] < minDist) {
                        minDist = distances[row][col];
                        nextRow = row;
                        nextCol = col;
                    }
                }
            }
            // update neighors
            updateNeighbors(nextRow, nextCol);
            if (!visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                numberVisited++;
            }
        }
    }

    /**
     * Visits all neighbors of cell at position (row, col).
     * Updates distances to those neighbor cells if they are connected.
     * @param row Row-coordinate of cell in question.
     * @param col Column-coordinate of cell in question.
     */
    void updateNeighbors(int row, int col) {
        Cell cell = labyrinth.getCell(row, col);
        if (row < labyrinth.getHeight() - 1 && !cell.isWallDown() && distances[row + 1][col] > distances[row][col] + 1) {
            distances[row + 1][col] = distances[row][col] + 1;
            predecessors[row + 1][col] = cell;
        }
        if (col < labyrinth.getWidth() - 1 && !cell.isWallRight() && distances[row][col + 1] > distances[row][col] + 1) {
            distances[row][col + 1] = distances[row][col] + 1;
            predecessors[row][col + 1] = cell;
        }
        if (row > 0 && !labyrinth.getCell(row - 1, col).isWallDown() && distances[row - 1][col] > distances[row][col] + 1) {
            distances[row - 1][col] = distances[row][col] + 1;
            predecessors[row - 1][col] = cell;
        }
        if (col > 0 && !labyrinth.getCell(row, col - 1).isWallRight() && distances[row][col - 1] > distances[row][col] + 1) {
            distances[row][col - 1] = distances[row][col] + 1;
            predecessors[row][col - 1] = cell;
        }
    }

    /**
     * Test method to check if all cells are visited after the 
     * algorithm has run.
     * @return true iff all cells visited.
     */
    boolean allVisited() {
        for (int row = 0; row < labyrinth.getHeight(); row++) {
            for (int col = 0; col < labyrinth.getWidth(); col++) {
                if (!visited[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the distance from the starting cell to the cell at 
     * position (row, col).
     * @param row Row-coordinate of cell in question.
     * @param col Column-coordinate of cell in question.
     * @return distance from startX cell to cell at (row, col).
     */
    public int getDistanceTo(int row, int col) {
        return this.distances[row][col];
    }

    /**
     * Retruns the predecessor cell of a given position.
     * @param row Row position for which predecessor is required.
     * @param col Column position for which predecessor is required.
     * @return Predecessor of cell at (row, col).
     */
    public Cell getPredecessor(int row, int col) {
        return predecessors[row][col];
    }

}
