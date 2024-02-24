package DyanamicProgramming;

import java.util.*;
import java.io.*;

//



public class ArrayDescription {
    public static long solve(int arr[], int m, int i){
        if(i>=arr.length){
            return 1;
        }
        long ans=0;

        if(arr[i]!=0){
            if(i>0&&Math.abs(arr[i]-arr[i-1])>1){
                return ans;
            }
            else{
                return solve(arr,m,i+1);
            }
        }
        else{
            if(i==0){
                for(int j=1; j<=m; j++){
                    arr[i]=j;
                    ans+=solve(arr,m,i+1);
                    arr[i]=0;
                }
            }
            else{
                int val=arr[i-1]-1;
                for(int j=val; j<=val+2; j++){
                    if(j>=1&&j<=m){
                        arr[i]=j;
                        ans+=solve(arr,m,i+1);
                        arr[i]=0;
                    }
                }
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println(solve(arr,m,0));
    }
}



 
 
 
 
 
