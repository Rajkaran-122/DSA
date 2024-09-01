package SortingAndSearching;

import java.util.*;
import java.io.*;

public class MissingCoinSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long coinSum = 0;
        for (int i = 0; i < n; i++) {
            if (coinSum + 1 < arr[i]) {
                System.out.println(coinSum + 1);
                return;
            }
            coinSum += arr[i];
        }

        System.out.println(coinSum + 1);
    }
}



 
 
 
 
