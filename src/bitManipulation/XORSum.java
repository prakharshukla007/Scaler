package bitManipulation;

public class XORSum {

    public static int solve(int A, int B) {
        int ans = Integer.MAX_VALUE;
        int X = 0;
        while(X < 1001) {
            ans = Math.min(ans, (A^X)+(B^X));
            X++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(101, 101));
    }

}
