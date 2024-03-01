package DyanamicProgramming;

import java.util.*;
import java.io.*;

//
//
////




public class MinimizeCoins {
    static int MOD=1000000007;
    public static long solve(int n, long dp[]){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        long ans=0;
        for(int i=1; i<=6; i++){
            ans=(ans+ solve(n-i,dp))%MOD;
        }
        return dp[n]= ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int x=sc.nextInt();
        int c[] = new int[n+1];
        for(int i=0; i<n; i++){
            c[i]=sc.nextInt();
        }


        long dp[] = new long[x+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1; i<=x; i++){
            for(int j=0; j<c.length; j++){
                if(c[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-c[j]]+1);
                }
            }
        }
        System.out.println((dp[x]==Integer.MAX_VALUE)?-1:dp[x]);


    }
}



 
 
 
 
 
