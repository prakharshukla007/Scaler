package advanced.stringPatternMatching;

public class RabinKarp {

    public int solve(String A, String B) {
        int nA = A.length();
        int nB = B.length();

        int phfB = 0;
        char[] arrB = B.toCharArray();
        int pow = 0;
        for(int i=nB-1; i>=0; i--) {
            phfB += (arrB[i] - 'a' + 1) * Math.pow(10, pow++);
        }

        String firstSubA = A.substring(0, nB);
        int phfA = 0;
        char[] subArrA = firstSubA.toCharArray();
        pow = 0;
        for(int i= subArrA.length-1; i>=0; i--) {
            phfA += (subArrA[i] - 'a' + 1) * Math.pow(10, pow++);
        }

        int count = 0;
        if(phfA == phfB) count++;
        char[] arrA = A.toCharArray();
        for(int i=nB; i<nA; i++) {
            phfA = (phfA - (arrA[i-nB] - 'a' + 1) * (int)Math.pow(10, nB-1))*10 + (arrA[i] - 'a' + 1);
            if(phfA == phfB) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new RabinKarp().solve("ccbcdaacc", "ac"));
    }

}
