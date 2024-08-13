package IntroductoryProblem;

import java.util.*;
import java.io.*;

//




public class GridpathDescription {

    public static int solve(int grid[][], int i, int j, String s, boolean vis[][], int step) {

        if (i == 6 && j == 0) {
            return (step == 48) ? 1 : 0;
        }

        if (i < 0 || j < 0 || i > 6 || j > 6 || step >= 48 || vis[i][j]) {
            return 0;
        }
        //up is blocked and down is blocked
        if ((i == 0 || vis[i - 1][j]) && (i == 6 || vis[i + 1][j]) &&
                j > 0 && j < 6 && !vis[i][j - 1] && !vis[i][j + 1]) {
            return 0;
        }
        // left and right is blocked
        if ((j == 0 || vis[i][j - 1]) && (j == 6 || vis[i][j + 1]) &&
                i > 0 && i < 6 && !vis[i - 1][j] && !vis[i + 1][j]) {
            return 0;
        }

        vis[i][j] = true;
        int ans = 0;

        char c = s.charAt(step);

        if (c == '?') {
            if (i + 1 < 7 && !vis[i + 1][j])
                ans += solve(grid, i + 1, j, s, vis, step + 1);

            if (i - 1 >= 0 && !vis[i - 1][j])
                ans += solve(grid, i - 1, j, s, vis, step + 1);

            if (j + 1 < 7 && !vis[i][j + 1])
                ans += solve(grid, i, j + 1, s, vis, step + 1);

            if (j - 1 >= 0 && !vis[i][j - 1])
                ans += solve(grid, i, j - 1, s, vis, step + 1);
        }
        else {
            if (c == 'R' && j + 1 < 7 && !vis[i][j + 1])
                ans += solve(grid, i, j + 1, s, vis, step + 1);

            else if (c == 'L' && j - 1 >= 0 && !vis[i][j - 1])
                ans += solve(grid, i, j - 1, s, vis, step + 1);

            else if (c == 'D' && i + 1 < 7 && !vis[i + 1][j])
                ans += solve(grid, i + 1, j, s, vis, step + 1);

            else if (c == 'U' && i - 1 >= 0 && !vis[i - 1][j])
                ans += solve(grid, i - 1, j, s, vis, step + 1);
        }

        vis[i][j] = false;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        boolean vis[][] = new boolean[7][7];
        for (boolean row[] : vis) Arrays.fill(row, false);

        int grid[][] = new int[7][7];

        int val = solve(grid, 0, 0, s, vis, 0);
        System.out.println(val);
    }
}



 
 
 
 
