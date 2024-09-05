package SortingAndSearching;

import java.util.*;
import java.io.*;

class StickLength {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int mid = n / 2;
        int val = arr[mid];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(val - arr[i]);
        }

        System.out.println(ans);
    }
}



















































 
 
 
 
