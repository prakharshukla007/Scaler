package advanced.dynamicProgramming;

public class FrogJumpWithKDistance {

    public static int frogJumpKDistance(int n, int[] heights, int k) {
        return util(n - 1, heights, 0, k);
    }

    public static int util(int stair, int[] heights, int energy, int k) {
        if (stair == 0) return energy;
//        if (stair == 1) return energy + Math.abs(heights[0] - heights[1]);

        int minJump = Integer.MAX_VALUE;
        for (int jump = 1; jump <= k; jump++) {
            if (stair - jump >= 0) {
                minJump = Math.min(minJump, util(stair - jump, heights, energy + Math.abs(heights[stair] - heights[stair - jump]), k));
            }
        }

        return minJump;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{30, 10, 60, 10, 60, 50};
        System.out.println(FrogJumpWithKDistance.frogJumpKDistance(heights.length, heights, 2));
    }

}
