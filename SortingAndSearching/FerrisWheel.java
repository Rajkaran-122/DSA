package SortingAndSearching;

import java.util.*;
import java.io.*;

//






public class FerrisWheel {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int p[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        int i = 0, j = n - 1;
        int cnt = 0;

        while (i <= j) {
            if (i == j) {
                cnt++;
                break;
            }
            if (p[i] + p[j] <= x) {
                i++;
                j--;
                cnt++;
            } else {
                j--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}



 
 
 
 
