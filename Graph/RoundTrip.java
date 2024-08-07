package Graph;

import java.util.*;
import java.io.*;

public class RoundTrip {

    public static int checkPath(ArrayList<ArrayList<Integer>> list, int node, boolean vis[], int p, boolean path[]) {
        vis[node] = true;
        path[node] = true;

        for (int i : list.get(node)) {
            if (p == i) continue;

            if (path[i]) {
                return i;
            }

            int res = checkPath(list, i, vis, node, path);
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }

    public static boolean DFS(ArrayList<Integer> ans, int node, boolean path[],
                              ArrayList<ArrayList<Integer>> list, int p,int cNode) {

        path[node] = true;
        ans.add(node);

        for (int i : list.get(node)) {
            if (p == i||path[i]&&i!=cNode) continue;

            if (path[i]&&i==cNode) {
                return true;
            }

            if (DFS(ans, i, path, list, node,cNode)) {
                return true;
            }
        }
        ans.remove(ans.size()-1);
        return false;
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
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean vis[] = new boolean[n];
        boolean found = false;
        int cNode = -1;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                boolean path[] = new boolean[n];
                int cycleNode = checkPath(list, i, vis, -1, path);

                if (cycleNode != -1) {
                    found = true;
                    cNode = cycleNode;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> ans = new ArrayList<>();
            boolean path[] = new boolean[n];

            DFS(ans, cNode, path, list, -1,cNode);
            ans.add(cNode);

            System.out.println(ans.size());
            for (int it : ans) {
                System.out.print((it + 1) + " ");
            }
        }
    }
}


 
 
 
 
