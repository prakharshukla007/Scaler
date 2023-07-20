package advanced.sorting;

import static advanced.sorting.WaveArray.swap;

public class QuickSort {

    void quickSort(int[] arr, int st, int end) {
        if(st > end) return;

        int pi = partition(arr, st, end);
        quickSort(arr, st, pi-1);
        quickSort(arr, pi+1, end);
    }

    public int partition(int[] arr, int st, int end) {
        int pe = arr[end];
        int i = st;

        for(int j=st; j<end; j++) {
            if(arr[j] < pe) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, end);
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 8, 1, 6, 5, 8};
        new QuickSort().quickSort(arr, 0, arr.length-1);

        for(int n : arr) System.out.print(n + " ");
    }

}
