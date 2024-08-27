package SortingAndSearching;

import java.util.*;
import java.io.*;

//





public class ConcertTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m=sc.nextInt();
        int h[] = new int[n]; 
        int t[] = new int[m];
        for(int i=0; i<n; i++){
            h[i]=sc.nextInt();
        }
        for(int i=0; i<m; i++){
            t[i]=sc.nextInt();
        }

        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(int i=0; i<n; i++){
            map.put(h[i],map.getOrDefault(h[i],0)+1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            int val=t[i];
            Integer k =map.floorKey(val);
            if(k==null){
                ans.add(-1);
            }
            else {
                ans.add(k);
                map.put(k,map.getOrDefault(k,0)-1);
                if(map.get(k)==0)map.remove(k);
            }
        }
        for(int i: ans) System.out.println(i);
    }
}



 
 
 
 
