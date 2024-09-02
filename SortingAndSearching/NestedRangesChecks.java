package SortingAndSearching;

import java.util.*;
import java.io.*;

//




public class NestedRangesChecks {

    public static int find(int dp[][], int st){
        int left = 0, right = dp.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(dp[mid][0] > st){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int find2(int dp[][], int st){
        int left = 0, right = dp.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(dp[mid][0] < st){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        int dp[][] = new int[n][2];
        int acc[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            acc[i][0] = Integer.parseInt(st.nextToken());
            acc[i][1] = Integer.parseInt(st.nextToken());

            dp[i][0] = acc[i][0];
            dp[i][1] = acc[i][1];
        }

        Arrays.sort(dp, (a, b) -> Integer.compare(a[0], b[0]));

        int min[] = new int[n];
        min[n - 1] = dp[n - 1][1];

        for(int i = n - 2; i >= 0; i--){
            min[i] = Math.min(min[i + 1], dp[i][1]);
        }

        int max[] = new int[n];
        max[0] = dp[0][1];

        for(int i = 1; i < n; i++){
            max[i] = Math.max(max[i - 1], dp[i][1]);
        }

        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();

        for(int i[] : acc){
            int st = i[0];
            int end = i[1];

            int ind = find(dp, st);
            if(ind != -1 && min[ind] <= end){
                ans1.add(1);
            } else {
                ans1.add(0);
            }
        }

        for(int i[] : acc){
            int st = i[0];
            int end = i[1];

            int ind = find2(dp, st);
            if(ind != -1 && max[ind] >= end){
                ans2.add(1);
            } else {
                ans2.add(0);
            }
        }

        for(int i : ans1){
            out.print(i + " ");
        }
        out.println();

        for(int i : ans2){
            out.print(i + " ");
        }
        out.println();

        out.flush();
    }
}


 
 
 
 
