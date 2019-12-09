package com.skanda.java_practice;

// Fractal pattern
public class EnglishRuler {

    public static void main(String[] args) {
        int rulerLength = Integer.parseInt(args[0]);
        int tickLength = Integer.parseInt(args[1]);

        // Draw 0th label
        printTicks(tickLength, 0);

        // Iterate to draw all major length with label
        for(int i = 1; i <= rulerLength; i++) {
            printRuler(tickLength - 1);     // Draw central intervals without labels
            printTicks(tickLength, i);             // Print major length with label
        }

//        printRuler(tickLength, 0, rulerLength, tickLength);
    }

    private static void printRuler(int tickLen) {

        if (tickLen == 0) {
            return;
        } else {
            // recursive call to draw top interval
            printRuler(tickLen - 1);

            // Central line between major interval, no label
            printTicks(tickLen, -1);

            // recursive call to draw bottom interval
            printRuler(tickLen - 1);

        }
    }

    private static void printTicks(int len, int labelLength) {
        for (int i = 0; i < len; i++)
            System.out.print("-");
        if(labelLength >= 0)
            System.out.print("\t" + labelLength);
        System.out.println();

    }
}
