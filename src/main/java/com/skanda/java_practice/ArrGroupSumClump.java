package com.skanda.java_practice;

/*
Given an array of ints, is it possible to choose a group of some of the ints,
such that the group sums to the given target, with this additional constraint:
    if there are numbers in the array that are adjacent and the identical value,
        they must either all be chosen, or none of them chosen.

For example, with the array {1, 2, 2, 2, 5, 2},
either all three 2's in the middle must be chosen or not,
all as a group.
(one loop can be used to find the extent of the identical values).


groupSumClump(0, [2, 4, 8], 10) → true
groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
groupSumClump(0, [2, 4, 4, 8], 14) → false
 */

public class ArrGroupSumClump {
    public boolean groupSumClump(int start, int[] nums, int target) {
        // Base case
        // Reached the end of the array
        if (start >= nums.length)
            return (0 == target);

            // Recursive case
            // Find if there is a group of adjacent same value numbers
            // Consider this group as one
            // Make 2 recursive calls
            // 1. By including the group (or a single digit)
            // 2. By excluding the group
        else {
            int groupSum = nums[start];         // Single value is a group itself
            int startRunner = start;            // Variable that will determine the group
            while (startRunner + 1 < nums.length &&  // Boundary check
                    nums[startRunner + 1] == nums[start]) {   // next value is same
                groupSum += nums[startRunner + 1];       // Add to groupSum
                startRunner += 1;                        // Increment start Runner
            }

            return groupSumClump(startRunner + 1, nums, target - groupSum)
                    ||
                    groupSumClump(startRunner + 1, nums, target);
        }
    }

}
