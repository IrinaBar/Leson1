public class Cell {
    private final int column;
    private final int row;
    boolean wallDown;
    boolean wallRight;
    boolean visited;

    public Cell(int column, int row, boolean wallDown, boolean wallRight, boolean visited) {
        this.column = column;
        this.row = row;
        this.wallDown = wallDown;
        this.wallRight = wallRight;
        this.visited = visited;
    }

    public Cell(int row, int column) {
        this(row, column, true, true, false);
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

    public void setWallDown(boolean wallDown) {
        this.wallDown = wallDown;
    }

    public void setWallRight(boolean wallRight) {
        this.wallRight = wallRight;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "row: " + row + " | col: " + column;
    }

    public void unVisit() {
        visited = false;
    }
}
