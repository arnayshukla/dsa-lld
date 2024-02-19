package com.practice.java.dsa;;

public class Node {
    // Data stored in the node
    int data;      
    // Pointer to the next
    // node in the list
    Node next;    

    Node random;

    // Constructor with both data
    // and next node as parameters
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
        this.random = null;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }

    Node(int data, Node next, Node random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}
