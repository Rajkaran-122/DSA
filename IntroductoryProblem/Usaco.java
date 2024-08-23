package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class Usaco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b1=sc.nextInt();
        int b2=sc.nextInt();
        int s1=sc.nextInt();
        int s2=sc.nextInt();
        int g1=sc.nextInt();
        int g2=sc.nextInt();
        int p1=sc.nextInt();
        int p2=sc.nextInt();
        int ans1=0;
        int ans2=0;
        int ans3=0;
        ans3=p2-p1;
        g1-=ans3;
        ans2=g2-g1;
        s1-=ans2;
        ans1=s2-s1;
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}



 
 
 
 
