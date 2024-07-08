package DSAQuestions;       // Defining the package for the class files

// Class to represent a node in the linked list
class Node {
    int data;       // Data part of the node
    Node next;      // Pointer to the next node

    // Constructor to initialize the node with data and set the next pointer to null
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to represent the linked list
class LinkedList {
    Node head;      // Head of the linked list

    // Method to add a new node with given data to the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data);      // Creating a new node
        if (head == null) {         // If the list is empty, set the new node as the head
            head = newNode;
        } else {        // Otherwise, traverse to the end of the list and add the new node
            Node current = head;
            while (current.next != null) {      // Traverse until the last node
                current = current.next;
            }
            current.next = newNode;         // Add the new node at the end
        }
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;        // Start from the head node
        while (current != null) {       // Traverse the list until the end
            System.out.print(current.data + " -> ");        // Print the data of each node
            current = current.next;         // Move to the next node
        }
        System.out.println("null");         // Indicate the end of the list
    }

    // Method to reverse the linked list
    public void reverse() {
        Node prev = null;       // Initialize previous node as null
        Node current = head;        // Start from the head node
        Node next = null;       // Initialize next node as null

        while (current != null) {       // Traverse the list
            next = current.next;        // Store the next node
            current.next = prev;        // Reverse the link
            prev = current;         // Move previous to the current node
            current = next;         // Move to the next node
        }
        head = prev;        // Set the head to the last node
    }
}

// Main class to test the linked list and reverse functionality
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();         // Create a new linked list
        list.add(1);        // Add elements to the list
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("The original list is: ");
        list.display();         // Display the original list

        list.reverse();         // Reverse the linked list
        System.out.print("The reverse list is: ");
        list.display();         // Display the reversed list
    }
}
