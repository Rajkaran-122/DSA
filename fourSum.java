import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] a, long t) {
        Set<List<Integer>> r = new HashSet<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 3; i++) {
            for (int j = i + 1; j < a.length - 2; j++) {
                int l = j + 1, h = a.length - 1;
                while (l < h) {
                    long s = (long)a[i] + a[j] + a[l] + a[h];
                    if (s == t) {
                        r.add(Arrays.asList(a[i], a[j], a[l], a[h]));
                        l++; h--;
                    } else if (s < t) l++;
                    else h--;
                }
            }
        }
        return new ArrayList<>(r);
    }
}
