import java.util.*;
import java.io.*;

public class RangeMinQuery {
   static void build(int i, int l, int r, int[] seg, int[] arr) {
        if (l == r) {
            seg[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        build(2*i+1, l, mid, seg, arr);
        build(2*i+2, mid+1, r, seg, arr);
        seg[i] = Math.min(seg[2*i+1], seg[2*i+2]);
    }

   static int query(int ql, int qr, int i, int l, int r, int[] seg) {
        if (qr < l || ql > r) return Integer.MAX_VALUE;
        if (ql <= l && r <= qr) return seg[i];

        int mid = (l+r)/2;
        return Math.min(
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

        seg[i] = Math.min(seg[2*i+1], seg[2*i+2]);
    }
    public static void main(String[] args) {
         int arr[]={5,4,6,1,8,7,5,6,8,6};
         int n =arr.length;
         int seg[] = new int[4*n];
         build(0,0,n-1,seg,arr);
        System.out.println(query(8,8,0,n-1,0,seg));
        update(4,-55,0,n-1,0,seg);
        System.out.println(query(2,6,0,n-1,0,seg));
    }
}



 
 
 
 
 
