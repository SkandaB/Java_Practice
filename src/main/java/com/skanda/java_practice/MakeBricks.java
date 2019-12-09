package com.skanda.java_practice;

public class MakeBricks {

    public static boolean makeBricks(int small, int big, int goal) {
        return makeHelper(small, big, goal);
    }

    public static boolean makeHelper(int small, int big, int goal) {
        // Base case
        // Goal reached
        if (0 == goal)
            return true;

        // Bricks exhausted
        if (small <= 0 && big <= 0)
            return false;

            // Recursive case
            // Consider all big bricks first
            // Either all big bricks exhausted, or goal < big brink length
            // Check if we have enough small bricks to reach our goal
        else {
            if (big > 0 && goal >= 5)
                return makeHelper(small, big - 1, goal - 5);

            if (small >= goal)
                return makeHelper(small - goal, big, small - goal);

            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(makeBricks(1000000, 1000, 1000100));
    }

}
