package DSAQuestions;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        // Creating a Scanner object to read input from the console

        // Reading the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        // Initializing the array to store the elements
        int[] nums = new int[n];

        // Reading the elements of the array in ascending order
        System.out.print("Enter the elements of the array in ascending order: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Reading the target value to search in the array
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        // Initializing pointers for binary search
        int left = 0;
        int right = nums.length - 1;
        int result = -1;        // Variable to store the result (index of the target if found)

        // Performing binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;        // Calculating the middle index

            // Checking if the target is found
            if (nums[mid] == target) {
                result = mid;       // Storing the index of the target
                break;
            }
            // If target is greater than the middle element, search in the right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller than the middle element, search in the left half
            else {
                right = mid - 1;
            }
        }

        // Output the result
        if (result != -1) {
            System.out.print("Target found at index: " + result);       // Target found, print the index
        } else {
            System.out.print("Target not found in the array.");         // Target not found
        }
    }
}
