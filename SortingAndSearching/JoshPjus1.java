package SortingAndSearching;

import java.util.*;
import java.io.*;

public class JoshPjus1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        if(n%2==0){
            for(int i=1; i<=n; i+=2)System.out.println(i+" ");
            for(int i=2; i<=n; i+=2)System.out.println(i+" ");
        }
        else{
            for(int i=2; i<=n; i+=2)System.out.println(i+" ");
            for(int i=1; i<=n; i+=2)System.out.println(i+" ");
        }
    }
}



 
 
 
 
