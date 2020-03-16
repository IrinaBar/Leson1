public class Sudoku {
    static int[][] sudokuArray;

    public Sudoku(int[][] sudokuArray) {
        this.sudokuArray = sudokuArray;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < sudokuArray.length; row++) {
            for (int col = 0; col < sudokuArray[row].length; col++) {
                result.append(sudokuArray[row][col]).append(" ");
                if ((col + 1) % 3 == 0 && col < sudokuArray[row].length - 1) {
                    result.append("|");
                }
            }
            result.append('\n');
            if ((row + 1) % 3 == 0 && row < sudokuArray.length - 1) {
                result.append("-------------------\n");
            }
        }
        /*for (int[] row : sudokuArray) {
            for (int col: row) {
                result += col + " ";
            }
            result += '\n';
    }
        return result;*/
        return result.toString();
    }

    //eine Methode die prüft, ob die Ziffer in einer Zeile korrect sind
    //keine doppelte Einträge enthält
    //return true, wenn keine doppelte Eintraege vorkommen
    //(ausgenommen die Ziffer 0)
    boolean isRowCorrekt(int row) {
        for (int number = 1; number <= 9 + SUDOKU_SIZE; number++) {
            boolean found = false;

            for (int col = 0; col < SUDOKU_SIZE; col++) {
                if (this.sudokuArray[row][col] == number) {
                    if (found) {
                        return false;
                        break;
                    }
                    found = true;
                }
            }

            return false;
        }
    }
}
