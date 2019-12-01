package com.skanda.java_practice;

public class Exponentiation {

    private static long power(long base, long raised) {
        if (raised == 0)
            return 1;
        else
            return base * power(base, raised - 1);
    }

    /*
        If n is even, then xn = (x2)n/2
        If n is odd, then xn = x * (x2)(n-1)/2
    */

    private static long fastPower(long base, long raised) {
        if (raised == 0)
            return 1L;
        else if (raised % 2 == 0) {
            long returned = fastPower((base * base), raised / 2);
            return returned;
        } else {
            long returned = fastPower(base * base, (raised - 1) / 2);
            long new_val = base * returned;
            return new_val;
        }
    }


    private static long simplePower(long base, int raised) {
        // base case
        if( raised == 0)
            return 1L;
        // recursive case
        else{
            long partial    = simplePower(base, raised/2); // (Floor of raised/2 => integer in Java)
            long result     = partial * partial;

            if(raised % 2 == 1)     // when raised is odd, we need one more multiplication of base
                result*= base;

            return  result;
        }
    }


    public String parenBit(String str) {

        // Base Case
        // Check for "(" at the start, and ")" at the end
        // If so, EVERYTHING inside this is required, so return it
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
            return str;

        // Recursive case (it calls itself, duh!)
        // If start is "(", but end is NOT ")"
        // then chop off last character, and repeat
        if (str.charAt(0) == '(')
            return parenBit(str.substring(0, str.length() - 1));

        // Recursive case (it calls itself, duh!)
        // If end is ")", but start is NOT "("
        // then chop off first character, and repeat
        if (str.charAt(str.length() - 1) == ')')
            return parenBit(str.substring(1));

        // Recursive case (it calls itself, duh!)
        // If start is NOT "(", and end is NOT ")"
        // then chop off both, first and last character, and repeat
        return parenBit(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        long base = Long.parseLong(args[0]);
        long exp = Long.parseLong(args[1]);

        System.out.println(base + " raised to " + exp + " is: " + power(base, exp));
        System.out.println(base + " raised to " + exp + " is: " + fastPower(base, exp));
        System.out.println(base + " raised to " + exp + " is: " + simplePower(base, (int)exp));

    }
}


