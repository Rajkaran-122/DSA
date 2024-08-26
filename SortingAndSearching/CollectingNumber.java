package SortingAndSearching;

import java.util.*;
import java.io.*;

public class CollectingNumber {
    public static int search(int dp[][],int target){
        int left=0;
        int right=dp.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(dp[mid][0]==target){
                return dp[mid][1];
            }
           else if(dp[mid][0]<target){
                left=mid+1;
            }
            else right=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][0]=arr[i];
            dp[i][1]=i;
        }
       Arrays.sort(dp,(a,b)->Integer.compare(a[0],b[0]));
       int val=1;
       int ind=-1;
       int ans=1;
       while(val<=n){
           int nd=search(dp,val);
           if(nd<ind){
               ans++;
               ind=nd;
           }
           else{
               ind=nd;
           }
           val++;
       }
        System.out.println(ans);

    }
}



 
 
 
 
