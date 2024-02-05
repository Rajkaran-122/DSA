import java.util.*;
import java.io.*;

class rev {
    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            // Check for overflow before actually multiplying or adding
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            r = r * 10 + digit;
        }
        return r;
    }
}



 
 
 
 
 
