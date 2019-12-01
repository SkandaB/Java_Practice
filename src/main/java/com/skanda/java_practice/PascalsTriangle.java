package com.skanda.java_practice;

import java.util.*;

class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();

        if (numRows < 1)
            return result;

        fillRow(result, numRows);
        return result;
    }

    private static void fillRow(List<List<Integer>> triangle, int row) {

        // base case
        // first value will be 1 of top row and top column
        if (row == 1) {
            triangle.add(Arrays.asList(1));
            return;
        } else {
            fillRow(triangle, row - 1);                         // recursive call
            List<Integer> prevRow = triangle.get(row - 2);      // fetch previous row
            List<Integer> currRow = new LinkedList<Integer>();  // construct new current row

            // fill current Row
            for (int i = 0; i <= prevRow.size(); i++) {
                if (i == 0 || i == prevRow.size())
                    currRow.add(1);     // 0th and last index always 1
                else                    // middle cell = sum of previous + current cell from prev Row
                    currRow.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            triangle.add(currRow);
            return;
        }
    }
}