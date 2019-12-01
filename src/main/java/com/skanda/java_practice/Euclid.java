package com.skanda.java_practice;

public class Euclid {

    public static int gcd(int p, int q) {
        if(q == 0)
            return p;
        else
            return gcd(q , p % q);
    }

    public static int main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int r =  gcd( p, q);

        System.out.println("GCD of " + p + " and " + q + " is: " +r);

        return r;
    }
}
