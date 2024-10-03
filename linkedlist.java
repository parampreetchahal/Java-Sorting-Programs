// Node class representing a single node in the linked list
class Node {
    // Data stored in the node
    int data;
    // Reference to the next node in the linked list
    Node next;

    // Constructor to initialize the node with data
    public Node(int data) {
        this.data = data;
        // Initialize the next reference to null
        this.next = null;
    }
}

// LinkedList class representing the entire linked list
class LinkedList {
    // Head of the linked list
    Node head;

    // Method to add a new node at the end of the linked list
    public void addNode(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the linked list is empty, set the head to the new node
        if (head == null) {
            head = newNode;
        } else {
            // Traverse the linked list to find the last node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            // Set the next reference of the last node to the new node
            temp.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        // Start from the head of the linked list
        Node temp = head;
        // Traverse the linked list and print the data of each node
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        // Print a newline character
        System.out.println();
    }

    // Method to delete a node from the linked list
    public void deleteNode(int data) {
        // If the linked list is empty, return
        if (head == null) return;

        // If the head node is the node to be deleted, update the head
        if (head.data == data) {
            head = head.next;
            return;
        }

        // Traverse the linked list to find the node to be deleted
        Node temp = head;
        while (temp.next != null) {
            // If the next node is the node to be deleted, update the next reference
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Method to find the middle element of the linked list
    public int findMiddle() {
        // Initialize two pointers, slow and fast, to the head of the linked list
        Node slow = head;
        Node fast = head;
        // If the linked list is not empty
        if (head != null) {
            // Traverse the linked list with the fast pointer moving twice as fast as the slow pointer
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        // Return the data of the middle node
        return slow.data;
    }

    // Method to detect a cycle in the linked list
    public boolean detectCycle() {
        // Initialize two pointers, slow and fast, to the head of the linked list
        Node slow = head;
        Node fast = head;
        // If the linked list is not empty
        if (head != null) {
            // Traverse the linked list with the fast pointer moving twice as fast as the slow pointer
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                // If the slow and fast pointers meet, there is a cycle in the linked list
                if (slow == fast) return true;
            }
        }
        // If the slow and fast pointers do not meet, there is no cycle in the linked list
        return false;
    }

    // Method to reverse the linked list
    public void reverseList() {
        // Initialize three pointers, prev, current, and next, to null
        Node prev = null;
        Node current = head;
        Node next = null;
        // Traverse the linked list
        while (current != null) {
            // Store the next node in the next pointer
            next = current.next;
            // Reverse the next reference of the current node
            current.next = prev;
            // Move the prev and current pointers one step forward
            prev = current;
            current = next;
        }
        // Update the head of the linked list
        head = prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new linked list
        LinkedList list = new LinkedList();
        // Add nodes to the linked list
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        // Print the linked list
        System
