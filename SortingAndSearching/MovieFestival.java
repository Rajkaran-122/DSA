package SortingAndSearching;

import java.util.*;
import java.io.*;

//




public class MovieFestival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n =sc.nextInt();
         int dp[][] = new int[n][2];
         for(int i=0; i<n; i++){
             dp[i][0]=sc.nextInt();
             dp[i][1]=sc.nextInt();
         }
        Arrays.sort(dp,(a,b)->Integer.compare(a[0],b[0]));

        int ans=1;
        int end=dp[0][1];
        for(int i=1; i<n; i++){
            int start=dp[i][0];
            int ed=dp[i][1];
            if(start>=end){
                ans++;
                end=ed;
            }
            else{
                end=Math.min(end,ed);
            }
        }
        System.out.println(ans);
    }
}



 
 
 
 
