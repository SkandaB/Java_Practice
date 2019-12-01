package com.skanda.java_practice;

// Fractal pattern
public class EnglishRuler {

    public static void main(String[] args) {
        int tickLength = 5;
        int rulerLength = 3;

        printRuler(tickLength, 0, rulerLength, tickLength);
    }

    private static void printRuler(int tickLen, int currRul, int rulerLen, int maxTickLen) {

        if (tickLen == 0) {
            return;
        } else {
            // print descending
            printRuler(tickLen - 1, currRul, rulerLen, maxTickLen);

            printTicks(tickLen, tickLen);

            // print ascending
            printRuler(tickLen - 1, currRul, rulerLen, maxTickLen);

        }
    }

    private static void printTicks(int len, int labelLength) {
        for (int i = 0; i < len; i++)
            System.out.print("-");
        if(labelLength > 0)
            System.out.print("\t" + labelLength);
        System.out.println();

    }
}
