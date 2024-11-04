import java.util.*;
import java.io.*;

class threeSum {
    public List<List<Integer>> threeSum(int[] a) {
        Set<List<Integer>> r = new HashSet<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1, h = a.length - 1;
            while (l < h) {
                int s = a[i] + a[l] + a[h];
                if (s == 0) {
                    r.add(Arrays.asList(a[i], a[l], a[h]));
                    l++; h--;
                } else if (s < 0) l++;
                else h--;
            }
        }
        return new ArrayList<>(r);
    }
}




 
 
 
 
 
 
