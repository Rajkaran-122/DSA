import java.util.*;
import java.io.*;

class letterCombinationsPhoneNumber {
    public List<String> letterCombinations(String d) {
        List<String> r = new ArrayList<>();
        if (d.length() == 0) return r;
        String[] m = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        r.add("");
        for (char c : d.toCharArray()) {
            List<String> t = new ArrayList<>();
            for (String s : r) {
                for (char ch : m[c - '0'].toCharArray()) {
                    t.add(s + ch);
                }
            }
            r = t;
        }
        return r;
    }
}




 
 
 
 
 
 
