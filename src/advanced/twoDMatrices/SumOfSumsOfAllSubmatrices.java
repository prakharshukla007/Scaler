package advanced.twoDMatrices;

public class SumOfSumsOfAllSubmatrices {

    public static int solve(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int sum = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                sum += (i+1) * (j+1) * (m-i) * (n-j) * matrix[i][j];
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{9, 6}, {5, 4}};
        System.out.println(solve(matrix));
    }

}
