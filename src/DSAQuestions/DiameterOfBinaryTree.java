package DSAQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class representing each node in the binary tree
class TreeNode01 {
    int val;  // Value of the node
    TreeNode01 left;  // Left child
    TreeNode01 right;  // Right child

    // Constructor to initialize the node's value
    TreeNode01(int x) {
        val = x;
    }
}

public class DiameterOfBinaryTree {
    private static int maxDiameter = 0;  // Variable to store the maximum diameter found

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of nodes
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        // Array to store the input values
        int[] input = new int[n];
        System.out.print("Enter the node values (-1 for null nodes): ");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();  // Read each node value
        }

        // Construct the binary tree from the input values
        TreeNode01 root = constructTree(input);

        // Calculate the diameter of the binary tree
        int diameter = diameterOfBinaryTree(root);
        System.out.print("Diameter of the binary tree: " + diameter);
    }

    // Method to calculate the diameter of the binary tree
    public static int diameterOfBinaryTree(TreeNode01 root) {
        calculateHeight(root);  // Calculate the height and update the diameter
        return maxDiameter;  // Return the maximum diameter found
    }

    // Helper method to calculate the height of the tree and update the diameter
    private static int calculateHeight(TreeNode01 node) {
        if (node == null) {
            return 0;  // Base case: height of an empty tree is 0
        }

        // Recursively calculate the height of the left subtree
        int leftHeight = calculateHeight(node.left);
        // Recursively calculate the height of the right subtree
        int rightHeight = calculateHeight(node.right);

        // The diameter at the current node is the sum of the heights of the left and right subtrees
        int diameterAtNode = leftHeight + rightHeight;

        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, diameterAtNode);

        // Return the height of the tree rooted at the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Helper method to construct a binary tree from level order input
    private static TreeNode01 constructTree(int[] values) {
        if (values.length == 0 || values[0] == -1) {
            return null;  // Return null if the input is empty or the first value is -1
        }

        // Create the root node with the first value
        TreeNode01 root = new TreeNode01(values[0]);
        Queue<TreeNode01> queue = new LinkedList<>();  // Queue to facilitate level order insertion
        queue.offer(root);  // Add the root to the queue
        int i = 1;

        // Process the input values to build the binary tree
        while (i < values.length) {
            TreeNode01 current = queue.poll();  // Get the current node from the queue

            // Process the left child
            if (i < values.length && values[i] != -1) {
                current.left = new TreeNode01(values[i]);
                queue.offer(current.left);  // Add the left child to the queue
            }
            i++;

            // Process the right child if there are more values
            if (i < values.length && values[i] != -1) {
                current.right = new TreeNode01(values[i]);
                queue.offer(current.right);  // Add the right child to the queue
            }
            i++;
        }

        return root;  // Return the root of the constructed binary tree
    }
}
