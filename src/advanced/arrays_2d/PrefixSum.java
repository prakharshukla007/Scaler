package advanced.arrays_2d;

public class PrefixSum {

    public int[][] calculatePrefix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] prefix = new int[n][m];

        //Initialise first row and first column
        prefix[0][0] = matrix[0][0];
        //First row
        for(int j=1; j<m; j++) {
            prefix[0][j] = prefix[0][j-1] + matrix[0][j];
        }

        //First column
        for(int i=1 ;i<n; i++) {
            prefix[i][0] = prefix[i-1][0] + matrix[i][0];
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i][j];
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][5];
        matrix[0] = new int[] {1, 3, 5, 2, -1};
        matrix[1] = new int[] {4, 8, 5, 0, 6};
        matrix[2] = new int[] {10, 20, 1, 3, 5};
        matrix[3] = new int[] {1, 5, -5, 10, 6};

        int[][] prefix = new PrefixSum().calculatePrefix(matrix);
        for(int i=0; i<4; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
