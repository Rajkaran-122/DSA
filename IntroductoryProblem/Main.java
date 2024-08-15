package IntroductoryProblem;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] parts = br.readLine().split(" ");
			long x = Long.parseLong(parts[0]) - 1;
			long y = Long.parseLong(parts[1]) - 1;

			if (y >= x) {
				if (y % 2 != 0) {
					long stVal = y * y + 1;
					sb.append(stVal + x).append("\n");
				} else {
					long stVal = y * y + 1;
					sb.append(stVal + y + (y - x)).append("\n");
				}
			} else {
				if (x % 2 != 0) {
					long stVal = x * x + 1;
					sb.append(stVal + x + (x - y)).append("\n");
				} else {
					long stVal = x * x + 1;
					sb.append(stVal + y).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
}



 
 
 
 
