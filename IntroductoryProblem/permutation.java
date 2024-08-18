package IntroductoryProblem;

import java.util.*;
import java.io.*;

class permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if (n == 1) {
            sb.append("1");
        } else if (n < 4) {
            sb.append("NO SOLUTION");
        } else if (n == 4) {
            sb.append("2 4 1 3");
        } else {
            for (int i = 1; i <= n; i += 2) {
                sb.append(i).append(" ");
            }
            for (int i = 2; i <= n; i += 2) {
                sb.append(i).append(" ");
            }

        }

        System.out.println(sb);
    }
}



 
 
 
 
