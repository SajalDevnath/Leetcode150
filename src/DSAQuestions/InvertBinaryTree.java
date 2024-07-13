package DSAQuestions;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InvertBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input for the binary tree
        System.out.print("Enter the number of nodes in the tree: ");
        int n = sc.nextInt();

        // If there are no nodes, print an empty tree and exit
        if (n == 0) {
            System.out.println("[]");
            sc.close();
            return;
        }

        // Read the values of the nodes
        int[] nodes = new int[n];
        System.out.print("Enter the values of the nodes: ");
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.nextInt();
        }

        // Step 2: Convert the input array to a binary tree
        TreeNode root = insertLevelOrder(nodes, 0);

        // Step 3: Print the original tree
        System.out.print("Original tree: ");
        printLevelOrder(root);

        // Step 4: Invert the binary tree
        root = invertTree(root);

        // Step 5: Print the inverted tree
        System.out.print("\nInverted tree: ");
        printLevelOrder(root);

        // Close the scanner
        sc.close();
    }

    // Function to invert a binary tree
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;          // Base case: if the tree is empty
        TreeNode temp = root.left;          // Temporary variable to hold the left child
        root.left = root.right;         // Swap the left child with the right child
        root.right = temp;          // Set the right child to the original left child
        invertTree(root.left);          // Recursively invert the left subtree
        invertTree(root.right);         // Recursively invert the right subtree
        return root;        // Return the root of the inverted tree
    }

    // Function to insert nodes into the binary tree level-wise
    public static TreeNode insertLevelOrder(int[] arr, int i) {
        // Base case: if the index is out of bounds or the node value is -1 (null)
        if (i >= arr.length || arr[i] == -1) return null;
        TreeNode root = new TreeNode(arr[i]);       // Create a new tree node
        root.left = insertLevelOrder(arr, 2 * i + 1);       // Recursively insert the left child
        root.right = insertLevelOrder(arr, 2 * i + 2);          // Recursively insert the right child
        return root;        // Return the root of the subtree
    }

    // Function to print the binary tree level-wise
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");       // Print empty tree if root is null
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();         // Queue for level-order traversal
        queue.add(root);        // Add the root node to the queue
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();       // Remove the front node from the queue
            System.out.print(tempNode.val + " ");       // Print the value of the node
            if (tempNode.left != null) queue.add(tempNode.left);        // Add left child to the queue if it exists
            if (tempNode.right != null) queue.add(tempNode.right);          // Add right child to the queue if it exists
        }
        System.out.println();       // Print a newline after the traversal
    }
}
