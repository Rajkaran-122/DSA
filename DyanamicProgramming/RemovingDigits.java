package DyanamicProgramming;

import java.util.*;
import java.io.*;

//




public class RemovingDigits {
    //    public  static int solve(int n, int dp[]){
//        if(n==0)return 0;
//        if(dp[n]!=-1)return dp[n];
//
//        String s=String.valueOf(n);
//        int ans=Integer.MAX_VALUE;
//
//        for(int i=0; i<s.length(); i++){
//            int val=s.charAt(i)-'0';
//            if(val>0){
//                ans=Math.min(ans,1+solve(n-val,dp));
//            }
//        }
//        return dp[n]= ans;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                int val = s.charAt(j) - '0';
                if (val > 0&&val<=i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - val]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}



 
 
 
 
 
