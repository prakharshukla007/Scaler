package intermediate.carryForward;

public class EvenSubarrays {

    public static String solve(int[] A) {
        int n = A.length;
        int firstEvenIdx = -1;
        int lastEvenIdx = -1;
        int count = 0;
        int evenLength = 0;
        for(int i=0; i<n; i++) {
            if(A[i] % 2 == 0) {
                if(lastEvenIdx == -1) {
                    firstEvenIdx = i;
                    lastEvenIdx = i;
                }
                else {
                    lastEvenIdx = i;
                    if((lastEvenIdx - firstEvenIdx + 1) % 2 == 0) {
                        count++;
                        evenLength += lastEvenIdx - firstEvenIdx + 1;
                    }
                    firstEvenIdx = i;
                }
            }
        }
        if(count >= 1 && evenLength == n)
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        int[] arr = {978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580, 101, 760, 837, 564, 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50, 516, 409, 868, 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819, 324, 651, 678, 139, 940};
        System.out.println(solve(arr));
    }

}
