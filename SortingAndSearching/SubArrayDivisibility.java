package SortingAndSearching;

import java.util.*;
import java.io.*;

//




public class SubArrayDivisibility {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] rem = new int[n];

        for (int i = 0; i < n; i++) {
            rem[i] = (arr[i] % n + n) % n;
        }

        int[] pre = new int[n];
        pre[0] = rem[0];

        for (int i = 1; i < n; i++) {
            pre[i] = (pre[i - 1] + rem[i]) % n;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(pre[i])) {
                ans += map.get(pre[i]);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }

        System.out.println(ans);
    }
}


 
 
 
 
