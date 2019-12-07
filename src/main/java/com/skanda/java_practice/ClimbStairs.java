package com.skanda.java_practice;

class ClimbStairs {
    public static int climbStairsFunc(int n) {
        //return stairHelper(n);
        // return stair(n, 0);

        if(n <= 1)
            return 1;

        int[] arr = new int[n+2];   // we will compute results of steps k, k+1 together
        arr[0] = arr[1] = 1;

        return stairStorage(n, 2, arr);
    }

    // Bottom up with storage, either HashMap, or Array
    // There are only two places from where you can get to current step
    // to reach an arbitrary step k,
    //      1. you can hop 1 length from (k-1)
    //      2. you can hop 2 length from (k-2)
    // We know base cases,
    //      A) 1 way to get to k = 0
    //      B) 1 way to get to k = 1
    //      C) 2 ways to get to k = 2
    private static int stairStorage(int n, int k, int[] arr) {
        // Base case, we reached our destination
        if (n < k)
            return arr[n];
        else {
            arr[k] = arr[k - 1] + arr[k - 2];
            arr[k + 1] = arr[k] + arr[k - 1];

            return stairStorage(n, k + 2, arr);
        }

    }

    public static void main(String[] args) {
        System.out.println(climbStairsFunc(4));
    }
}
