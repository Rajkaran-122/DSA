package SortingAndSearching;

import java.util.*;
import java.io.*;

//




public class MovieFestival2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int dp[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[i][0] = a;
            dp[i][1] = b;
        }

        Arrays.sort(dp, (a, b) -> Integer.compare(a[1], b[1]));

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            map.put(0, map.getOrDefault(0, 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int start = dp[i][0];
            int end = dp[i][1];

            Integer key = map.floorKey(start);

            if (key != null) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) map.remove(key);

                map.put(end, map.getOrDefault(end, 0) + 1);
                ans++;
            }
        }

        System.out.println(ans);
    }
}


 
 
 
 
