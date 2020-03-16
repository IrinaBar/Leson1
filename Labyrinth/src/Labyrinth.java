import java.util.Random;

public class Labyrinth {
    private int width;
    private int height;
    Random random = new Random();


    public Labyrinth(int width, int height) {
        this.width = width;
        this.height = height;
    }
    private Cell[][] labyrinth;

    public void createLabyrinth() {
        labyrinth = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                labyrinth[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return null;
    }

    public int getHeight() {
        return 0;
    }

    public int getWidth() {
        return 0;
    }

    Cell getNeighbors(Cell cell, boolean b) {
        return null;
    }

    public Cell[] getNeighbors(Cell cell) {
        int n = 4;
        Cell[] cells = new Cell[4];
        /*if (cell.getRow() == height - 1 || cell.getRow() == 0) {
            n--;}
        if (cell.getColumn() == width - 1 || cell.getColumn() == 0) {
            n--;
        }*/
        //проверяем соседа сверху и снизу
        if (cell.getRow() == height - 1) {
            cells[4 - n] = new Cell(cell.getRow() - 1, cell.getColumn() + 0);
            n--;
        } else if (cell.getRow() == 0) {
            cells[4 - n] = new Cell(cell.getRow() + 1, cell.getColumn() + 0);
            n--;
        } else {
            cells[0] = new Cell(cell.getRow() + 1, cell.getColumn() + 0);//нижний
            cells[1] = new Cell(cell.getRow() - 1, cell.getColumn() + 0);//верхний- проверили соседей сверху и снизу
            n = n - 2;
        }
        //проверяем соседа справа и слева
        if (cell.getColumn() == width - 1) {
            cells[4 - n] = new Cell(cell.getRow(), cell.getColumn() - 1);
            n--;
        } else if (cell.getColumn() == 0) {
            cells[4 - n] = new Cell(cell.getRow(), cell.getColumn() + 1);
            n--;
        } else {
            cells[4 - n] = new Cell(cell.getRow(), cell.getColumn() + 1);
            n--;
            cells[4 - n] = new Cell(cell.getRow(), cell.getColumn() - 1);
            n--;
        }
        Cell[] resCells = new Cell[4 - n];
        for (int j = 0; j < 4 - n; j++)

            resCells[j] = cells[j];
        return resCells;
    }

    public void walkRandom(Cell cell) {
    }

    public Cell hunt() {
        return null;
    }

    public Cell randomUnvisitedNeighbor(Cell cell) {
        return null;
    }
}
