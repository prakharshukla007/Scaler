package advanced.greedy;

public class AnotherCoinProblem {

    public int solve(int A) {
        int maxPow = (int) (Math.log(A)/Math.log(5));
        int count = 0;
        while(A > 0) {
            while(A < Math.pow(5, maxPow)) maxPow--;
            A -= Math.pow(5, maxPow);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new AnotherCoinProblem().solve(2011));
    }

}
