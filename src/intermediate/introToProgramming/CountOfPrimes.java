package intermediate.introToProgramming;

public class CountOfPrimes {
    public static void main(String[] args) {
        System.out.println(solve(10));
    }
    public static int solve(int A) {
        int count = 0;
        for(int i=0; i<A; i++) {
            if(isPrime(i))
                count++;
        }
        return count;
    }
    public static boolean isPrime(int n) {
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
