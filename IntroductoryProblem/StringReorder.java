package IntroductoryProblem;

import java.util.*;
import java.io.*;

//






public class StringReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        /*
        if freq(c)>(length+1)/2 for any character then ans is -1
        use two pinter i and j sort the character by their frequency use two point at 0th and 1st index and add one
        by one if i goes to -ve shft i=j and j++ and if j<-ve j++ that's all complete the process and we got ans
        */
        int freq[] = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
            max = Math.max(freq[s.charAt(i) - 'A'], max);
        }
        if (max > (s.length() + 1) / 2) {
            System.out.println(-1);
        } else {
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) list.add((char) ('A' + i));
            }
            Collections.sort(list);
//             for(char c: list) System.out.println(c);
            StringBuilder ans = new StringBuilder();
            while (true) {
                boolean bt = true;
                for (int i = 0; i < list.size(); i++) {
                    if (ans.length() == 0 || list.get(i) != ans.charAt(ans.length() - 1)) {
                        char c = list.get(i);
                        int ind = (int) (c - 'A');
                        if (freq[ind] > 0) {
//                            System.out.println(c+" "+ind);
                            freq[ind]--;
                            int mx = 0;
                            for (int j = 0; j < 26; j++) {
                                mx = Math.max(freq[j], mx);
                            }
                            if (mx <= (s.length() - ans.length()) / 2) {
                                bt = false;
                                ans.append(c);
                                break;
                            } else {
                                freq[ind]++;
                            }
                        }
                    }
                }
                if (bt) break;
            }
            System.out.println(ans.toString());
        }
    }
}



 
 
 
 
