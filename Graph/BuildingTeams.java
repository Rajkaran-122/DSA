package Graph;

import java.util.*;
import java.io.*;

public class BuildingTeams {

    static boolean BFS(int node,
                       ArrayList<ArrayList<Integer>> adj,
                       boolean vis[],
                       ArrayList<Integer> comp,
                       char path[]) {

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        path[node] = 'R';

        boolean bad = false;

        while (!q.isEmpty()) {
            int u = q.poll();
            comp.add(u);

            for (int v : adj.get(u)) {

                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                    path[v] = (path[u] == 'R') ? 'B' : 'R';
                }
                else if (path[v] == path[u]) {
                    bad = true;
                }
            }
        }
        return bad;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u - 1).add(v - 1);
            list.get(v - 1).add(u - 1);
        }

        char Path[] = new char[n];
        Arrays.fill(Path, 'X');

        boolean vis[] = new boolean[n];
        int ans1[] = new int[n];

        boolean att = false;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {

                ArrayList<Integer> ans = new ArrayList<>();

                boolean bt = BFS(i, list, vis, ans, Path);

                if (!bt) {
                    for (int it : ans) {
                        if (Path[it] == 'R') ans1[it] = 1;
                        else ans1[it] = 2;
                    }
                } else {
                    System.out.println("IMPOSSIBLE");
                    att = true;
                    break;
                }
            }
        }

        if (!att) {
            StringBuilder sb = new StringBuilder();
            for (int i : ans1) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
    }
}


 
 
 
 
