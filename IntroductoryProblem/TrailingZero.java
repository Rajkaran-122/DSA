package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class TrailingZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n =sc.nextInt();
        long ans=0;
        for(int i=5; i<=n; i*=5){
            ans+=(n/i);
        }
        System.out.println(ans);
    }
}



 
 
 
 
