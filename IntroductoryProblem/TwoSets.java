package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = n * (n + 1) / 2;

        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        ArrayList<Long> set1 = new ArrayList<>();
        ArrayList<Long> set2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        long target = sum / 2;

        for (long i = n; i >= 1; i--) {
            if (target >= i) {
                set1.add(i);
                sb.append(i+" ");
                target -= i;
            } else {
                sb2.append(i+" ");
                set2.add(i);
            }
        }

        System.out.println("YES");
        System.out.println(set1.size());
        System.out.println(sb.toString());

        System.out.println(set2.size());
        System.out.println(sb2.toString());

    }
}



 
 
 
 
