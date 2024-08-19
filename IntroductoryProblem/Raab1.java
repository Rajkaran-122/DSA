package IntroductoryProblem;

import java.util.*;
import java.io.*;

//



public class Raab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                System.out.println("YES");
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                continue;
            }
            if (a == 0 || b == 0 || a == n || b == n || a + b > n) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                int val = n - (a + b);
                for (int i = 1; i <= val; i++) {
                    System.out.print(i + " ");
                }
                int ans[] = new int[a + b];
                int ind = 0;
                for (int i = val + 1; i <= val + a + b; i++) {
                    int in = (ind - a + (a + b)) % (a + b);
                    ans[in] = i;
                    ind++;
                }
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}



 
 
 
 
