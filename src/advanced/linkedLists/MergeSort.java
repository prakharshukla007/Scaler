package advanced.linkedLists;

public class MergeSort {

    public int[] solve(int[] A) {
        sort(A, 0, A.length-1);
        return A;
    }
    public void sort(int[] arr, int l, int r) {
        if(l < r) {
            int mid = (l + r)/2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }
    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i=0; i<n1; i++) {
            arr1[i] = arr[l + i];
        }
        for(int i=0; i<n2; i++) {
            arr2[i] = arr[m + 1 + i];
        }

        int idx = l;
        int i = 0, j = 0;
        while(i < n1 && j < n2) {
            if(arr1[i] <= arr2[j]) {
                arr[idx++] = arr1[i++];
            }
            else {
                arr[idx++] = arr2[j++];
            }
        }

        while(i < n1) {
            arr[idx++] = arr1[i++];
        }
        while(j < n2) {
            arr[idx++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 8, 1, 10, 56};
        arr = new MergeSort().solve(arr);
        for(int n : arr) System.out.print(n + " ");
    }

}
