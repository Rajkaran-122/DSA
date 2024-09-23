import java.util.*;
import java.io.*;

public class LazySegmentTree {
   static void build(int i, int l, int r, long[] seg, long[] arr, long[] lazy) {
        if (l == r) {
            seg[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        build(2*i+1, l, mid, seg, arr, lazy);
        build(2*i+2, mid+1, r, seg, arr, lazy);
        seg[i] = seg[2*i+1] + seg[2*i+2];
    }

   static void push(int i, int l, int r, long[] seg, long[] lazy) {
        if (lazy[i] != 0) {
            seg[i] += (long)(r-l+1) * lazy[i];
            if (l != r) {
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }
    }

   static void update(int ql, int qr, int val, int i, int l, int r, long[] seg, long[] lazy) {
        push(i, l, r, seg, lazy);

        if (qr < l || ql > r) return;

        if (ql <= l && r <= qr) {
            lazy[i] += val;
            push(i, l, r, seg, lazy);
            return;
        }

        int mid = (l+r)/2;
        update(ql, qr, val, 2*i+1, l, mid, seg, lazy);
        update(ql, qr, val, 2*i+2, mid+1, r, seg, lazy);

        seg[i] = seg[2*i+1] + seg[2*i+2];
    }

   static long query(int ql, int qr, int i, int l, int r, long[] seg, long[] lazy) {
        push(i, l, r, seg, lazy);

        if (qr < l || ql > r) return 0;

        if (ql <= l && r <= qr) return seg[i];

        int mid = (l+r)/2;
        return query(ql, qr, 2*i+1, l, mid, seg, lazy)
                + query(ql, qr, 2*i+2, mid+1, r, seg, lazy);
    }
    public static void main(String[] args) {

    }
}



 
 
 
 
 
 
