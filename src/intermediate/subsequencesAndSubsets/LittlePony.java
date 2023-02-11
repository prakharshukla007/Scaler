package intermediate.subsequencesAndSubsets;

public class LittlePony {

    public static String solve(String A) {
        char[] arr = A.toCharArray();
        int n = arr.length;
        String ans = A;

        for(int i=0; i<Math.pow(2, n); i++) {
            String s = "";
            for(int j=0; j<n; j++) {
                if(checkBit(i, j)) s += arr[j];
            }
            if(s.length() >= 2 && s.compareTo(ans) < 0) ans = s;
        }

        return ans;
    }

    public static String solve2(String A) {
        char[] arr = A.toCharArray();
        int n = arr.length;
        char firstMin = 'z';

        int minIndex = -1;
        for(int i=0; i<n-1; i++) {
            if(arr[i] < firstMin) {
                firstMin = arr[i];
                minIndex = i;
            }
        }

        char secondMin = 'z';
        for(int i=minIndex+1; i<n; i++) {
            if(arr[i] < secondMin) secondMin = arr[i];
        }

        return firstMin + "" + secondMin;
    }

    public static boolean checkBit(int i, int j) {
        return (i & (1 << j)) > 0;
    }

    public static void main(String[] args) {
        System.out.println(solve2("scsecugqsb"));
    }

}
