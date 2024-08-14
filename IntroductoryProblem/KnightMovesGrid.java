package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class KnightMovesGrid {

    static int INF = (int) 1e9;

    public static int solve(int dp[][], int i, int j) {

        // base case
        if (i == 0 && j == 0) return 0;

        // invalid
        if (i < 0 || i >= dp.length || j < 0 || j >= dp.length)
            return INF;

        // memoized
        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = INF;

        // all 8 knight moves (corrected)
        ans = Math.min(ans, solve(dp, i + 2, j + 1) + 1);
        ans = Math.min(ans, solve(dp, i + 2, j - 1) + 1);
        ans = Math.min(ans, solve(dp, i - 2, j + 1) + 1);
        ans = Math.min(ans, solve(dp, i - 2, j - 1) + 1);

        ans = Math.min(ans, solve(dp, i + 1, j + 2) + 1);
        ans = Math.min(ans, solve(dp, i + 1, j - 2) + 1);
        ans = Math.min(ans, solve(dp, i - 1, j + 2) + 1);
        ans = Math.min(ans, solve(dp, i - 1, j - 2) + 1);

        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp[][] = new int[n][n];

        // initialize dp with -1
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        // compute
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = solve(dp, i, j);
            }
        }

        // print
        for (int[] row : dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}



 
 
 
 
