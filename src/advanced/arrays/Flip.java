package advanced.arrays;

import java.util.ArrayList;

public class Flip {

    public class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public ArrayList<Integer> flip(String A) {
        int n = A.length();

        int firstZeroIdx = -1;
        for(int i=0; i<n; i++) {
            if(A.charAt(i) == '0') {
                firstZeroIdx = i;
                break;
            }
        }

        if(firstZeroIdx == -1) return new ArrayList<>();

        int maxCountZero = 1;
        Pair ansPair = new Pair(firstZeroIdx, firstZeroIdx);
        int countZero = 1;
        for(int i=firstZeroIdx+1; i<n; i++) {
            if(A.charAt(i) == '0') countZero++;
            else countZero--;

            if(countZero > maxCountZero) {
                ansPair = new Pair(firstZeroIdx, i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ansPair.x+1);
        ans.add(ansPair.y+1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Flip().flip("100101101"));
    }

}
