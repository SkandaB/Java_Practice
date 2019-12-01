package com.skanda.java_practice;

// Text Now
// Create a function that takes a non-empty string of characters as input and returns the character that occurs most frequently in the string.

import java.util.*;

public class CharFrequency {
    public static void main(String[] args) {
        String inp = "This is a test call for the new written function in Java 7 for counting max occuring character";

        System.out.println("From main: " + mostFreqOccur(inp));
    }

    public static Character mostFreqOccur(String input) {

        Map<Character, Integer> recordCounts = new HashMap<>();
        for (Character curr : input.toCharArray()) {
            if (curr.equals(' ')) continue; // can be moved outside the loop
            if (recordCounts.containsKey(curr)) {
                recordCounts.put(curr, (recordCounts.get(curr) + 1));
            } else {
                recordCounts.put(curr, 1);
            }
        }
        System.out.println(recordCounts);
        int max = 0;
        Character key = null;
        for (Map.Entry<Character, Integer> curr : recordCounts.entrySet()) {
            if (curr.getValue() > max) {
                max = curr.getValue();
                key = curr.getKey();
            }
        }
        System.out.println("Within the function, Max occuring character: " + key);
        return key;
    }
}