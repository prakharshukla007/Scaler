package intermediate.contest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentsMarks {

    public static class MarksComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String num1 = "";
            for(int i=o1.length()-1; i>=0; i--) {
                if(Character.isDigit(o1.charAt(i))) num1 = o1.charAt(i) + num1;
                else break;
            }

            String num2 = "";
            for(int i=o2.length()-1; i>=0; i--) {
                if(Character.isDigit(o2.charAt(i))) num2 = o2.charAt(i) + num2;
                else break;
            }

            if(Integer.valueOf(num1) > Integer.valueOf(num2)) return -1;
            else if(Integer.valueOf(num1) < Integer.valueOf(num2)) return 1;
            else return 0;
        }
    }

    public static ArrayList<String> solve(ArrayList<String> A) {
        Collections.sort(A, new MarksComparator());
        return A;
    }

    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<>();
        ls.add("adarsh80");
        ls.add("harsh95");
        ls.add("shivam95");

        System.out.println(solve(ls));
    }

}
