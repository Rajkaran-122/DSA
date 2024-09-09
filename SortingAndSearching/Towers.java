package SortingAndSearching;

import java.util.*;
import java.io.*;

// 




public class Towers {

    public static int binarySearch(ArrayList<Integer> list, int val) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) > val) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] >= list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int ind = binarySearch(list, arr[i]);
                list.set(ind, arr[i]);
            }
        }

        out.println(list.size());
        out.flush();
    }
}


 
 
 
 
