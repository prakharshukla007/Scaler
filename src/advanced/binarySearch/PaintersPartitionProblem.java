package advanced.binarySearch;

import java.util.Arrays;

public class PaintersPartitionProblem {

    public int paint(int A, int B, int[] C) {
        int modulo = 10000003;
        long max = (long) Arrays.stream(C).max().getAsInt() * (long) B;
        long sum = (long) Arrays.stream(C).sum() * (long) B;
        long low = max, high = sum;
        while (low <= high) {
            long mid = (low + ((high - low) >> 1));
            boolean canWorkBeDone = check(C, mid, A, B);
            if (canWorkBeDone) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)(low % modulo);
    }

    private boolean check(int[] A, long maxTime, int workers, int unitTime) {
        int n = A.length;
        int worker_count = 1;
        long worker_sum = 0;
        for (int i = 0; i < n; i++) {

            if (worker_sum + (A[i] * (long) unitTime) <= maxTime) {
                worker_sum += (A[i] * (long) unitTime);
            } else {
                worker_count++;
                worker_sum = (A[i] * (long) unitTime);
            }
            if (worker_count > workers)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PaintersPartitionProblem obj = new PaintersPartitionProblem();
        int[] arr = new int[] {5, 3, 6, 1, 9};
        System.out.println(obj.paint(3, 2, arr));
    }

}
