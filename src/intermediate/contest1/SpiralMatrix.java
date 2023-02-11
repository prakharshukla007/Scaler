package intermediate.contest1;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<Integer>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;

        while(top<=bottom && left<=right) {
            //Top
            for(int i=left; i<=right; i++) {
                ls.add(matrix[top][i]);
            }

            //Right
            for(int i=top+1; i<=bottom; i++) {
                ls.add(matrix[i][right]);
            }

            //Bottom
            if(top != bottom) {
                for(int i=right-1; i>=left; i--) {
                    ls.add(matrix[bottom][i]);
                }
            }

            //Left
            if(left != right) {
                for(int i=bottom-1; i>top; i--) {
                    ls.add(matrix[i][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return ls;
    }

}
