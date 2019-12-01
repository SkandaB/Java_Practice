package com.skanda.java_practice;

public class TowersOfHanoi {

    private static void moves(int discs, String source, String dest, String spare) {
        // base case, when no more discs, do nothing
        if (discs == 0) {
            System.out.println("Moved disc " + "disc " + discs + " from " + source + " to " + dest);
            return;
        } else {

            // In order for disc N to move to destination, all lesser (above) discs need to be moved to spare
            moves(discs - 1, source, spare, dest);

            // Move current N numbered disc to it's destination. Just 1 disc
            System.out.println("Moved disc " + "disc " + discs + " from " + source + " to " + dest);

            // move all lesser discs on top of the just moved disk. i.e. from spare to destination
            moves(discs - 1, spare, dest, source);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        moves(n, "A", "B", "C");
    }

}
