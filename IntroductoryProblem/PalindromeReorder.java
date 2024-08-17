package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            String s =sc.next();
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            int cnt=0;
            boolean bc=true;
            for(char i: map.keySet()){
                 if(map.get(i)%2!=0){
                     cnt++;
                 }
                 if(cnt>1) {
                     bc=false;
                     System.out.println("NO SOLUTION");
                     break;
                 };
            }

           if(bc){
               StringBuilder s1 = new StringBuilder();
               StringBuilder s2 = new StringBuilder();
               StringBuilder s3 = new StringBuilder();

               for (char i : map.keySet()) {
                   int val = map.get(i);
                   if (val % 2 != 0) {
                       s3.append(i);
                       val--;
                   }
                   for (int j = 0; j < val / 2; j++) {
                       s1.append(i);
                       s2.append(i);
                   }
               }

               StringBuilder ans = new StringBuilder();
               ans.append(s1);
               ans.append(s3);
               ans.append(s2.reverse());

               System.out.println(ans.toString());

           }


    }
}



 
 
 
 
