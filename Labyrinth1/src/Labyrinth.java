import java.util.Random;

public class Labyrinth {
    private final int height;
    private final int width;

    Random random;
    private Cell[][] labyrinth;

    public Labyrinth(int height, int width) {
        this.width = width;
        this.height = height;
    }
/*    Cell[] getNeighbors(Cell celll){

    }*/



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int row, int col) {
        return labyrinth[row][col];
    }

    public void createLabyrinth() {
        labyrinth = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                labyrinth[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[] getNeighbors(Cell cell) {
        Cell[] neighbors = new Cell[0];

        if (cell.getRow() == 0 && cell.getColumn() >= 1 && cell.getColumn()<height-1) {//первая строка, ряд посередине
            neighbors = new Cell[3];
            Cell c1 = labyrinth[cell.getColumn()][cell.getColumn() - 1];
            Cell c2 = labyrinth[cell.getColumn()][cell.getColumn() + 1];
            Cell c3 = labyrinth[cell.getRow() + 1][cell.getColumn()];

            neighbors[0] = c1;
            neighbors[1] = c2;
            neighbors[2] = c3;
        }

        if (cell.getColumn() == 0 && cell.getRow() >= 1) { //первый ряд,строка посередине
            neighbors = new Cell[3];
            Cell c1 = labyrinth[cell.getRow() - 1][cell.getColumn()];
            Cell c2 = labyrinth[cell.getRow() + 1][cell.getColumn()];
            Cell c3 = labyrinth[cell.getRow()][cell.getColumn() + 1];
            neighbors[0] = c1;
            neighbors[1] = c2;
            neighbors[2] = c3;
        }

        if (cell.getRow() == 0 && cell.getColumn() == 0) { //верхний левый
            neighbors = new Cell[2];
            Cell c2 = labyrinth[cell.getRow() + 1][cell.getColumn()];
            Cell c3 = labyrinth[cell.getRow()][cell.getColumn() + 1];
            neighbors[0] = c2;
            neighbors[1] = c3;
        }
        if (cell.getRow() == 0 && cell.getColumn() == width - 1 ) {//верхний правый
            neighbors = new Cell[2];
            Cell c2 = labyrinth[cell.getRow() + 1][cell.getColumn()];
            Cell c4 = labyrinth[cell.getRow()][cell.getColumn() - 1];
            neighbors[1] = c2;
            neighbors[3] = c4;
        }

        if (cell.getColumn() == 0 && cell.getRow() >= height - 1) {//нижний левый
            neighbors = new Cell[2];
            Cell c1 = labyrinth[cell.getRow() - 1][cell.getColumn()];
            Cell c3 = labyrinth[cell.getRow()][cell.getColumn() + 1];
            neighbors[0] = c1;
            neighbors[1] = c3;
        }

        if (cell.getColumn() >= width - 1 && cell.getRow() >= height - 1) {//нижний правый
            neighbors = new Cell[2];
            Cell c1 = labyrinth[cell.getRow() - 1][cell.getColumn()];
            Cell c4 = labyrinth[cell.getRow()][cell.getColumn() - 1];
            neighbors[0] = c1;
            neighbors[3] = c4;
        }

        if (cell.getColumn() > 0 && cell.getColumn() < width - 1 && cell.getRow() > 0 && cell.getRow() < height - 1) {
            neighbors = new Cell[4];
            Cell c1 = labyrinth[cell.getRow() - 1][cell.getColumn()];
            Cell c2 = labyrinth[cell.getRow() + 1][cell.getColumn()];
            Cell c3 = labyrinth[cell.getRow()][cell.getColumn() + 1];
            Cell c4 = labyrinth[cell.getRow()][cell.getColumn() - 1];

            neighbors[0] = c1;
            neighbors[1] = c2;
            neighbors[2] = c3;
            neighbors[3] = c4;
        }

        return neighbors;
    }

}