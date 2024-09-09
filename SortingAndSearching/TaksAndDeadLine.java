package SortingAndSearching;

import java.util.*;
import java.io.*;

//package CSES Problem SET.Sorting Searching;






public class TaksAndDeadLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dp, (a, b) -> Integer.compare(a[0], b[0]));

        long cost = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int d = dp[i][0];
            int D = dp[i][1];
            cost += d;
            ans += D - cost;
        }

        System.out.println(ans);
    }
}



 
 
 
 
