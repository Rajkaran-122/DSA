package Graph;

import java.util.*;
import java.io.*;

public class Labyrinth {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char grid[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        int dist[][] = new int[n][m];
        char parent[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(parent[i], '#');
        }

        int sx = -1, sy = -1, ex = -1, ey = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 'B') {
                    ex = i;
                    ey = j;
                }
            }
        }

        q.add(new int[]{sx, sy, 0});
        dist[sx][sy] = 0;

        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        char move[] = {'U','D','R','L'};

        while (!q.isEmpty()) {

            int arr[] = q.poll();
            int x = arr[0];
            int y = arr[1];
            int cost = arr[2];

            if (cost > dist[x][y]) continue;

            for (int k = 0; k < 4; k++) {

                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] != '#') {

                    if (dist[x][y] + 1 < dist[nx][ny]) {

                        dist[nx][ny] = dist[x][y] + 1;
                        parent[nx][ny] = move[k];

                        q.add(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }
        }

        if (dist[ex][ey] == Integer.MAX_VALUE) {
            System.out.println("NO");
        } else {

            System.out.println("YES");
            System.out.println(dist[ex][ey]);

            // Reconstruct path
            StringBuilder path = new StringBuilder();
            int x = ex, y = ey;


            while (x != sx || y != sy) {

                char d = parent[x][y];
                path.append(d);

                if (d == 'U') x++;
                else if (d == 'D') x--;
                else if (d == 'L') y++;
                else if (d == 'R') y--;
            }

            System.out.println(path.reverse().toString());
        }
    }
}


 
 
 
 
