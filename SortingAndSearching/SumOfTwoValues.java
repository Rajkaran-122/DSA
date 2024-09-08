package SortingAndSearching;

import java.util.*;
import java.io.*;

public class SumOfTwoValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int left=-1;
        int right=-1;
        HashMap<Integer,Integer>map = new HashMap();

        for(int i=0; i<arr.length; i++){
            int val=x-arr[i];
            if(map.containsKey(val)){
                left=map.get(val)+1;
                right=i+1;
                break;
            }
            map.put(arr[i],i);
        }
        if(left==-1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(left+" "+right);
        }
    }
}



 
 
 
 
