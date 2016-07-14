package com.ratiocinative.solutions.linkedlist;

public class MergeSortLinkList {

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        } else {
            ListNode mid = midNode(head);
            ListNode left = sort(head);
            ListNode right = sort(mid);
            return merge(left, right);
        }
    }

    ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        return node;
    }

    ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode h1 = head1;
        ListNode h2 = head2;
        ListNode curr = null;

        while (h1 != null && h2 != null) {
            ListNode smallerNode = null;
            if (h1.val <= h2.val) {
                smallerNode = h1;
                h1 = h1.next;
            } else {
                smallerNode = h2;
                h2 = h2.next;
            }

            if (curr != null) {
                curr.next = smallerNode;
                curr = smallerNode;
            } else {
                curr = smallerNode;
            }
        }

        while (h1 != null) {
            curr.next = h1;
            curr = h1;
            h1 = h1.next;
        }

        while (h2 != null) {
            curr.next = h2;
            curr = h2;
            h2 = h2.next;
        }

        return curr;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(12);
        linkList.add(10);
        linkList.add(8);
        linkList.add(1);
        linkList.add(6);
        linkList.add(2);
        linkList.add(3);
        System.out.println(linkList.toString());
        MergeSortLinkList sortLink = new MergeSortLinkList();
        ListNode sortedHead = sortLink.sort(linkList.head);
        System.out.println(linkList.print(sortedHead));
    }
}
