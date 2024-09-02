package SortingAndSearching;

import java.util.*;
import java.io.*;

//






public class ReadingBooks {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        long sum = 0;
        for(int i = 0; i < n-1; i++){
            sum += arr[i];
        }

        if(sum >= arr[n-1]){
            System.out.println(sum + arr[n-1]);
        }
        else{
            System.out.println(2L * arr[n-1]);
        }
    }
}


 
 
 
 
