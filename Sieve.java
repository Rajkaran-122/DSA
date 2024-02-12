import java.util.*;
import java.io.*;

public class Sieve {
    static int[] spf;
    static ArrayList<Integer> primes = new ArrayList<>();

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
            if (spf[i] == i) primes.add(i);
        }
    }
    public static void main(String[] args) {


    }
}



 
 
 
 
 
