package com.skanda.java_practice;

import java.util.*;

/**
 * An n-bit Gray code is a list of the 2n different n-bit binary numbers such that each entry in the list differs in precisely one bit from its predecessor.
 * The n bit binary reflected Gray code is defined recursively as follows:
 * •   the n−1 bit code, with 0 prepended to each word, followed by
 * •   the n−1 bit code in reverse order, with 1 prepended to each word.
 */
public class GrayCode {


    public static void main(String[] args) {
        List<String> grayCodeList = buildCode(4);
        System.out.println(grayCodeList.toString());

        List<Integer> grayCodeSeq = grayCodeToInt(grayCodeList);
        System.out.println(grayCodeSeq);
    }

    /**
     * A recursive function to compute the n-digit binary gray code list
     *
     * @param digit - Digits in the binary sequence
     * @return - A list of binary numbers in String format representing the Gray code
     */
    private static List<String> buildCode(int digit) {
        List<String> prefix = new ArrayList<>();

        // base case
        if (digit == 0) {
            prefix.add("0");
        } else if (digit == 1) {
            prefix.add("0");
            prefix.add("1");
        } else {    // recursive case
            // get list of codes for n-1 bits
            List<String> curr = buildCode(digit - 1);

            // the n−1 bit code, with 0 prepended to each word, add to the list
            for (int i = 0; i < curr.size(); i++)
                prefix.add("0" + curr.get(i));

            // the n−1 bit code in reverse order, with 1 prepended to each word, add to the list
            for (int j = curr.size() - 1; j >= 0; j--)
                prefix.add("1" + curr.get(j));
        }
        return prefix;
    }

    /**
     * Take each string in the list in order, and append a decimal value of the string treated as binary
     *
     * @param grayCodeList - List of string, in order. Gray code
     * @return - List of Integer, with corresponding decimal value of each string.
     */
    private static List<Integer> grayCodeToInt(List<String> grayCodeList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < grayCodeList.size(); i++) {
            result.add(binaryStringToInteger(grayCodeList.get(i)));
        }
        return result;
    }

    /**
     * Binary to Integer conversion
     *
     * @param binary - Takes a string which represents a binary number
     * @return - An Integer object which is decimal value of the binary number
     */
    private static Integer binaryStringToInteger(String binary) {
        int num = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                num += Math.pow(2, (binary.length() - 1) - i);
            }
        }
        return num;
    }
}
