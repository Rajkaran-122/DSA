package Graph;

import java.util.*;
import java.io.*;

public class BuildingRoads {

    static int parent[];
    static int size[];
    static int components;

    public static int findRootParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    public static void unionBySize(int node1, int node2) {
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if (rootParent1 == rootParent2) return;

        components--;

        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        } else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        components = n;

        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            unionBySize(u,v);
        }

        System.out.println(components-1);

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(findRootParent(i));
        }

        ArrayList<Integer> list = new ArrayList<>(set);

        for(int i=1;i<list.size();i++){
            System.out.println((list.get(i-1)+1)+" "+(list.get(i)+1));
        }
    }
}


 
 
 
 
