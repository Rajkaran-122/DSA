package DyanamicProgramming;

import java.util.*;
import java.io.*;

//







public class LongestCommonSubsequnce {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int brr[] = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }
        int cnt = 0;
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    if (arr[i] == brr[j]) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.max((i - 1 >= 0) ? dp[i - 1][j] : 0, (j - 1 >= 0) ? dp[i][j - 1] : 0);
                    }
                    continue;
                }
                if (arr[i] == brr[j]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {

            if (arr[i] == brr[j]) {
                ans.add(arr[i]);
                i--;
                j--;
            }
            else {
                int up = (i > 0) ? dp[i-1][j] : 0;
                int left = (j > 0) ? dp[i][j-1] : 0;

                if (up >= left) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        Collections.reverse(ans);
        System.out.println(ans.size());

        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();


    }
}



 
 
 
 
 
 
