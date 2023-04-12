package advanced.hashing;

import java.util.HashSet;
import java.util.Objects;

public class CountRectangles {

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int solve(int[] A, int[] B) {
        int n = A.length;
        HashSet<Pair> hs = new HashSet<>();

        for(int i=0; i<n; i++) {
            hs.add(new Pair(A[i], B[i]));
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(checkDiag(A[i], A[j], B[i], B[j])) {
                    if(hs.contains(new Pair(A[i], B[j])) && hs.contains(new Pair(A[j], B[i]))) ans++;
                }
            }
        }

        return ans/2;
    }
    public boolean checkDiag(int x1, int x2, int y1, int y2) {
        return x1 != x2 && y1 != y2;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 1, 2, 2};
        int[] B = new int[] {1, 2, 1, 2};
        System.out.println(new CountRectangles().solve(A, B));
    }

}
