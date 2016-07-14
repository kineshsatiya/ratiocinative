package com.ratiocinative.solutions.linkedlist;

import java.util.PriorityQueue;

/**
 * Merge k linked-lists
 */
public class MergeKList {

    /**
     * merge two sorted list
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = null;
        ListNode curr = dummyHead;

        while (l2 != null && l1 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        return dummyHead.next;
    }

    /**
     * merge k sorted lists
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (n1, n2) -> Integer.compare(n1.val, n2.val));

        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = null;

        ListNode curr = dummyHead;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        return dummyHead.next;
    }

}
