package com.practice.java.dsa;

/*
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list instead, 
 * you will be given access to the node to be deleted directly. 
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 */
public class DeleteGivenNodeFromLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
//        head.next.next.next.next = new Node(10);
        System.out.println("Given Linked List: ");
        printLinkedList(head);
        Node t = getNode(head,2);
        //delete node
        deleteNode(t);
        //list after deletion operation
        System.out.println("Linked List after deletion: ");
        printLinkedList(head);
    }

    private static void deleteNode(Node t) {
        t.data = t.next.data;
        t.next = t.next.next;
    }

    static Node getNode(Node head,int val) {
        if(head==null)
        return null;
        while(head.data != val) head = head.next;
        
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
