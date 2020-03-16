public class Cell {
    public int length;
    private int row;
    private  int column;
    private boolean wallDown;
    private boolean wallRight;
    private boolean visited;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.wallDown = wallDown;
        this.wallRight = wallRight;
        this.visited = visited;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isWallDown() {
        return wallDown;
    }

    public void setWallDown(boolean wallDown) {
        this.wallDown = wallDown;
    }

    public boolean isWallRight() {
        return wallRight;
    }

    public void setWallRight(boolean wallRight) {
        this.wallRight = wallRight;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean visit() {
      return visited == true;
    }


}
