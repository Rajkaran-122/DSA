import java.util.*;
import java.io.*;

class romanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1); m.put('V', 5); m.put('X', 10); m.put('L', 50);
        m.put('C', 100); m.put('D', 500); m.put('M', 1000);
        
        int r = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int c = m.get(s.charAt(i));
            r += (i + 1 < n && c < m.get(s.charAt(i + 1))) ? -c : c;
        }
        return r;
    }
}
class romanToInteger {
    public int romanToInt(String s) {
          Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        int prev = 0;

        // Loop from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = roman.get(s.charAt(i));
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }

        return result; 
    }
}



 
 
 
 
 
