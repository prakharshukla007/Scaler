package intermediate.contest2;

public class ExtractingNumbers {

    public static long solve(String A) {
//        String[] arr = A.split("[a-zA-Z]*");
//
//        int sum = 0;
//        for(String s : arr) {
//            sum += Integer.valueOf(s);
//        }
//
//        return sum;

        String num = "";
        long sum = 0;
        for(Character c : A.toCharArray()) {
            if(Character.isDigit(c)) {
                num += c;
            }
            else if(num.length() != 0) {
                sum += Integer.valueOf(num);
                num = "";
            }
        }

        if(num.length() != 0)
            sum += Integer.valueOf(num);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solve("a12b34c"));
    }

}
