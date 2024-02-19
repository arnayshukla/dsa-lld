package com.practice.java.dsa;;

//Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).
public class PowXToN {
    public static void main(String[] args) {
        int x = 5;
        int n = 3;
        double result = pow(x, n);
        System.out.println(result);

    }

    private static double pow(int x, int n) {
        int m = n;
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0)
            m = -1 * m;
        double ans = 1;
        while (m != 0) {
            if (m % 2 == 0) {
                x = x * x;
                m = m / 2;
            } else {
                ans = ans * x;
                m = m - 1;
            }
        }
        return n < 0 ? (double) 1 / ans : ans;
    }
}
