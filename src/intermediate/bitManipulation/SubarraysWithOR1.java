package bitManipulation;

public class SubarraysWithOR1 {

    public static long solve(int A, int[] B) {
        int count = 0;
        int n = B.length;
        for(int i=0; i<n; i++) {
            for(int grpSize = 1; grpSize <= n; grpSize++) {
                if(i + grpSize - 1 < n) {
                    for(int k = i; k < i + grpSize; k++) {
                        if(B[k] == 1) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] B = new int[] {1, 0};
        System.out.println(solve(2, B));
    }

}
