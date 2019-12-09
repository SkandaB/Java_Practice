package com.skanda.java_practice;

public class ArrGroupSumMul5 {
    public static boolean groupSum5(int start, int[] nums, int target) {
        // Base case
        // Reached end of the array
        if (start >= nums.length)
            return (0 == target);

        else {
            int new_start = start;
            if (nums[start] % 5 == 0) {       // Must include multiple of 5
                if (start + 1 < nums.length) { // Check for boundary condition
                    if (1 == nums[start + 1])      // Skip next index if value at is 1
                        new_start = start + 1;
                }
                return groupSum5(new_start + 1 , nums, target - nums[start]);
            } else {    // May or may not include current number
                return groupSum5(start + 1, nums, target - nums[start])
                        ||
                        groupSum5(start + 1, nums, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(groupSum5(0, new int[] {2, 5, 4, 10}, 12));
    }

}


