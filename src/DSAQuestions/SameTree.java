package DSAQuestions;

import java.util.Scanner;

// Node class representing each node in the binary tree
class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    // Constructor to initialize the node with data
    public BinaryTreeNode(int data) {
        this.data = data;
        left = right = null;        // Initially, the left and right children are null
    }
}

public class SameTree {

    // Method to insert nodes into the binary tree
    public static BinaryTreeNode insertNode(Scanner sc) {
        System.out.print("Enter node data (-1 to indicate no node): ");
        int data = sc.nextInt();        // Read data for the node
        if (data == -1) {       // If data is -1, this means there is no node
            return null;
        }

        // Create a new node with the given data
        BinaryTreeNode node = new BinaryTreeNode(data);
        // Recursively insert the left child
        System.out.print("Enter left child of " + data);
        node.left = insertNode(sc);
        // Recursively insert the right child
        System.out.print("Enter right child of " + data);
        node.right = insertNode(sc);
        return node;        // Return the created node
    }

    // Method to check if two binary trees are identical
    public static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
        // If both trees are empty, they are identical
        if (root1 == null && root2 == null) {
            return true;
        }

        // If both trees are non-empty, compare data and recurse
        if (root1 != null && root2 != null) {
            return (root1.data == root2.data &&         // Compare the data of the nodes
                    areIdentical(root1.left, root2.left) &&         // Recursively check the left subtrees
                    areIdentical(root1.right, root2.right));        // Recursively check the right subtrees
        }

        // One tree is empty and one is not, they are not identical
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        // Scanner object to read input

        // Create the first binary tree
        System.out.println("Create first binary tree - ");
        BinaryTreeNode root1 = insertNode(sc);

        // Create the second binary tree
        System.out.println("Create second binary tree - ");
        BinaryTreeNode root2 = insertNode(sc);

        // Check if the two binary trees are identical and print the result
        if (areIdentical(root1, root2)) {
            System.out.println("The two binary trees are identical.");
        } else {
            System.out.println("The two binary trees are not identical.");
        }
    }
}
