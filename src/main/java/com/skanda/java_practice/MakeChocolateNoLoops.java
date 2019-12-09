package com.skanda.java_practice;

public class MakeChocolateNoLoops {
    public static int makeChocolate(int small, int big, int goal) {
        // Total check
        if(small + big * 5 < goal)
            return -1;

        // Calculate how many big bars to use
        // Always less than or equal to total available
        int bigUsed = Math.min(goal / 5, big);

        // Use max possible number of big bags
        // Calculate new goal
        goal-= bigUsed * 5;

        // If we have enough small bars to reach goal
        // return goal (exactly small number of bars required)
        if(small >= goal)
            return goal;
        else            // can't be done
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(makeChocolate(4, 1, 9));
    }
}

/*
makeChocolate(4, 1, 9) → 4	4	OK
makeChocolate(4, 1, 10) → -1	-1	OK
makeChocolate(4, 1, 7) → 2	2	OK
makeChocolate(6, 2, 7) → 2	2	OK
makeChocolate(4, 1, 5) → 0	0	OK
makeChocolate(4, 1, 4) → 4	4	OK
makeChocolate(5, 4, 9) → 4	4	OK
makeChocolate(9, 3, 18) → 3	3	OK
makeChocolate(3, 1, 9) → -1	-1	OK
makeChocolate(1, 2, 7) → -1	-1	OK
makeChocolate(1, 2, 6) → 1	1	OK
makeChocolate(1, 2, 5) → 0	0	OK
makeChocolate(6, 1, 10) → 5	5	OK
makeChocolate(6, 1, 11) → 6	6	OK
makeChocolate(6, 1, 12) → -1	-1	OK
makeChocolate(6, 1, 13) → -1	-1	OK
makeChocolate(6, 2, 10) → 0	0	OK
makeChocolate(6, 2, 11) → 1	1	OK
makeChocolate(6, 2, 12) → 2	2	OK
makeChocolate(60, 100, 550) → 50	50	OK
makeChocolate(1000, 1000000, 5000006) → 6	6	OK
makeChocolate(7, 1, 12) → 7	7	OK
makeChocolate(7, 1, 13) → -1	-1	OK
makeChocolate(7, 2, 13) → 3	3	OK
 */