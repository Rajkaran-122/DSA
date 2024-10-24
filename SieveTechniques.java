import java.util.*;
import java.io.*;

public class SieveTechniques {

    static int N = 100000;          // limit (1e5)
    static boolean[] isPrime = new boolean[N + 1];
    static int[] spf = new int[N + 1];   // smallest prime factor
    static List<Integer> primes = new ArrayList<>();
    static List<Integer>[] divisors = new ArrayList[N + 1];

    public static void main(String[] args) {

        sieve();              // build isPrime, primes list
        buildSPF();           // build smallest prime factor
        buildAllDivisors();   // build divisors for every number

        // Example usage
        int num = 84;

        System.out.println("Is Prime: " + isPrime[num]);
        System.out.println("Prime Factorization: " + getPrimeFactorization(num));
        System.out.println("All Divisors: " + getDivisorsUsingSPF(num));
    }

    // ---------------------------------------------------------
    // 1️⃣ Normal Sieve (O(N log log N))
    static void sieve() {

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }

    // ---------------------------------------------------------
    // 2️⃣ Smallest Prime Factor Sieve (O(N log log N))
    static void buildSPF() {

        for (int i = 1; i <= N; i++)
            spf[i] = i;

        for (int i = 2; i * i <= N; i++) {
            if (spf[i] == i) {   // prime
                for (int j = i * i; j <= N; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }
    }

    // ---------------------------------------------------------
    // 3️⃣ Get Prime Factorization in O(log N)
    static List<Integer> getPrimeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();

        while (n != 1) {
            factors.add(spf[n]);
            n /= spf[n];
        }
        return factors;
    }

    // ---------------------------------------------------------
    // 4️⃣ Get All Divisors of ONE number using SPF
    static List<Integer> getDivisorsUsingSPF(int n) {

        List<Integer> divisors = new ArrayList<>();
        divisors.add(1);

        while (n > 1) {
            int prime = spf[n];
            int count = 0;

            while (n % prime == 0) {
                n /= prime;
                count++;
            }

            int size = divisors.size();
            for (int i = 0; i < size; i++) {
                int val = divisors.get(i);
                int mul = 1;
                for (int j = 0; j < count; j++) {
                    mul *= prime;
                    divisors.add(val * mul);
                }
            }
        }

        return divisors;
    }

    // ---------------------------------------------------------
    // 5️⃣ Precompute all divisors for every number (O(N log N))
    static void buildAllDivisors() {

        for (int i = 1; i <= N; i++)
            divisors[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                divisors[j].add(i);
            }
        }
    }
}


 
 
 
 
 
 
