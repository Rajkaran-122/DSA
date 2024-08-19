package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =sc.next();
        int i=0;
        int cnt=0;
        int max=0;
        while(i<s.length()){
            if(s.charAt(i)=='A'){
                while(i<s.length()&&s.charAt(i)=='A'){
                    cnt++;
                    i++;
                }
                max=Math.max(max,cnt);
                cnt=0;
                continue;
            }
           else if(s.charAt(i)=='C'){
                while(i<s.length()&&s.charAt(i)=='C'){
                    cnt++;
                    i++;
                }
                max=Math.max(max,cnt);
                cnt=0;
                continue;
            }
           else if(s.charAt(i)=='G'){
                while(i<s.length()&&s.charAt(i)=='G'){
                    cnt++;
                    i++;
                }
                max=Math.max(max,cnt);
                cnt=0;
                continue;
            }
           else if(s.charAt(i)=='T'){
                while(i<s.length()&&s.charAt(i)=='T'){
                    cnt++;
                    i++;
                }
                max=Math.max(max,cnt);
                cnt=0;
                continue;
            }

            i++;
        }
        System.out.println(max);
    }
}



 
 
 
 
