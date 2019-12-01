package com.skanda.java_practice;

import java.util.Arrays;

class ReverseString {

    public static void main(String[] args) {
        char[] s = args[0].toCharArray();
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        if(s == null || s.length <= 1)
            return;
        reverseHelper(s, 0);
    }

    // Recursive function
    // Works on an array of chars
    private static void reverseHelper(char[] s, int index) {
        // Base case
        // Reached end of the array
        if(index == s.length/2)
            return;

            // Recursive case
            // Take first character and swap with last character
        else {
            char tmp = s[index];
            s[index] = s[s.length - 1 - index];
            s[s.length - 1 - index] = tmp;
//            System.out.println(Arrays.toString(s));
            reverseHelper(s, index+1);
        }
    }
}