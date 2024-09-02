package SortingAndSearching;

import java.util.*;
import java.io.*;

public class playList {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int ans = 1;

        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            if (map.get(arr[j]) > 1) {
                while (map.get(arr[j]) > 1) {
                    map.put(arr[i], map.get(arr[i]) - 1);
                    if (map.get(arr[i]) == 0) {
                        map.remove(arr[i]);
                    }
                    i++;
                }
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }

        System.out.println(ans);
    }
}



 
 
 
 
