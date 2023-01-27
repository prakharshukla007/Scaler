package recursion;

public class PalindromeString {

    public static boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return true;
        if(s.charAt(0) != s.charAt(s.length()-1)) return false;
        return isPalindrome(s.substring(1, s.length()-1));
    }

    public static boolean isPalindrome2(char[] ch, int s, int e) {
        if(ch[s] != ch[e]) return false;
        if(s >= e) return true;
        return isPalindrome2(ch, s+1, e-1);
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s.toCharArray(), 0, s.length()-1));
    }

}
