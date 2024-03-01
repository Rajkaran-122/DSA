package DyanamicProgramming;

import java.util.*;
import java.io.*;

//




public class RectangleCutting {
    public static int solve(int a, int b, int dp[][]) {
        if(a==b)return 0;
        if(dp[a][b]!=-1)return dp[a][b];

        int ans=Integer.MAX_VALUE;

        for(int i=1; i<a; i++){
            ans=Math.min(ans,1+solve(i,b,dp)+solve(a-i,b,dp));
        }

        for(int i=1; i<b; i++){
            ans=Math.min(ans,1+solve(a,i,dp)+solve(a,b-i,dp));
        }

        return dp[a][b]= ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int dp[][] = new int[a+1][b+1];
//        for(int i[]:dp) Arrays.fill(i,-1);

        for(int i=1; i<=a; i++){
            for(int j=1; j<=b; j++){
                if(i==1||j==1){
                    dp[i][j]=Math.max(i-1,j-1);
                }
                else if(i==j){
                    dp[i][j]=0;
                }
                else{
                    int cut=Integer.MAX_VALUE;
                    for(int k=1; k<i; k++){
                        cut=Math.min(dp[k][j]+dp[i-k][j],cut);
//                        if(i==6&&j==5){
//                            System.out.println(k+" "+cut+" i ");
//                        }
                    }
                    for(int k=1; k<j; k++){
                        cut=Math.min(dp[i][k]+dp[i][j-k],cut);
//                        if(i==6&&j==5){
//                            System.out.println(k+" "+cut);
//                        }
                    }

                    dp[i][j]=1+cut;
                }
            }
        }
        for(int i=0; i<a;i++){
            for(int j=0;j<b; j++){
                System.out.print(dp[i+1][j+1]+" ");
            }
            System.out.println();
        }

        System.out.println(dp[a][b]);
    }
}



 
 
 
 
 
