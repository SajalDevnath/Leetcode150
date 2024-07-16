package DSAQuestions;

import java.util.Scanner;

// Class representing each node in the binary tree
class BinaryTreeNode1 {
    int val;
    BinaryTreeNode1 left;
    BinaryTreeNode1 right;

    // Constructor to initialize the node with a value
    BinaryTreeNode1(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       // Scanner object to read input

        // Create the root tree from user input
        System.out.println("Create the root tree:");
        BinaryTreeNode1 root = insertNode(scanner);

        // Create the subRoot tree from user input
        System.out.println("Create the subRoot tree:");
        BinaryTreeNode1 subRoot = insertNode(scanner);

        // Check if subRoot is a subtree of root
        boolean result = isSubtree(root, subRoot);

        // Print the result
        System.out.println(result);
    }

    // Method to insert nodes into the binary tree
    public static BinaryTreeNode1 insertNode(Scanner sc) {
        System.out.print("Enter node data (-1 to indicate no node): ");
        int data = sc.nextInt();        // Read data for the node
        if (data == -1) {       // If data is -1, this means there is no node
            return null;
        }

        // Create a new node with the given data
        BinaryTreeNode1 node = new BinaryTreeNode1(data);
        // Recursively insert the left child
        System.out.println("Enter left child of " + data);
        node.left = insertNode(sc);
        // Recursively insert the right child
        System.out.println("Enter right child of " + data);
        node.right = insertNode(sc);
        return node;  // Return the created node
    }

    // Method to check if subRoot is a subtree of root
    private static boolean isSubtree(BinaryTreeNode1 root, BinaryTreeNode1 subRoot) {
        if (root == null) return false;         // If root is null, subRoot cannot be a subtree
        if (isSameTree(root, subRoot)) return true;         // If the trees match, subRoot is a subtree
        // Recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Method to check if two binary trees are identical
    private static boolean isSameTree(BinaryTreeNode1 s, BinaryTreeNode1 t) {
        if (s == null && t == null) return true;        // If both trees are empty, they are identical
        if (s == null || t == null) return false;       // If one tree is empty and the other is not, they are not identical
        if (s.val != t.val) return false;       // If the values of the current nodes are different, the trees are not identical
        // Recursively check the left and right subtrees
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
