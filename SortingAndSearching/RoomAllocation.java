package SortingAndSearching;

import java.util.*;
import java.io.*;

//




public class RoomAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) dp[i][j] = sc.nextInt();
        }
        TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(dp[i][0], new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])));
            PriorityQueue<int[]> list = map.get(dp[i][0]);
            list.add(new int[]{dp[i][1], i});
        }

        int room = 1;
        int ans[] = new int[n];

        while (!map.isEmpty()) {
            int key = map.firstKey();
            int[] en = map.get(key).poll();
            int end = en[0];
            int ind = en[1];
            if (map.get(key).isEmpty()) map.remove(key);
            ans[ind] = room;

            while (map.higherKey(end) != null) {
                int ky = map.higherKey(end);
                int e[] = map.get(ky).poll();
                end = e[0];
                int in = e[1];
                ans[in] = room;
                if (map.get(ky).isEmpty()) map.remove(ky);
            }
            room++;
        }
        System.out.println(room - 1);

        for (int i : ans) {
            System.out.print(i + " ");
        }

    }
}



 
 
 
 
