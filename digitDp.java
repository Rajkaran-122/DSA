import java.util.*;
import java.io.*;

public class digitDp {

    public int ddp(String s, int i, int tight, int cnt, Integer dp[][][]) {

        if (i >= s.length())
            return cnt;

        if (dp[i][tight][cnt] != null)
            return dp[i][tight][cnt];

        int ans = 0;

        int limit = (tight == 1) ? s.charAt(i) - '0' : 9;

        for (int j = 0; j <= limit; j++) {

            int nc = 0;
            if (j == 1)
                nc++;

            int nt = (tight == 1 && j == s.charAt(i) - '0') ? 1 : 0;

            ans += ddp(s, i + 1, nt, cnt + nc, dp);
        }

        return dp[i][tight][cnt] = ans;
    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        Integer dp[][][] = new Integer[s.length() + 1][2][16];
        return ddp(s, 0, 1, 0, dp);
    }

    // ✅ main method must be INSIDE the class
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        digitDp sol = new digitDp();
        int result = sol.countDigitOne(n);

        System.out.println("Total count of digit 1 from 0 to " + n + " = " + result);

        sc.close();
    }
}



 
 
 
 
 
 
