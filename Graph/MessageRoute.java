package Graph;

import java.util.*;
import java.io.*;

public class MessageRoute {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int dp[][] = new int[m][2];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int a = dp[i][0] - 1;
            int b = dp[i][1] - 1;
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int path[] = new int[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int u = arr[0];
            int cost = arr[1];

            for(int v : list.get(u)){
                if(dist[v] > cost + 1){
                    dist[v] = cost + 1;
                    path[v] = u;
                    pq.add(new int[]{v, cost + 1});
                }
            }
        }

        if(dist[n-1] == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        } else {

            ArrayList<Integer> ans = new ArrayList<>();
            int ind = n - 1;

            while(ind != 0){
                ans.add(ind);
                ind = path[ind];
            }
            ans.add(0);

            System.out.println(ans.size());

            for(int i = ans.size() - 1; i >= 0; i--){
                System.out.print((ans.get(i) + 1) + " ");
            }
            System.out.println();
        }
    }
}


 
 
 
 
