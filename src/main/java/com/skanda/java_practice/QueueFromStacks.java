package com.skanda.java_practice;

// VM-Ware

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

/**
 * implement a queue, but using only Stack data structue.
 *
 * Stack has push(int i) and pop() => LIFO
 *
 * Queue enqueue(int i) and dequeue() => FIFO
 *
 * 3 , 5 , 6, 2 , 1
 * Stack = > 1, 2, 6 ,5 ,3 (pop all elements at once)
 * 2nd Stack => 3, 5, 6, 2, 1 (pop all elements at once)
 * Queue = > 3, 5, 6, 2, 1
 *
 * Operation        Stack1(bottom to top)      Stack2      Queue (front o back )        oputput
 * Push (3)          (3)                                            (3)                     true
 * Push(5)           (3, 5)                                         (3, 5)                  true
 * Pop()             ()                       (5,3) Pop again       (5)                     3
 * Push(6)           ()                       (5,6)                 (5, 6)                  true
 * Pop()             (6,5)                       ()                      (6)                5
 *
 * StackA <- Push to this when enque
 * StackB <- (tmp = stackb.pop(); if (tmp != null) return else Deque, Pop all from A while pushing to B. Pop B once
 * //Switch A and B.
 *
 * push (a)
 * push (b)
 * pop() a
 * push (c)
 * pop() c
 *
 *
 */
public class QueueFromStacks {

    static Stack<Integer> stackA = new Stack<>();
    static Stack<Integer> stackB = new Stack<>();

    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");

        // Test cases here
        System.out.println("At the start Stack A has: " + stackA);
        System.out.println("At the start Stack B has: " + stackB);
        System.out.println("Elements: 3 , 5 , 6, 2 , 1");
        System.out.println("Enqueue: 3");

        System.out.println(enqueue(3));
        System.out.println(enqueue(5));
        System.out.println(deque());
        System.out.println("At the deque Stack A has: " + stackA);
        System.out.println("At the deque Stack B has: " + stackB);
        System.out.println(enqueue(6));
        System.out.println(deque());
        System.out.println("At the deque Stack A has: " + stackA);
        System.out.println("At the deque Stack B has: " + stackB);
        System.out.println(enqueue(2));
        System.out.println(enqueue(1));
        System.out.println(deque());
        System.out.println("At the deque Stack A has: " + stackA);
        System.out.println("At the deque Stack B has: " + stackB);
    }
    // Enqueue
    private static boolean enqueue(Integer num) {
        stackA.push(num);
        return true;
    } // O(1)

    // Deque
    private static Integer deque() {
        if(stackB.isEmpty())  {
            while(!stackA.isEmpty()) {      // 1 per element from A (N)
                stackB.push(stackA.pop()); // O(1 + 1) FOR PUSH AND POP
            } // O(N + N) => O(2N) => O(N)
        }
        return stackB.pop();
    }

}