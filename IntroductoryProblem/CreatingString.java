package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class CreatingString {
    static HashSet<String> list;

    public static void calc(String s, boolean bt[], StringBuilder sb) {
        {
            if (sb.length() == s.length()) {
                list.add(sb.toString());
                return;
            }

            for (int i = 0; i < s.length(); i++) {
                if (!bt[i]) {
                    sb.append(s.charAt(i));
                    bt[i] = true;
                    calc(s,bt,sb);
                    sb.deleteCharAt(sb.length() - 1);
                    bt[i] = false;


                }
            }
        }

    }

    public static void main(String[] args) {
        list = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        boolean bt[] = new boolean[s.length()];
        Arrays.fill(bt, false);
        StringBuilder sb = new StringBuilder();
        calc(s, bt, sb);
        ArrayList<String>ans= new ArrayList<>(list);
        Collections.sort(ans);
        System.out.println(list.size());
        for (String st : ans) {
            System.out.println(st);
        }

    }
}



 
 
 
 
