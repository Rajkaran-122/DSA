package SortingAndSearching;

import java.util.*;
import java.io.*;

public class Josephus {
    static final int MAXN = 300006;
    static ArrayList<Integer>[] divisors;

    public static void computeDivisors() {
        divisors = new ArrayList[MAXN + 1];
        for (int i = 1; i <= MAXN; i++) {
            divisors[i] = new ArrayList<>();
        }

        for (int i = 1; i <= MAXN; i++) {
            for (int j = i; j <= MAXN; j += i) {
                divisors[j].add(i);
            }
        }
    }


    /* ---------- SOLVE ---------- */


    static long MOD = 1_000_000_007;

    static long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    static void solve(FastScanner sc) {
        int cnt=0;

        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        ArrayList<Integer>ans = new ArrayList<>();


        boolean bt=false;
        while(!q.isEmpty()){
            if(!bt){
                int val=q.poll();
                q.add(val);
            }
            else{
                ans.add(q.poll());
            }
            bt= !bt;
        }


        for(int i: ans) System.out.print(i+" ");
        System.out.println();


    }


    public static long maximumSubarraySum(long arr[]) {
        long max = arr[0];
        long sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static long minimumSubarraySum(long arr[]) {
        long min = arr[0];
        long sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum > arr[i]) sum = arr[i];
            min = Math.min(min, sum);
        }
        return min;
    }

    /* ---------------- UTILITIES ---------------- */
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    static List<Integer> toBits(long num) {
        List<Integer> bits = new ArrayList<>();
        if (num == 0) {
            bits.add(0);
            return bits;
        }
        while (num > 0) {
            bits.add((int) (num & 1));
            num >>= 1;
        }
        Collections.reverse(bits);
        return bits;
    }

    public static int countBits(long n) {
        return Long.bitCount(n);
    }

    static long[] prefixSum(long[] arr) {
        long[] pref = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) pref[i + 1] = pref[i] + arr[i];
        return pref;
    }

    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    static long abs(long x) {
        return x < 0 ? -x : x;
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }

    static long min(long a, long b) {
        return Math.min(a, b);
    }

    /* ---------------- SIEVE WITH SPF ---------------- */
    static int[] spf;
    static ArrayList<Integer> primes = new ArrayList<>();
    static HashSet<Integer> set = new HashSet<>();

    static void sieve(int n) {
        spf = new int[n + 1];

        for (int i = 1; i <= n; i++)
            spf[i] = i;

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (spf[i] == i) {
                primes.add(i);
                set.add(i);
            }
        }
    }

    static ArrayList<Integer> getPrimeFactors(int x) {
        ArrayList<Integer> factors = new ArrayList<>();

        while (x != 1) {
            factors.add(spf[x]);
            x /= spf[x];
        }

        return factors;
    }


    /* ---------------- FAST INPUT ---------------- */
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    /* ---------------- MAIN ---------------- */
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        // Call sieve for numbers up to 1,000,000 if you need
//        sieve(1000000);
        //        initFact(200000);
        //        computeDivisors();
        int t = 1;
//        t = sc.nextInt();


        while (t-- > 0) solve(sc);
        out.flush();
    }
}


 
 
 
 
