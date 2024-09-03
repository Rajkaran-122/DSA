package SortingAndSearching;

import java.util.*;
import java.io.*;

//





public class ResturantCustomers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
       TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            int val1=sc.nextInt();
            int val2=sc.nextInt();
            map.put(val1,1);
            map.put(val2,-1);
        }
        int max=0;
        int cnt=0;
        for(int i: map.values()){
            cnt+=i;
            max=Math.max(cnt,max);
        }
        System.out.println(max);
    }
}



 
 
 
 
