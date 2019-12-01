package com.skanda.java_practice;
// https://en.wikipedia.org/wiki/Harmonic_number

public class HarmonicNumber {
    private static float harmonic(int n) {
        if(n == 1)
            return 1f;
        else
            return harmonic(n - 1) + (1/(float)n);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(harmonic(n));
    }
}
