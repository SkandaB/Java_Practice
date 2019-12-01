package com.skanda.java_practice;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.




 removeInstances("absdefge", ["ab", "abs", "fg", "ee", "xyz"]) → sdee

 absdefge   (ab)    -> sdefge
 sdefge     (abs)   -> sdefge
 sdefge     (fg)    -> sdee
 sdee       (ee)    -> sdee
 sdee      (xyz)    -> sdee


 N -> Length of main input string
 M -> MAx length of substring
 K -> length of substring list
 O(N.M.K) run-time
 */

class ChopSubString_Livongoimport {
    public static void main(String[] args) {
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java " + Runtime.version().feature());

//     for (String string : strings) {
//       System.out.println(string);

        String input = "absdefge";
        ArrayList<String> blkListSubStrings = new ArrayList<String>();
        blkListSubStrings.add("ab");
        blkListSubStrings.add("abs");
        blkListSubStrings.add("fg");
        blkListSubStrings.add("ee");
        blkListSubStrings.add("xyz");

        System.out.println(chopOffSubs(input, blkListSubStrings));
    }

    private static String chopOffSubs(String input, List<String> blckList) {
        StringBuilder result = new StringBuilder(input);
        int leftPt = -1;
        int rgtPt = input.length();

        for (String sub : blckList) {
            leftPt = 0;
            rgtPt = result.length() - 1;
            while (input.contains(sub) && result.toString().contains(sub)) {
                int leftEnd = result.indexOf(sub, 0);
                int rgtStart = leftEnd + sub.length() - 1;
                System.out.println("Chopping off: " + sub);
                if (leftEnd == 0) {
                    result = new StringBuilder(result.toString().substring(rgtStart + 1));
                    System.out.println("Result :" + result.toString());
                } else if (rgtStart == result.length() - 1) {
                    result = new StringBuilder(result.toString().substring(0, leftEnd));
                    System.out.println("Result :" + result.toString());
                } else {
                    result = new StringBuilder(result.toString().substring(0, leftEnd).concat(result.toString().substring(rgtStart + 1)));
                    System.out.println("Result :" + result.toString());
                }
            }
        }

        return result.toString();
    }

}