package com.practice.java.dsa;

;

/*
 * Given a linked list and an integer N, the task is to delete the Nth node from the end of the linked list and print the updated linked list.
 */
public class RemoveNthNodeFromTheEndOfLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 4;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);

        head = deleteNthNodefromEnd(head, N);
        printLinkedList(head);
    }

    private static Node deleteNthNodefromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
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
