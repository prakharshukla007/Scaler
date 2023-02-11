package bitManipulation;

public class AnyBaseToDecimal {

    public static int solve(int A, int B) {
        String s = "";
        int Abar = A;
        while(Abar > 0) {
            s += Abar%10;
            Abar /= 10;
        }

        int ans = 0;
        int idx = 0;
        int power = 0;
        while(idx < s.length()) {
            ans += Integer.valueOf(((Character)s.charAt(idx++)).toString()) * Math.pow(B, power++);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(1010, 2));
    }

}
