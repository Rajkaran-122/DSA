package DyanamicProgramming;

import java.util.*;
import java.io.*;

//






public class EditDistance {
    public static int solve(String s1, String s2, int i, int j, int dp[][]) {
        if (i >= s1.length() && j >= s2.length()) {
            return 0;
        }
        if (i >= s1.length()) {
            return s2.length() - (j);
        }
        if (j >= s2.length()) {
            return s1.length() - (i);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(s1, s2, i + 1, j + 1, dp);
        } else {

            return dp[i][j] = Math.min(1 + solve(s1, s2, i + 1, j + 1, dp),
                    Math.min(1 + solve(s1, s2, i, j + 1, dp),
                            1 + solve(s1, s2, i + 1, j, dp)));
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();


        int dp[][] = new int[s1.length()][s2.length()];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }

        System.out.println(solve(s1, s2, 0, 0, dp));

        br.close();
    }
}



 
 
 
 
 
 
