package SortingAndSearching;

import java.util.*;
import java.io.*;

//// 




 class TraficLight {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeMap<Integer, Integer> gap = new TreeMap<>();

        gap.put(x, 1);

        map.put(0, 1);
        map.put(x, 1);

        for (int i = 0; i < n; i++) {

            int lind = map.lowerKey(arr[i]);
            int hind = map.higherKey(arr[i]);

            int gp = hind - lind;

            gap.put(gp, gap.get(gp) - 1);
            if (gap.get(gp) == 0) gap.remove(gp);

            map.put(arr[i], 1);

            gap.put(arr[i] - lind, gap.getOrDefault(arr[i] - lind, 0) + 1);
            gap.put(hind - arr[i], gap.getOrDefault(hind - arr[i], 0) + 1);

            out.println(gap.lastKey());
        }

        out.flush();
    }
}


 
 
 
 
