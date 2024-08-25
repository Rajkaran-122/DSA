package SortingAndSearching;

import java.util.*;
import java.io.*;

//






public class Apartments {

    public static int find(int arr[], int val, int i, int j) {
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] >= val) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int brr[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            brr[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        int i = 0, j = m - 1;
        int cnt = 0;

        for (int l = 0; l < n; l++) {
            int valInd = find(brr, arr[l] - k, i, j);
            if (valInd != -1 && brr[valInd] <= arr[l] + k) {
                cnt++;
                i = valInd + 1;
            }
        }

        System.out.println(cnt);
    }
}



 
 
 
 
