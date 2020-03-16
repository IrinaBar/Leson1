public class Cell {
    private final int row;
    private final int column;
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

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void visit() {
      visited=true;
    }

    public boolean isVisited() {
        return visited;
    }
}
