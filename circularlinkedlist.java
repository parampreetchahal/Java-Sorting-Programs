// Node class representing a single node in the circular linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// CircularLinkedList class representing the entire circular linked list
class CircularLinkedList {
    Node head;

    // Method to add a new node at the end of the circular linked list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to print the circular linked list
    public void printList() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    // Method to delete a node from the circular linked list
    public void deleteNode(int data) {
        if (head == null) return;

        if (head.data == data) {
            if (head.next == head) {
                head = null;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Method to find the middle element of the circular linked list
    public int findMiddle() {
        Node slow = head;
        Node fast = head;
        if (head != null) {
            while (fast.next != head && fast.next.next != head) {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow.data;
    }

    // Method to detect a cycle in the circular linked list
    public boolean detectCycle() {
        // A circular linked list always has a cycle
        return true;
    }

    // Method to reverse the circular linked list
    public void reverseList() {
        Node prev = null;
        Node current = head;
        Node next = null;
        if (head != null) {
            do {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            } while (current != head);
            head = prev;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        System.out.println("Circular Linked List:");
        list.printList();

        System.out.println("Middle Element: " + list.findMiddle());

        System.out.println("Cycle Detection: " + list.detectCycle());

        list.reverseList();

        System.out.println("Reversed Circular Linked List:");
        list.printList();

        list.deleteNode(3);

        System.out.println("Circular Linked List after deletion:");
        list.printList();
    }
}
