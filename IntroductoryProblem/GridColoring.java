package IntroductoryProblem;

import java.util.*;
import java.io.*;

public class GridColoring {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] dp = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            dp[i] = s.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char top = 'z';
                char left = 'z';
                char curr = dp[i][j];

                HashSet<Character> set = new HashSet<>();

                if (i - 1 >= 0) top = dp[i - 1][j];
                if (j - 1 >= 0) left = dp[i][j - 1];

                set.add(top);
                set.add(left);
                set.add(curr);

                if (!set.contains('A')) dp[i][j] = 'A';
                else if (!set.contains('B')) dp[i][j] = 'B';
                else if (!set.contains('C')) dp[i][j] = 'C';
                else if (!set.contains('D')) dp[i][j] = 'D';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dp[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}



 
 
 
 
