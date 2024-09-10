package SortingAndSearching;

import java.util.*;
import java.io.*;

import com.sun.source.tree.Tree;





public class TrafficLights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        int p[] = new int[n];

        for(int i=0; i<n; i++){
            p[i]=sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(x);

        for(int i = 0; i < n; i++){
            Integer l = set.lower(p[i]);
            Integer r = set.higher(p[i]);
//            System.out.println(l+" "+r);
            int maxLen = Math.max(p[i] - l, r - p[i]);
            System.out.print(maxLen+" ");

            set.add(p[i]);
        }
        System.out.println();
    }
}



 
 
 
 
