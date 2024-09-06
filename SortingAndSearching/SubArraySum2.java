package SortingAndSearching;

import java.util.*;
import java.io.*;

//







public class SubArraySum2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long pre[] = new long[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }
        long ans = 0;

        for (int i = 0; i < n; i++) {

            long val = pre[i] - x;
            if (map.containsKey(val)) {
                ans += map.get(val);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        System.out.println(ans);
    }
}



 
 
 
 
