package IntroductoryProblem;

import java.util.*;
import java.io.*;

//



public class AppleDivision {
    public static long solve(int arr[], int i, long sum) {
        if (i >= arr.length) return sum;

        if((long)2*arr[i]<=sum){
            return Math.min(solve(arr,i+1,sum-(long)2*arr[i]),solve(arr,i+1,sum));
        }
        else return solve(arr,i+1,sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println(solve(arr, 0, sum));

    }
}



 
 
 
 
