package com.skanda.java_practice;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class ReverseLinkedList {
    private static ListNode reverseList(ListNode head) {

//        ListNode newHead = reverseHelper(head);
        ListNode itrHead = reverseItrtve(head);

        ListNode tmp = itrHead;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }

        return itrHead;
    }

    private static ListNode reverseHelper(ListNode head) {

        // Base case
        if (head == null || head.next == null)
            return head;

            // Recursive case
            // grab next->next node into tmp
            // next node should point to current
            // recurse on tmp
        else {
            ListNode newHead = reverseHelper(head.next);
            newHead.next = head;
            head.next = null;

            return newHead;
        }
    }

    // Iterative
    private static ListNode reverseItrtve(ListNode head) {

        ListNode prevHead = null;           // Placeholder for prevHead

        // Basically advancing the pointers to next position
        while(head != null) {
            ListNode next = head.next;      // Capture next Node

            head.next   = prevHead;         // Current head should point to prevHead instead of next
            prevHead    = head;             // prevHead is now curr head
            head        = next;             // curr head is now next head
        }

        return prevHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        head = reverseList(head);
    }
}