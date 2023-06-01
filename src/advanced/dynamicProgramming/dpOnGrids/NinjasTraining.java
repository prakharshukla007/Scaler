package advanced.dynamicProgramming.dpOnGrids;

import java.util.Arrays;

public class NinjasTraining {

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return util(points, n-1, 3, dp); // We pass three initially because we have not done any task yet. (could be -1 or whatever but not when memoized)
    }

    public static int util(int[][] points, int day, int prevTask, int[][] dp) {
        if(day == 0) {
            int max = Integer.MIN_VALUE;
            for(int i=0; i<3; i++) {
                if(i != prevTask) max = Math.max(max, points[day][i]);
            }
            return max;
        }

        if(dp[day][prevTask] != -1) return dp[day][prevTask];

        int max = Integer.MIN_VALUE;
        for(int task=0; task<3; task++) {
            if(task != prevTask) {
                max = Math.max(max, points[day][task] + util(points, day-1, task, dp));
            }
        }

        return dp[day][prevTask] = max;
    }

    public static int ninjaTrainingBottomUp(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for(int i=0; i<4; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0; j<3; j++) {
                if(j != i) {
                    max = Math.max(max, points[0][j]);
                }
            }
            dp[0][i] = max;
        }

        for(int day=1; day<n; day++) {
            for(int lastTask=0; lastTask<4; lastTask++) {
                dp[day][lastTask] = Integer.MIN_VALUE;
                for(int task=0; task<3; task++) {
                    if(task != lastTask) {
                        dp[day][lastTask] = Math.max(dp[day][lastTask], points[day][task] + dp[day-1][task]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

    public static int ninjaTrainingBottomUpSpaceOptimised(int n, int[][] points) {
        int[] prev = new int[4];
        for(int i=0; i<4; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0; j<3; j++) {
                if(j != i) {
                    max = Math.max(max, points[0][j]);
                }
            }
            prev[i] = max;
        }

        for(int day=1; day<n; day++) {
            int[] temp = new int[4];
            for(int lastTask=0; lastTask<4; lastTask++) {
                temp[lastTask] = Integer.MIN_VALUE;
                for(int task=0; task<3; task++) {
                    if(task != lastTask) {
                        temp[lastTask] = Math.max(temp[lastTask], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }

    public static void main(String[] args) {
        int[][] points = new int[3][3];
        points[0] = new int[]{1, 2, 5};
        points[1] = new int[]{3, 1, 1};
        points[2] = new int[]{3, 3, 3};

        System.out.println(NinjasTraining.ninjaTrainingBottomUpSpaceOptimised(3, points));
    }

}
