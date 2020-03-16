public class Cell {
    private final int column;
    private final int row;
    boolean wallDown;
    boolean wallRight;
    boolean visited;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isWallDown() {
        return wallDown;
    }

    public boolean isWallRight() {
        return wallRight;
    }

    public int getRow() {
        return column;
    }

    public int getColumn() {
        return row;
    }

    public void visit() {
      visited=true;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return "row: " + row + " | col: " + column;
    }
}
