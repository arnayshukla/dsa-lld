package com.practice.java.dsa;;
/*
 * Given two singly linked lists that are sorted in increasing order of node values, merge two sorted linked lists and return them as a sorted list. 
 * The list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(3);
        head1.next = new Node(7);
        head1.next.next = new Node(10);
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = new Node(10);
        Node result = mergeLinkedLists(head1, head2);
        printLinkedList(result);
    }

    private static Node mergeLinkedLists(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        if (head1.data > head2.data) {
            Node temp = head2;
            head2 = head1;
            head1 = temp;
        }
        Node result = head1;
        while(head1 != null && head2 != null) {
            Node temp = null;
            while (head1 != null && head1.data <= head2.data) {
                temp = head1;
                head1 = head1.next;
            }
            temp.next = head2;
            Node temp2 = head2;
            head2 = head1;
            head1 = temp2;
        }
        return result;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
