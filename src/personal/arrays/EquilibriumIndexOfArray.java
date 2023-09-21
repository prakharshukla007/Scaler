package personal.arrays;

public class EquilibriumIndexOfArray {

    public int findEquilibrium(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int i=0; i<n; i++) {
            int beforeSum;
            if(i == 0) {
                beforeSum = 0;
            } else {
                beforeSum = prefixSum[i-1];
            }

            int afterSum = prefixSum[n-1] - prefixSum[i];
            if(beforeSum == afterSum) return i+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new EquilibriumIndexOfArray().findEquilibrium(new int[] {1}));
    }

}
