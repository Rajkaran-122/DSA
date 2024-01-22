import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int m=sc.nextInt();
            int dp[][] = new int[n][m];
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    dp[i][j]=sc.nextInt();
                    set.add(dp[i][j]);
                }
            }

            HashMap<Integer,Integer>map = new HashMap<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){

                    int top=(i-1>=0)?dp[i-1][j]:-1;
                    int down=(i+1<n)?dp[i+1][j]:-1;
                    int left=(j-1>=0)?dp[i][j-1]:-1;
                    int right=(j+1<m)?dp[i][j+1]:-1;
                    int cnt=0;
                    if(left==dp[i][j]||right==dp[i][j]||top==dp[i][j]||down==dp[i][j]){
                        map.put(dp[i][j],2);
                    }
                    else{
                        if(map.getOrDefault(dp[i][j],0)==0){
                            map.put(dp[i][j],1);
                        }
                    }

                }
            }
            ArrayList<Integer>list = new ArrayList<>();

            for(int i: map.keySet()){
                list.add(map.get(i));
            }
            Collections.sort(list);
            int ans=0;
            for(int i=0; i<list.size()-1;i++){
                ans+=list.get(i);
            }
            System.out.println(ans);

        }
    }
}


 
 
 
 
 
