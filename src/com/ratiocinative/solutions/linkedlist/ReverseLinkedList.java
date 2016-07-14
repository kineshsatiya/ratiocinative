package com.ratiocinative.solutions.linkedlist;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode reversed = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }
        return reversed;
    }

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     *
     * @param l
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode l, int m, int n) {
        return null;
    }
}
