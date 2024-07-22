package DSAQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Define a class for tree nodes
class BinaryTreeNode01 {
    int val;
    BinaryTreeNode01 left;
    BinaryTreeNode01 right;

    // Constructor to initialize node value
    BinaryTreeNode01(int val) {
        this.val = val;
    }
}

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input and read the values
        System.out.print("Enter the values of the binary tree in level order (use '-1' for empty nodes):");
        String input = scanner.nextLine();
        String[] values = input.split(",");

        // Build the tree from the input values
        BinaryTreeNode01 root = buildTree(values);

        // Calculate the maximum depth of the binary tree
        int maxDepth = maxDepth(root);
        System.out.println("The maximum depth of the binary tree is: " + maxDepth);

        scanner.close();
    }

    // Function to calculate the maximum depth of a binary tree
    public static int maxDepth(BinaryTreeNode01 root) {
        if (root == null) {
            return 0; // If the tree is empty, depth is 0
        }

        // Recursively calculate the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the tree is the greater depth of the two subtrees plus one
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Function to build a binary tree from level order input
    private static BinaryTreeNode01 buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("-1")) {
            return null; // If no values or the root is empty, return null
        }

        // Initialize the root of the tree
        BinaryTreeNode01 root = new BinaryTreeNode01(Integer.parseInt(values[0]));
        Queue<BinaryTreeNode01> queue = new LinkedList<>();
        queue.add(root); // Add the root to the queue for level order construction

        int i = 1; // Start from the second value in the array
        while (!queue.isEmpty() && i < values.length) {
            BinaryTreeNode01 current = queue.poll(); // Get the current node from the queue

            // Process the left child
            if (!values[i].equals("-1")) {
                current.left = new BinaryTreeNode01(Integer.parseInt(values[i]));
                queue.add(current.left); // Add the left child to the queue
            }
            i++;

            // Process the right child if there are more values
            if (i < values.length && !values[i].equals("-1")) {
                current.right = new BinaryTreeNode01(Integer.parseInt(values[i]));
                queue.add(current.right); // Add the right child to the queue
            }
            i++;
        }

        return root; // Return the constructed binary tree
    }
}
