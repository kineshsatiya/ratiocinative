package com.ratiocinative.solutions.linkedlist;

public class LinkList {

    protected ListNode head;

    public LinkList() {
        this.head = null;
    }

    // LIFO order
    public void add(int v) {
        if (head == null) {
            head = new ListNode(v);
            head.next = null;
        } else {
            ListNode newNode = new ListNode(v);
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public String toString() {
        return print(this.head);
    }

    protected String print(ListNode h) {
        StringBuilder builder = new StringBuilder();
        ListNode curr = h;
        while (curr != null) {
            builder.append(curr.toString() + "->");
            curr = curr.next;
        }
        builder.append("null");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(4);
        linkList.add(3);
        linkList.add(7);
        linkList.add(8);
        linkList.add(1);
        System.out.println(linkList.toString());
    }
}
