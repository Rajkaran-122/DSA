package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class CoinPiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            long a=sc.nextLong();
            long b =sc.nextLong();
            long x=-1;
            long y=-1;
            if((2*b-a)%3==0){
                x=(2*b-a)/3;
            }
            if(x!=-1&&(a-x)%2==0){
                y=(a-x)/2;
            }
            if(x>=0&&y>=0){
                sb.append("YES").append("\n");
            }
            else sb.append("NO").append("\n");

        }
        System.out.println(sb.toString());
    }
}



 
 
 
 
