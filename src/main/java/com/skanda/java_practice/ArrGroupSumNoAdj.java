package com.skanda.java_practice;

/*

Given an array of ints, is it possible to choose a group of some of the ints,
such that the group sums to the given target with this additional constraint:
    If a value in the array is chosen to be in the group,
    the value immediately following it in the array must not be chosen.
(No loops needed.)


groupNoAdj(0, [2, 5, 10, 4], 12) → true
groupNoAdj(0, [2, 5, 10, 4], 14) → false
groupNoAdj(0, [2, 5, 10, 4], 7) → false
 */

public class ArrGroupSumNoAdj {

    public static boolean groupNoAdj(int start, int[] nums, int target) {
        // Base case
        // Reached end of array, return true if target is achieved
        if (start >= nums.length)
            return (0 == target);

            // Recursive case
            // There is a choice.
            // 1. If you choose current element (start), i.e. by subtracting,
            //    then, you can't choose next. That's why jump over adjacent (start +2)
            //
            // 2. If you didn't choose current, i.e. didn't subtract
            //    then, you can call the recursive function on the adjacent element
            //
            // If adjacent element gets chosen, then it will skip over it's adjacent
        else {
            return (groupNoAdj(start + 2, nums, target - nums[start])
                    ||
                    groupNoAdj(start + 1, nums, target)
            );
        }
    }
}
