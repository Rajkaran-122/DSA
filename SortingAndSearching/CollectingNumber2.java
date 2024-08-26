package SortingAndSearching;

import java.util.*;
import java.io.*;

// 




public class CollectingNumber2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int ind[] = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ind[arr[i]] = i;
        }

        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (ind[i - 1] > ind[i]) ans++;
        }

        while (m-- > 0) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (a == b) {
                out.println(ans);
                continue;
            }

            int min = Math.min(a, b);
            int max = Math.max(a, b);
            a = min;
            b = max;

            int val1 = arr[a];
            int val2 = arr[b];

            if (val1 - 1 >= 1 && ind[val1 - 1] >= a && ind[val1 - 1] <= b) {
                ans--;
            }
            if (val1 + 1 <= n && ind[val1 + 1] >= a && ind[val1 + 1] <= b) {
                ans++;
            }
            if (val2 - 1 >= 1 && ind[val2 - 1] >= a && ind[val2 - 1] <= b) {
                ans++;
            }
            if (val2 + 1 <= n && ind[val2 + 1] >= a && ind[val2 + 1] <= b) {
                ans--;
            }

            if (Math.abs(arr[a] - arr[b]) == 1) {
                if (arr[a] + 1 == arr[b]) ans--;
                else ans++;
            }

            ind[arr[a]] = b;
            ind[arr[b]] = a;

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;

            out.println(ans);
        }

        out.flush();
        out.close();
    }
}


 
 
 
 
