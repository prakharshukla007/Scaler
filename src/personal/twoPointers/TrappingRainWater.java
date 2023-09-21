package personal.twoPointers;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;

        int lmax = height[0];
        int rmax = height[n - 1];

        int p1 = 0, p2 = n - 1;

        int trappedWater = 0;

        while (p1 < p2) {
            if (lmax < rmax) {
                p1++;
                if (height[p1] > lmax) {
                    lmax = height[p1];
                } else {
                    trappedWater += lmax - height[p1];
                }
            } else {
                p2--;
                if (height[p2] > rmax) {
                    rmax = height[p2];
                } else {
                    trappedWater += rmax - height[p2];
                }
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2}));
    }

}
