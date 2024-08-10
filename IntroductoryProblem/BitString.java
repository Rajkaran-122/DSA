package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class BitString {
    public static int solve(int n){
        long ans=1;
        for(int i=0; i<n; i++){
            ans=(ans*2)%1000000007;
        }
        return (int)ans%1000000007;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(solve(n));


    }
}



 
 
 
 
