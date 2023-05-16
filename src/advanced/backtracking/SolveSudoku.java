package advanced.backtracking;

public class SolveSudoku {

    public void solveSudoku(char[][] A) {
        sudoku(0, 0, A);
    }

    public boolean sudoku(int r, int c, char[][] A) {
        if(c == 9) {
            r += 1;
            c = 0;
        }
        if(r == 9) return true;
        if(A[r][c] != '.') {
            return sudoku(r, c+1, A);
        }
        for(int i=1; i<=9; i++) {
            char k = (char) ('0' + i);
            if(isValid(r, c, k, A)) {
                A[r][c] = k;
                if(sudoku(r, c+1, A)) return true;
                A[r][c] = '.';
            }
        }
        return false;
    }

    private boolean isValid(int r, int c, int k, char[][] A) {
        for(int i=0; i<9; i++) {
            if(A[i][c] == k || A[r][i] == k) return false;
        }
        int n = 3;
        int x = r - (r % n);
        int y = c - (c % n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(A[x+i][y+j] == k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
