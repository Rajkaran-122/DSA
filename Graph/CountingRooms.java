package Graph;

import java.util.*;
import java.io.*;

//





public class CountingRooms {
    public static void DFS(int i, int j, boolean vis[][], char grid[][]) {
        vis[i][j] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            int dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for (int k[] : dir) {
                int x = k[0] + r;
                int y = k[1] + c;
                if (0 <= x && grid.length > x && 0 <= y && grid[0].length > y) {
                    if (!vis[x][y] && grid[x][y] != '#') {
                        q.add(new int[]{x, y});
                        vis[x][y] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char grid[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            grid[i] = s.toCharArray();
        }

        boolean vis[][] = new boolean[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] != '#') {
                    ans++;
                    DFS(i, j, vis, grid);
                }
            }
        }

        System.out.println(ans);
    }
}



 
 
 
 
