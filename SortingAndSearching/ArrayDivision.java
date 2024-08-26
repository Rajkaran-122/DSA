package SortingAndSearching;

import java.util.*;
import java.io.*;

//






public class ArrayDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int min=Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            min=Math.max(min,i);
        }

        long l = min;
        long r = sum;
        long ans = -1;

        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid, arr, k)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);

    }
    public static boolean check(long mid, int arr[], int k) {
        int cnt = 0;

        long sum = 0;
        for (int i : arr) {
            if (sum + i <= mid) {
                sum += i;
            } else {
                cnt++;
                sum = i;
            }
        }

        return (cnt+1) <= k;
    }
}



 
 
 
 
