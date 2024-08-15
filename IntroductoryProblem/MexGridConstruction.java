package IntroductoryProblem;

import java.util.*;
import java.io.*;

//







public class MexGridConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int dp[][] = new int[n][n];
        ArrayList<HashSet<Integer>>row = new ArrayList<>();
        ArrayList<HashSet<Integer>>col = new ArrayList<>();
        for(int i=0; i<n; i++){
            row.add(new HashSet<>());
            dp[0][i]=i;
            dp[i][0]=i;
            row.get(i).add(i);
            col.add(new HashSet<>());
            col.get(i).add(i);
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                HashSet<Integer> r=row.get(i);
                HashSet<Integer> c =col.get(j);
                int cnt=0;
                while(r.contains(cnt)||c.contains(cnt)){
                    cnt++;
                }
                dp[i][j]=cnt;
                r.add(cnt);
                c.add(cnt);
            }
        }
        for(int i[]: dp){
            for(int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
}



 
 
 
 
