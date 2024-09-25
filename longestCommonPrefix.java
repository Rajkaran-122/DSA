import java.util.*;
import java.io.*;

class longestCommonPrefix {
    public String longestCommonPrefix(String[] s) {
        if (s.length == 0) return "";
        int j = 0;
        outer: while (j < s[0].length()) {
            char c = s[0].charAt(j);
            for (int i = 1; i < s.length; i++) {
                if (j >= s[i].length() || s[i].charAt(j) != c) break outer;
            }
            j++;
        }
        return s[0].substring(0, j);
    }
}




 
 
 
 
 
 
