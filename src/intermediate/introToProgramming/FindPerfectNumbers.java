package intermediate.introToProgramming;

public class FindPerfectNumbers {
    public static void main(String[] args) {
        System.out.println(solve(6));
    }
    public static int solve(int A) {
        int sum = 0;
        int i = 1;
        for(i=1; i<=A/2; i++) {
            if(A%i == 0) {
                sum += i;
            }
        }

        if(sum == A)
            return 1;
        return 0;
    }
}
