package SortingAndSearching;

import java.util.*;
import java.io.*;

//







public class DistinktValueSubArray {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        long ans = 0;
        int i = 0, j = 0;

        while(j < n){

            map.put(arr[j], map.getOrDefault(arr[j],0) + 1);

            while(map.size() > k){
                map.put(arr[i], map.get(arr[i]) - 1);
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
                i++;
            }

            ans += (j - i + 1);
            j++;
        }

        System.out.println(ans);
    }
}


 
 
 
 
