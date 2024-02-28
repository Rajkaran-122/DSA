package DyanamicProgramming;

import java.util.*;
import java.io.*;

//




public class gridPath {

   public static String solve(char grid[][], int i, int j,String dp[][],String ans){
       if(i == grid.length - 1 && j == grid[0].length - 1) {
           return String.valueOf(grid[i][j]);
       }
       if(!dp[i][j].equals("null"))return dp[i][j];
       if(i >= grid.length || j >= grid[0].length) {
           return "@";
       }

       String s1=grid[i][j]+solve(grid,i+1,j,dp,ans);
       String s2=grid[i][j]+solve(grid,i,j+1,dp,ans);
       if(s1.charAt(s1.length()-1)=='@'&&s2.charAt(s2.length()-1)=='@'){
           return ans;
       }

       if(s1.charAt(s1.length()-1)=='@'){
           return dp[i][j]= s2;
       }
       else if(s2.charAt(s2.length()-1)=='@'){
           return dp[i][j]=s1;
       }

       if(s1.compareTo(s2)<0){
           return dp[i][j]=s1;
       }
       else return dp[i][j]=s2;
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        char grid[][] = new char[n][n];
        for(int i=0; i<n; i++){
            String s=sc.next();
            grid[i]=s.toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        String dp[][] = new String[n+1][n+1];
        for(String i[]: dp) Arrays.fill(i,"null");

        for(int i=0; i<n; i++){
            sb.append("z");
        }

        System.out.println(solve(grid,0,0,dp,sb.toString()));

    }
}



 
 
 
 
 
