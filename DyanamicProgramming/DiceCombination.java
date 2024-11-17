package DyanamicProgramming;

import java.util.*;
import java.io.*;

//




public class DiceCombination {
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
        long dp[] = new long[n+1];
//        Arrays.fill(dp,-1);

        dp[0]=1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=6; j++){
                if(j<=i){
                    dp[i]=(dp[i-j]+dp[i])%MOD;
                }
            }
        }
        System.out.println(dp[n]);
    }
}



 
 
 
 
 
 
