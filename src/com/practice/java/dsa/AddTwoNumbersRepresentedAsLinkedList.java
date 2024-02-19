package com.practice.java.dsa;

/*
 * Given the heads of two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 */
public class AddTwoNumbersRepresentedAsLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);
        Node head = addLinkedList(head1, head2);
        printLinkedList(head);
    }

    private static Node addLinkedList(Node head1, Node head2) {
        int carry = 0;
        Node head = new Node(0);
        Node temp = head;
        while (head1 != null || head2 != null || carry > 0) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
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
