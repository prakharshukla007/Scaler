package advanced.dynamicProgramming;

public class WaysToReachNthStep {

    public static int countDistinctWayToClimbStair(long nStairs) {
        // Write your code here.
        if(nStairs == 0) return 1;
        if(nStairs == 1) return 1;

        return countDistinctWayToClimbStair(nStairs - 1) + countDistinctWayToClimbStair(nStairs - 2);
    }

    public static void main(String[] args) {
        System.out.println(WaysToReachNthStep.countDistinctWayToClimbStair(3));
    }

}
