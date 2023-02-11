package interviewProblems;

public class JosephusProblem {

    static int josephus(int n, int k)
    {
        if (n == 1)
            return 1;
        else
            /* The position returned by josephus(n - 1, k)
            is adjusted because the recursive call
            josephus(n - 1, k) considers the original
            position k%n + 1 as position 1 */
            return (josephus(n - 1, k) + k - 1) % n + 1;
    }


    // main function
    public static void main (String[] args) {

        int N = 100, k = 2;
        int ans = josephus(N, k);
        System.out.println(ans);
    }

}
