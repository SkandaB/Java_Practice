package com.skanda.java_practice;

import java.util.*;
// Karat - Wayfair

/*        ​
 Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

 For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
 1   2    4
  \ /   / | \
   3   5  8  9
    \ / \     \
     6   7    11
        ​
 Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.
 Sample input/output (pseudodata):
        ​
 parentChildPairs = [
     (1, 3), (2, 3), (3, 6), (5, 6),
     (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
 ]
        ​
 Output may be in any order:
        ​
 findNodesWithZeroAndOneParents(parentChildPairs) => [
   [1, 2, 4],       // Individuals with zero parents
   [5, 7, 8, 9, 11] // Individuals with exactly one parent
 ]
        ​
 n: number of pairs in the input        ​
*/

public class ZeroOneParent {
    public static void main(String[] argv) {
        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };
        List<List<Integer>> output = findNodesWithZeroAndOneParents(parentChildPairs);
        System.out.println(output.get(0));
    }

    public static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < parentChildPairs.length; i++) {
            int parent = parentChildPairs[i][0];
            int child = parentChildPairs[i][1];
            if (map.containsKey(child)) {
                List<Integer> current = map.get(child);
                current.add(parent);
            } else {
                List<Integer> current = new ArrayList<Integer>();
                current.add(parent);
                map.put(child, current);
            }
        }
        return result;
    }
}
