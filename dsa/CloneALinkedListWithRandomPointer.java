package com.practice.java.dsa;

import java.util.HashMap;

/*
 * Given a Linked list that has two pointers in each node and one of which points to the next node and the other points to any random node. 
 * Write a program to clone the LinkedList.
 */
public class CloneALinkedListWithRandomPointer {
    public static void main(String[] args) {
        Node head = null;
        
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;
        
        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;
        
        System.out.println("Original list:(current node:node pointed by next pointer, node pointed by random pointer)");
        printList(head);
        
        System.out.println("Copy list:(current node:node pointed by next pointer,node pointed by random pointer)");
//        Node newHead = copyRandomList(head);
        Node newHead = copyRandomListUsingHashMap(head);
        printList(newHead);
    }

    private static Node copyRandomList(Node head) {
        Node temp = head;
        //create copies and link copied nodes to the next of the original nodes
        while (temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        //copy random nodes
        Node itr = head;
        while (itr != null) {
            if (itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }
        //Separte original and copied list
        Node dummy = new Node(0);
        itr = head;
        temp = dummy;
        Node fast;
        while (itr != null) {
            fast = itr.next.next;
            temp.next = itr.next;
            itr.next = fast;
            temp = temp.next;
            itr = fast;
        }
        return dummy.next;
    }

    private static Node copyRandomListUsingHashMap(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.data);
            hashMap.put(temp, newNode);
            temp = temp.next;
        }
        Node t = head;
        while (t != null) {
            Node node = hashMap.get(t);
            node.next = t.next != null ? hashMap.get(t.next) : null;
            node.random = t.random != null ? hashMap.get(t.random) : null;
            t = t.next;
        }
        return hashMap.get(head);
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data+":");
            if(head.next != null)
            System.out.print(head.next.data);
            else
            System.out.print("NULL");
            if(head.random != null)
            System.out.print(","+head.random.data);
            else
            System.out.print(",NULL");
            System.out.println();
            head = head.next;
        }
    }
}
