package SortingAndSearching;

import java.util.*;
import java.io.*;

//




public class MaximumSubarraySum2 {

    static void build(int i, int l, int r, long[] seg, long[] arr) {
        if (l == r) {
            seg[i] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        build(2 * i + 1, l, mid, seg, arr);
        build(2 * i + 2, mid + 1, r, seg, arr);

        seg[i] = Math.min(seg[2 * i + 1], seg[2 * i + 2]);
    }

    static long query(int ql, int qr, int i, int l, int r, long[] seg) {

        if (qr < l || ql > r) return Long.MAX_VALUE;

        if (ql <= l && r <= qr) return seg[i];

        int mid = (l + r) / 2;

        return Math.min(
                query(ql, qr, 2 * i + 1, l, mid, seg),
                query(ql, qr, 2 * i + 2, mid + 1, r, seg)
        );
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long[] seg = new long[4 * n];
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        long[] pre = new long[n];

        pre[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        build(0, 0, n - 1, seg, pre);

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int left = i - a;
            int right = Math.max(0, i - b);

            if (left >= 0) {

                long min = query(right, left, 0, 0, n - 1, seg);

                ans = Math.max(ans, pre[i] - min);
            }

            if (i + 1 >= a && i + 1 <= b)
                ans = Math.max(ans, pre[i]);
        }

        System.out.println(ans);
    }
}


 
 
 
 
