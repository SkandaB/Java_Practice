package com.skanda.java_practice;

public class SplitArray {

    public boolean splitArray(int[] nums) {
        return splitHelper(nums, 0, 0, 0);
    }


    /**
     * Helper function
     * Recursive manner
     *
     * @param nums    - The original array
     * @param sumArr1 - Running sum of array 1, no new array needed, just the sum of numbers
     * @param sumArr2 - Running sum of array 2, no new array needed, just the sum of numbers
     * @param index   - The current index under processing
     * @return - A boolean value of condition (sum of array 1 == sum of array 2)
     */
    private boolean splitHelper(int nums[], int sumArr1, int sumArr2, int index) {
        // Base case
        // All numbers from original array are accounted for
        // Boolean result of comparing sums of each array
        if (index >= nums.length) {
            return sumArr1 == sumArr2;
        }

        // Recursive case
        // each number can go to arr1 or to arr2
        // Same number can't be part of both
        // A number has to go to one of the arrays
        else {
            return splitHelper(nums, sumArr1 + nums[index], sumArr2, index + 1)
                    ||
                    splitHelper(nums, sumArr1, sumArr2 + nums[index], index + 1);
        }
    }

}

/*

Expected	Run
splitArray([2, 2]) → true	true	OK
splitArray([2, 3]) → false	false	OK
splitArray([5, 2, 3]) → true	true	OK
splitArray([5, 2, 2]) → false	false	OK
splitArray([1, 1, 1, 1, 1, 1]) → true	true	OK
splitArray([1, 1, 1, 1, 1]) → false	false	OK
splitArray([]) → true	true	OK
splitArray([1]) → false	false	OK
splitArray([3, 5]) → false	false	OK
splitArray([5, 3, 2]) → true	true	OK
splitArray([2, 2, 10, 10, 1, 1]) → true	true	OK
splitArray([1, 2, 2, 10, 10, 1, 1]) → false	false	OK
splitArray([1, 2, 3, 10, 10, 1, 1]) → true	true	OK
other tests
OK

 */
