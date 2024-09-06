package SortingAndSearching;

import java.util.*;
import java.io.*;

//




public class SumOfFourValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int x=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            dp[i][0]=arr[i];
            dp[i][1]=i+1;
        }
        Arrays.sort(dp,(a,b)->Integer.compare(a[0],b[0]));
        boolean bt=false;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum=dp[i][0]+dp[j][0];
                int k=j+1;
                int l=n-1;
                while(k<l){
                    if(sum+dp[k][0]+dp[l][0]<x){
                        k++;
                    }
                    else if(sum+dp[k][0]+dp[l][0]>x){
                        l--;
                    }
                    else{
                        System.out.println(dp[i][1]+" "+dp[j][1]+" "+dp[k][1]+" "+dp[l][1]);
                        bt=true;
                        break;
                    }
                }
                if(bt)break;

            }
            if(bt)break;
        }
        if(!bt) System.out.println("IMPOSSIBLE");
    }
}



 
 
 
 
