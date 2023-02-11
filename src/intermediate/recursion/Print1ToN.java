package recursion;

import java.util.Scanner;

public class Print1ToN {

    public static void print1ToN(int n) {
        if(n == 1) {
            System.out.print(1 + " ");
            return;
        }
        print1ToN(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        print1ToN(9);
    }

}
