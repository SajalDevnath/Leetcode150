package DSAQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class representing each node in the binary tree
class BalancedTreeNode {
    int val;  // Value of the node
    BalancedTreeNode left;  // Left child
    BalancedTreeNode right;  // Right child

    // Constructor to initialize the node's value and set children to null
    BalancedTreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of nodes in the tree
        System.out.println("Enter the number of nodes in the tree:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the integer input

        // If there are no nodes, the tree is balanced
        if (n == 0) {
            System.out.println("The tree is balanced.");
            return;
        }

        // Prompt the user to enter the values of the nodes in level order
        System.out.println("Enter the values of the nodes in level order (use '-1' for no node):");
        String input = scanner.nextLine();
        String[] values = input.split(",");  // Split the input string into an array of values

        BalancedTreeNode root = null;
        Queue<BalancedTreeNode> queue = new LinkedList<>();  // Queue to facilitate level order insertion

        // Initialize the root of the tree if the first value is not '-1'
        if (n > 0 && !values[0].equals("-1")) {
            root = new BalancedTreeNode(Integer.parseInt(values[0]));
            queue.offer(root);  // Add the root to the queue
        }

        int index = 1;  // Start from the second value in the array
        while (!queue.isEmpty() && index < n) {
            BalancedTreeNode currentNode = queue.poll();  // Get the current node from the queue

            if (currentNode != null) {
                // Process the left child
                if (index < values.length && !values[index].equals("-1")) {
                    currentNode.left = new BalancedTreeNode(Integer.parseInt(values[index]));
                    queue.offer(currentNode.left);  // Add the left child to the queue
                }
                index++;

                // Process the right child if there are more values
                if (index < values.length && !values[index].equals("-1")) {
                    currentNode.right = new BalancedTreeNode(Integer.parseInt(values[index]));
                    queue.offer(currentNode.right);  // Add the right child to the queue
                }
                index++;
            }
        }

        // Check if the tree is balanced
        if (isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }

        scanner.close();
    }

    // Function to determine if a tree is balanced
    public static boolean isBalanced(BalancedTreeNode root) {
        // A tree is balanced if the height function does not return -1
        return height(root) != -1;
    }

    // Function to calculate the height of a node and check if the subtree is balanced
    private static int height(BalancedTreeNode node) {
        if (node == null) {
            return 0;  // Base case: height of an empty tree is 0
        }

        int leftHeight = height(node.left);  // Recursively calculate the height of the left subtree
        if (leftHeight == -1) {
            return -1;  // If the left subtree is not balanced, propagate the failure upwards
        }

        int rightHeight = height(node.right);  // Recursively calculate the height of the right subtree
        if (rightHeight == -1) {
            return -1;  // If the right subtree is not balanced, propagate the failure upwards
        }

        // If the difference in heights is more than 1, the tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;  // Return -1 to indicate the tree is not balanced
        }

        // Return the height of the tree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
