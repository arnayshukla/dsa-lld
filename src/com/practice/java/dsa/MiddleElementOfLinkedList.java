package com.practice.java.dsa;;
/*
 * Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.
 */

public class MiddleElementOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);
        Node midNode = midNode(head);
        System.out.println(midNode.data);
    }

    private static Node midNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
