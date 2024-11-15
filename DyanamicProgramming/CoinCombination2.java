package DyanamicProgramming;

import java.util.*;
import java.io.*;

//





public class CoinCombination2 {
    static int MOD=1000000007;
    public static long slv(int arr[], int x, int i, long dp[][]){
        if(x<0||i>=arr.length)return 0;
        if(x==0){
            return 1;
        }
        if(dp[x][i]!=-1)return dp[x][i];
        long ans=0;


           if(x>=arr[i]) ans=(ans+slv(arr,x-arr[i],i,dp))%MOD;
           ans=(ans+slv(arr,x,i+1,dp))%MOD;

        return dp[x][i]=  ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long dp[][] = new long[x+1][n+1];
        for(long i[]: dp){
            Arrays.fill(i,-1);
        }

        System.out.println(slv(arr,x,0,dp)%MOD);


    }

}



 
 
 
 
 
 
