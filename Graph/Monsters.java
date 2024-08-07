package Graph;

import java.util.*;
import java.io.*;

//





public class Monsters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char grid[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            grid[i] = s.toCharArray();
        }
        Queue<int[]> man = new LinkedList<>();
        Queue<int[]> monsters = new LinkedList<>();
        int sx = -1;
        int sy = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    man.add(new int[]{i, j});
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'M') monsters.add(new int[]{i, j});
            }
        }
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char path[][] = new char[n][m];
        boolean vis[][] = new boolean[n][m];
        boolean bt = false;
        int ni = -1;
        int nj = -1;
        while (!man.isEmpty()) {
            int sz = monsters.size();
//          grid[r1][c1]='#';
            while (sz-- > 0) {
                int mnr[] = monsters.poll();
                int r1 = mnr[0];
                int c1 = mnr[1];
                for (int i[] : dir) {
                    int x = i[0] + r1;
                    int y = i[1] + c1;
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        if (grid[x][y] != '#' && grid[x][y] != 'M') {
                            monsters.add(new int[]{x, y});
                            grid[x][y] = 'M';
                        }
                    }
                }
            }

            int size = man.size();
            while (size-- > 0) {
//                System.out.println("start");
                int mr[] = man.poll();
                int r = mr[0];
                int c = mr[1];
                if(r==0||r==n-1||c==0||c==m-1){
                    bt=true;
                    break;
                }
                for (int i[] : dir) {
                    int x = i[0] + r;
                    int y = i[1] + c;
//                    System.out.println(x+" "+y);
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        if (grid[x][y] != '#' && !vis[x][y] && grid[x][y] != 'M') {
//                            System.out.println(x + " " + y);
                            man.add(new int[]{x, y});
                            vis[x][y] = true;
                            grid[x][y] = 'V';
                            char ch = '#';
                            if (i[0] == 1) ch = 'D';
                            if (i[0] == -1) ch = 'U';
                            if (i[1] == 1) ch = 'R';
                            if (i[1] == -1) ch = 'L';
                            path[x][y] = ch;

                            if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                                ni = x;
                                nj = y;
                                bt = true;
                            }
                        }
                    }
                }

            }
            if (bt) break;

        }
        if (bt) {
            StringBuilder sb = new StringBuilder();
            System.out.println("YES");

            while ((ni != sx || nj != sy)&&(ni!=-1&&nj!=-1)) {
                if (path[ni][nj] == 'U') {
                    sb.append('U');
                    ni++;
                } else if (path[ni][nj] == 'D') {
                    sb.append('D');
                    ni--;
                }
                if (path[ni][nj] == 'R') {
                    sb.append('R');
                    nj--;
                }
                if (path[ni][nj] == 'L') {
                    sb.append('L');
                    nj++;
                }
            }
            sb.reverse();
            System.out.println(sb.length());
            System.out.println(sb.toString());

        } else {
            System.out.println("NO");
        }
    }
}



 
 
 
 
