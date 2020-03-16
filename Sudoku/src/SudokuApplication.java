import java.util.Arrays;

public class SudokuApplication {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(new int[][]{
                {0,0,3,0,0,0,0,0,0}, //1.Zeile
                {0,0,0,1,9,5,0,0,0},
                {0,0,8,0,0,0,0,6,0},

                {8,0,0,0,6,0,0,0,0},
                {4,0,0,8,0,0,0,0,1},
                {0,0,0,0,2,0,0,0,0},

                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,0,0,0,7,0},

        });
        System.out.println(sudoku);
    }
}
