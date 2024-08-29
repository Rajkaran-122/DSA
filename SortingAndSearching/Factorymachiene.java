package SortingAndSearching;

import java.util.*;
import java.io.*;

public class Factorymachiene {

    public static boolean check(long mid, int arr[], int t) {
        long cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            cnt += mid / arr[i];
            if(cnt>=t)return true;
        }

        return cnt >= t;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = 1000000000000000000L;
        long ans = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (check(mid, arr, t)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}


 
 
 
 
