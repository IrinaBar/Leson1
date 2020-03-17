import java.util.Random;

public class Labyrinth {
    private int height;
    private int width;
    Random random;
    private Cell[][] cells;


    public Labyrinth(int height, int width) {
        this.width = width;
        this.height = height;
        this.random = new Random();
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //Cell cell = new Cell(i, j);   // cell.visit();
                cells[i][j] = new Cell(i, j, true, true, false);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    /*public Cell[][] getLabyrinth() {
        return labyrinth;
    }*/

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void createLabyrinth() {


    }

    public Cell[] getNeighbors(Cell cell, boolean b) {
        Cell[] neighbors = new Cell[0];

        if (cell.getRow() == 0 && cell.getColumn() >= 1 && cell.getColumn() < height - 1) {//первая строка, ряд посередине
            neighbors = new Cell[3];
            Cell c1 = cells[cell.getRow()][cell.getColumn() - 1];
            Cell c2 = cells[cell.getRow()][cell.getColumn() + 1];
            Cell c3 = cells[cell.getRow() + 1][cell.getColumn()];

            neighbors[0] = c1;
            neighbors[1] = c2;
            neighbors[2] = c3;
        }

        if (cell.getColumn() == 0 && cell.getRow() >= 1 && cell.getRow() < height - 1) { //первый ряд,строка посередине
            neighbors = new Cell[3];
            Cell c1 = cells[cell.getRow() - 1][cell.getColumn()];
            Cell c2 = cells[cell.getRow() + 1][cell.getColumn()];
            Cell c3 = cells[cell.getRow()][cell.getColumn() + 1];
            neighbors[0] = c1;
            neighbors[1] = c2;
            neighbors[2] = c3;
        }

        if (cell.getRow() == 0 && cell.getColumn() == 0) { //верхний левый
            neighbors = new Cell[2];
            Cell c2 = cells[cell.getRow() + 1][cell.getColumn()];
            Cell c3 = cells[cell.getRow()][cell.getColumn() + 1];
            neighbors[0] = c2;
            neighbors[1] = c3;
        }
        if (cell.getRow() == 0 && cell.getColumn() == width - 1) {//верхний правый
            neighbors = new Cell[2];
            Cell c2 = cells[cell.getRow() + 1][cell.getColumn()];
            Cell c4 = cells[cell.getRow()][cell.getColumn() - 1];
            neighbors[0] = c2;
            neighbors[1] = c4;
        }

        if (cell.getColumn() == 0 && cell.getRow() >= height - 1) {//нижний левый
            neighbors = new Cell[2];
            Cell c1 = cells[cell.getRow() - 1][cell.getColumn()];
            Cell c3 = cells[cell.getRow()][cell.getColumn() + 1];
            neighbors[0] = c1;
            neighbors[1] = c3;
        }

        if (cell.getColumn() >= width - 1 && cell.getRow() >= height - 1) {//нижний правый
            neighbors = new Cell[2];
            Cell c1 = cells[cell.getRow() - 1][cell.getColumn()];
            Cell c4 = cells[cell.getRow()][cell.getColumn() - 1];
            neighbors[0] = c1;
            neighbors[1] = c4;
        }

        if (cell.getColumn() > 0 && cell.getColumn() < width - 1 && cell.getRow() > 0 && cell.getRow() < height - 1) {
            neighbors = new Cell[4];
            Cell c1 = cells[cell.getRow() - 1][cell.getColumn()];
            Cell c2 = cells[cell.getRow() + 1][cell.getColumn()];
            Cell c3 = cells[cell.getRow()][cell.getColumn() + 1];
            Cell c4 = cells[cell.getRow()][cell.getColumn() - 1];

            neighbors[0] = c1;
            neighbors[1] = c2;
            neighbors[2] = c3;
            neighbors[3] = c4;
        }

        return neighbors;
    }

    public Cell randomUnvisitedNeighbor(Cell cell) {
        Cell[] uvNeighbor = getNeighbors(cell, false);
        if (uvNeighbor.length == 0) return null;
        int ran = random.nextInt(uvNeighbor.length);
        return uvNeighbor[ran];
        /*Cell cellNew = cell;
        cellNew.unVisit();
        return cellNew;*/
    }

    public void walkRandom(Cell cell) {
        while (randomUnvisitedNeighbor(cell) != null) {
            Cell neighbor = randomUnvisitedNeighbor(cell);
            if (cell.getColumn() < neighbor.getColumn())
                cell.setWallRight(false);
            if (cell.getColumn() > neighbor.getColumn())
                neighbor.setWallRight(false);
            if (cell.getRow() > neighbor.getRow())
                neighbor.setWallDown(false);
            if (cell.getRow() < neighbor.getRow())
                cell.setWallDown(false);
            cell = neighbor;
            cell.setVisited(true);
        }
    }

    public Cell hunt() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (getCell(y, x).isVisited() && getNeighbors(getCell(y, x), false).length != 0) {//найти клетку, которая не посещена, и соседа, который посещен
                    return getCell(y, x); //вернуть эту клетку
                }
            }
        }
        return null;//конец, не нашли клетку, кторую ищем
    }
}


        /*class Test1 {
            public static void main(String[] args) {
                Labyrinth lab = new Labyrinth(80, 90);
                lab.createLabyrinth();
                new PrettyPrinter(System.out).print(lab.getLabyrinth());
            }
        }*/
