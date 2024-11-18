package DyanamicProgramming;

import java.util.*;
import java.io.*;

//




public class GridPaths1 {
  static   int MOD=1000000007;
    public static long solve(char grid[][], int i, int j,long dp[][]){
        if(i==grid.length-1&&j==grid.length-1){
            return 1;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        long ans=0;
        if(i+1<grid.length&&grid[i+1][j]!='*'){
            ans=(ans+solve(grid,i+1,j,dp))%MOD;
        }
        if(j+1<grid.length&&grid[i][j+1]!='*'){
            ans=(ans+solve(grid,i,j+1,dp))%MOD;
        }

        return dp[i][j]= ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        char grid[][] = new char[n][n];


        for(int i=0; i<n; i++){
            String s=sc.next();
            grid[i]=s.toCharArray();
        }

        long dp[][] = new long[n][n];
        for(long i[]: dp) Arrays.fill(i,-1);
        if(grid[0][0]=='*'){
            System.out.println(0);

        }
       else System.out.println(solve(grid,0,0,dp));
    }
}



 
 
 
 
 
 
