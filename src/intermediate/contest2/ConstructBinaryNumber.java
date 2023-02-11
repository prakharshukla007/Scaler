package intermediate.contest2;

public class ConstructBinaryNumber {

    public static int solve(int A, int B) {
        String bin = "";
        while(A > 0) {
            bin += 1;
            A--;
        }
        while(B > 0) {
            bin += 0;
            B--;
        }

        int ans = 0;
        int pow = bin.length()-1;
        for(int i = 0; i<bin.length(); i++) {
            if(bin.charAt(i) == '1') {
                ans += Math.pow(2, pow);
            }
            pow--;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(5, 4));
    }

}
