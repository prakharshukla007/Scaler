package advanced.greedy;

import java.util.ArrayList;

public class DistributeCandies {

    public int candy(ArrayList<Integer> A) {
        int n = A.size();
        int[] c = new int[n];

        for(int i=0; i<n; i++) {
            c[i] = 1;
        }

        //1st pass
        for(int i=1; i<n; i++) {
            if(A.get(i) > A.get(i-1)) {
                if(c[i] <= c[i-1]) c[i] = c[i-1] + 1;
            }
        }

        //2nd pass
        for(int i=n-2; i>=0; i--) {
            if(A.get(i) > A.get(i+1)) {
                if(c[i] <= c[i+1]) c[i] = c[i+1] + 1;
            }
        }

        int sum = 0;
        for(int i=0; i<n; i++) sum += c[i];

        return sum;
    }

}
