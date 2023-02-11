package intermediate.recursion;

import java.util.Scanner;

public class PrintReverseString {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printReverse(s, s.length()-1);
    }

    public static void printReverse(String s, int n) {
        if(n == 0) {
            System.out.print(s.charAt(0));
            return;
        }

        System.out.print(s.charAt(n));
        printReverse(s, n-1);
    }

}
