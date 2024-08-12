package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class DigitQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long k = sc.nextLong()+1;
            if(k<=10){
                System.out.println(k-1);
            }
            else{
                k-=10;
                long i=10;
                long j=9;
                int cnt=2;
                while(k-(9*i*cnt)>=0){
                    k-=(j*i)*cnt;
                    cnt++;
                    i*=10;
                }
                long val=k/cnt;
                long rem=k%cnt;
                long fnd=1;
                for(int m=0; m<cnt-1; m++){
                    fnd*=10;
                }
                fnd+=val-1;
                if(rem>0)fnd++;
                String s=String.valueOf(fnd);
//            System.out.println(s);
                if(rem==0)rem=s.length();
                System.out.println(s.charAt((int)rem-1));
            }
        }
    }
}



 
 
 
 
