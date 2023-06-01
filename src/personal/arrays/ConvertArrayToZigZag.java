package personal.arrays;

public class ConvertArrayToZigZag {

    public void zigZag(int a[], int n) {
        // Code your solution here.
        if (a[0] > a[1]) {
            swap(a, 0, 1);
        }

        for (int i = 1; i < n - 1; i++) {
            if (i % 2 != 0) {
                if (a[i + 1] > a[i]) swap(a, i, i + 1);
            } else {
                if (a[i + 1] < a[i]) swap(a, i, i + 1);
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6202, 4625, 5469, 2038, 5916, 3405, 5533, 7004, 2469, 9853, 4992, 361, 9819, 3294,
                7195, 4036, 9404, 8767, 5404, 1711, 3214, 3100, 3751, 2139, 5437, 4993, 1759, 9572, 6270, 3789,
                9623, 2472, 9493};
        new ConvertArrayToZigZag().zigZag(arr, 33);
        for (int n : arr) System.out.print(n + " ");
        System.out.println();

        System.out.println("abc".contains(((Character) 'a').toString()));
    }

}
