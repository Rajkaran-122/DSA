import java.util.*;
import java.io.*;

class RangeSumQuery {

    // -------- BUILD --------
    public static void build(int i, int l, int r, int[] seg, int[] arr) {
        if (l == r) {
            seg[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * i + 1, l, mid, seg, arr);
        build(2 * i + 2, mid + 1, r, seg, arr);
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    // -------- RANGE QUERY --------
    public static int query(int ql, int qr, int i, int l, int r, int[] seg) {
        if (qr < l || ql > r) return 0; // no overlap
        if (ql <= l && r <= qr) return seg[i]; // total overlap

        int mid = l + (r - l) / 2;
        return query(ql, qr, 2 * i + 1, l, mid, seg)
                + query(ql, qr, 2 * i + 2, mid + 1, r, seg);
    }

    // -------- POINT UPDATE --------
    public static void update(int idx, int val, int i, int l, int r, int[] seg) {
        if (l == r) {
            seg[i] = val;
            return;
        }
        int mid = l + (r - l) / 2;

        if (idx <= mid) update(idx, val, 2 * i + 1, l, mid, seg);
        else update(idx, val, 2 * i + 2, mid + 1, r, seg);

        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    // -------- EXAMPLE SUM QUERY DRIVER --------
    public static void main(String[] args) {

    }
}



 
 
 
 
 
 
