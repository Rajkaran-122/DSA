package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class DigitQuery {
    static int ans = -1;

    static char solve(long k, long len, long start) {
        long block = 9 * start * len;

        if (k > block) {
            return solve(k - block, len + 1, start * 10);
        }

        long numIndex = (k - 1) / len;
        long digitIndex = (k - 1) % len;

        long number = start + numIndex;
        return String.valueOf(number).charAt((int) digitIndex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while (q-- > 0) {
            long k = sc.nextLong();
            System.out.println(solve(k, 1, 1));
        }
    }
}



 
 
 
 
