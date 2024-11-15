package DyanamicProgramming;

import java.util.*;
import java.io.*;

public class BookShop {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int h[] = new int[n];
        int s[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) h[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) s[i] = Integer.parseInt(st.nextToken());

        int dp[][] = new int[n+1][x+1];

        for(int i=n-1;i>=0;i--){
            for(int money=0;money<=x;money++){

                dp[i][money] = dp[i+1][money]; // skip

                if(money >= h[i]){
                    dp[i][money] = Math.max(
                            dp[i][money],
                            s[i] + dp[i+1][money-h[i]]
                    );
                }
            }
        }

        System.out.println(dp[0][x]);
    }
}


 
 
 
 
 
 
