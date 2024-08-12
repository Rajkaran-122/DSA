package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class GrayCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n =sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<Math.pow(2,n); i++){
                  int val=i ^ (i >> 1);
                String bin = Integer.toBinaryString(val);

                list.add(bin);

            }

            for(String i: list){
                String s="";
                if(i.length()<n){
                    s="";
                    int len=i.length();
                    while(len!=n){
                        s+="0";
                        len++;
                    }

                }
                System.out.println(s+i);
            }
    }
}



 
 
 
 
