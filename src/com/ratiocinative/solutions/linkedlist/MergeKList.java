package com.ratiocinative.solutions.linkedlist;

import java.util.PriorityQueue;

/**
 * Merge k linked-lists
 */
public class MergeKList {

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
