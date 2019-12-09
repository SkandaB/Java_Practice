package com.skanda.java_practice;

public class MakeBricksNoLoops {
    public static boolean makeBricks(int small, int big, int goal) {
        // Total less than goal
        if (small + big * 5 < goal)
            return false;

        // Not enough small bricks to make it to the end
        if (goal % 5 > small)
            return false;

        // Calculate the number of big bricks to use
        // This should be within the available big bricks
        int bigUsed = Math.min(goal / 5, big);

        // Use max number of big bricks
        // But should be less than or equal to goal
        // New goal after using max Big bricks
        goal -= bigUsed * 100;

        // Check if there are enough small bricks to reach the goal
        if (small >= goal)
            return true;

            // Not enough small bricks to reach goal
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(makeBricks(3, 2, 8));
        System.out.println(makeBricks(3, 2, 9));
    }

}


/*
makeBricks(3, 1, 8) → true	true	OK
makeBricks(3, 1, 9) → false	false	OK
makeBricks(3, 2, 10) → true	true	OK
makeBricks(3, 2, 8) → true	true	OK
makeBricks(3, 2, 9) → false	false	OK
makeBricks(6, 1, 11) → true	true	OK
makeBricks(6, 0, 11) → false	false	OK
makeBricks(1, 4, 11) → true	true	OK
makeBricks(0, 3, 10) → true	true	OK
makeBricks(1, 4, 12) → false	false	OK
makeBricks(3, 1, 7) → true	true	OK
makeBricks(1, 1, 7) → false	false	OK
makeBricks(2, 1, 7) → true	true	OK
makeBricks(7, 1, 11) → true	true	OK
makeBricks(7, 1, 8) → true	true	OK
makeBricks(7, 1, 13) → false	false	OK
makeBricks(43, 1, 46) → true	true	OK
makeBricks(40, 1, 46) → false	false	OK
makeBricks(40, 2, 47) → true	true	OK
makeBricks(40, 2, 50) → true	true	OK
makeBricks(40, 2, 52) → false	false	OK
makeBricks(22, 2, 33) → false	false	OK
makeBricks(0, 2, 10) → true	true	OK
makeBricks(1000000, 1000, 1000100) → true	true	OK
makeBricks(2, 1000000, 100003) → false	false	OK
makeBricks(20, 0, 19) → true	true	OK
makeBricks(20, 0, 21) → false	false	OK
makeBricks(20, 4, 51) → false	false	OK
makeBricks(20, 4, 39) → true	true	OK
 */