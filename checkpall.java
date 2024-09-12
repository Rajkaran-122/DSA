import java.util.*;
import java.io.*;

class checkpall {
    public boolean isPalindrome(int x) {
        // Negative numbers or numbers ending with 0 (but not 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x = x / 10;
        }

        // If even length, x == reversedHalf
        // If odd length, x == reversedHalf / 10
        return (x == reversedHalf || x == reversedHalf / 10);
    }
}



 
 
 
 
 
 
