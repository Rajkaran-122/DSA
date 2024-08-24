package LineSweep;

import java.util.*;
import java.io.*;

class atCoder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        long ans = 0;
        int l = 0;
        for (int i = 0; i < n; ) {
            if (map.isEmpty()) {
                l = i;
                ans++;
//              System.out.println(ans);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                i++;
                continue;
            }


            while (!map.isEmpty() && l <= i &&
                    (map.containsKey(arr[i]) ||
                            (map.ceilingKey(arr[i]) != null &&
                                    Math.abs(map.ceilingKey(arr[i]) - arr[i]) < d) ||
                            (map.floorKey(arr[i]) != null &&
                                    Math.abs(map.floorKey(arr[i]) - arr[i]) < d))) {

                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if (map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;

            }

            ans += (i - l + 1);
//            System.out.println(ans);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            i++;


        }
//        if(cnt>0)ans+=cnt;
        System.out.println(ans);


    }
}



 
 
 
 
