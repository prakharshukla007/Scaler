package cm2_DSA_Revision_contest;

import java.util.ArrayList;
import java.util.Arrays;

public class FrequencyBasedSorting {

    public class Pair {
        char c;
        int freq;
        public Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String solve(String A) {
        Pair[] freq = new Pair[26];
        for(int i=0; i<26; i++) freq[i] = new Pair((char) (i + 97), -1);

        for(char c : A.toCharArray()) {
            if(freq[c - 'a'].freq == -1) freq[c - 'a'] = new Pair(c, 1);
            else {
                freq[c - 'a'].freq += 1;
            }
        }

        Arrays.sort(freq, (a, b) -> b.freq - a.freq);

        String ans = "";

        for(int i=0; i<26; i++) {
            if(freq[i].freq >= 0) {
                int count = freq[i].freq;
                for(int j=1; j<=count; j++) {
                    ans += freq[i].c;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FrequencyBasedSorting().solve("scaleracademy"));
    }

}
