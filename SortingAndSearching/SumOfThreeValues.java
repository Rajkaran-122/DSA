package SortingAndSearching;

import java.util.*;
import java.io.*;

//







public class SumOfThreeValues {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int x=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            dp[i][0]=arr[i];
            dp[i][1]=i;
        }

        Arrays.sort(dp,(a,b)->Integer.compare(a[0],b[0]));
        boolean bt=false;

        for(int i=0; i<arr.length; i++){
            int j=i+1;
            int k=arr.length-1;
            int sum=dp[i][0];
            while(j<k){
                if(sum+dp[j][0]+dp[k][0]<x){
                    j++;
                }
                else if(sum+dp[j][0]+dp[k][0]>x){
                    k--;
                }
                else{
                    System.out.println((dp[i][1]+1)+" "+(dp[j][1]+1)+" "+(dp[k][1]+1));
                    bt=true;
                    break;
                }
            }
            if(bt)break;;
        }
        if(!bt) System.out.println("IMPOSSIBLE");


    }
}


 
 
 
 
