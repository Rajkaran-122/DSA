package SortingAndSearching;

import java.util.*;
import java.io.*;

//



public class maximumSybarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n; i++){
            arr[i]=sc.nextInt();
        }

        long sum=0;
        long max=arr[0];
        for(int i=0;i<n; i++){
            sum+=arr[i];
            max=Math.max(max,sum);
            if(sum<0){
                sum=0;
            }

        }
        System.out.println(max);

    }
}



 
 
 
 
