import java.util.*;
import java.io.*;

public class GCDSegmentTree {
   static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

   static void build(int i, int l, int r, int[] seg, int[] arr) {
        if (l == r) {
            seg[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        build(2*i+1, l, mid, seg, arr);
        build(2*i+2, mid+1, r, seg, arr);
        seg[i] = gcd(seg[2*i+1], seg[2*i+2]);
    }

   static int query(int ql, int qr, int i, int l, int r, int[] seg) {
        if (qr < l || ql > r) return 0;
        if (ql <= l && r <= qr) return seg[i];

        int mid = (l+r)/2;
        return gcd(
                query(ql, qr, 2*i+1, l, mid, seg),
                query(ql, qr, 2*i+2, mid+1, r, seg)
        );
    }

   static void update(int idx, int val, int i, int l, int r, int[] seg) {
        if (l == r) {
            seg[i] = val;
            return;
        }
        int mid = (l+r)/2;
        if (idx <= mid) update(idx, val, 2*i+1, l, mid, seg);
        else update(idx, val, 2*i+2, mid+1, r, seg);

        seg[i] = gcd(seg[2*i+1], seg[2*i+2]);
    }
    public static void main(String[] args) {

    }
}



 
 
 
 
 
 
