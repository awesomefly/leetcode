package main.java.com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PrimeCount {
    public boolean isPrime(int num) {
        for (int i = 2; i*i < num; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }

    public int countPrime(int n) {
        boolean[] primeFlag = new boolean[n];
        Arrays.fill(primeFlag, true);

        for (int i = 2; i < n; i++) {
            if (primeFlag[i]) {
                for (int j = 2 * i; j < n; j = j+i) {
                    primeFlag[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean tmp:primeFlag) {
            if (tmp) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("primesCount:"+ new PrimeCount().countPrime(100));
    }
}
