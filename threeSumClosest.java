import java.util.*;

class Solution {
    public int threeSumClosest(int[] a, int t) {
        Arrays.sort(a);
        int r = a[0] + a[1] + a[2];
        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1, h = a.length - 1;
            while (l < h) {
                int s = a[i] + a[l] + a[h];
                if (Math.abs(s - t) < Math.abs(r - t)) r = s;
                if (s == t) return s;
                if (s < t) l++;
                else h--;
            }
        }
        return r;
    }
}
