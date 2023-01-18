package strings;

public class CountOccurences {

    public static int solve(String A) {
        char[] arr = A.toCharArray();
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n-2; i++) {
            if(checkIfBob(arr, i)) count++;
        }
        return count;
    }
    public static boolean checkIfBob(char[] arr, int i) {
        return arr[i] == 'b' && arr[i+1] == 'o' && arr[i+2] == 'b';
    }

    public static void main(String[] args) {
        System.out.println(solve("bobob"));
    }

}
