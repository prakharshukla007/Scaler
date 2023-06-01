package personal.arrays;

import java.util.ArrayList;
import java.util.List;

public class ReverseArray {

    public void reverse(ArrayList<Integer> arr) {
        util(arr, 0, arr.size()-1);
    }

    public void util(ArrayList<Integer> arr, int i, int j) {
        if(i >= j) return;

        swap(arr, i, j);
        util(arr, i+1, j-1);
    }

    void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4));
        new ReverseArray().reverse(arr);
        System.out.println(arr);
    }

}
