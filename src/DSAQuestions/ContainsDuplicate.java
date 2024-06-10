package DSAQuestions;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creating a Scanner object to read input from the console
        System.out.print("Enter the size: "); // Prompting the user to enter the size of the array
        int size = sc.nextInt(); // Reading the size of the array from the user input
        int[] nums = new int[size]; // Creating an array of integers with the specified size

        System.out.print("Enter the numbers: "); // Prompting the user to enter the numbers for the array
        for (int i = 0; i < size; i++) { // Looping through each index of the array
            nums[i] = sc.nextInt(); // Reading each number from the user input and storing it in the array
        }

        // -- The following commented block is an alternative method to check for duplicates using sorting.
        // -- Sorting the array allows for a more efficient duplicate check.

        // boolean duplicate = false;        // Initializing a boolean variable to track whether duplicates are found
        // Arrays.sort(nums);        // Sorting the array in ascending order
        // for (int i = 0; i < size - 1; i++) {      // Looping through the sorted array
        //     if(nums[i] == nums[i + 1]){       // Checking if the current element is equal to the next element
        //         return true;      // Returning true if a duplicate is found
        //     }
        // }
        // return false;        // Returning false if no duplicates are found

        boolean duplicate = false; // Initializing a boolean variable to track whether duplicates are found
        for (int i = 0; i < size; i++) { // Outer loop to iterate through each element of the array
            for (int j = i + 1; j < size; j++) { // Inner loop to compare the current element with the rest of the elements
                if(nums[i] == nums[j]){ // Checking if there's a duplicate element
                    duplicate = true; // Setting the duplicate flag to true if a duplicate is found
                    break; // Exiting the inner loop since a duplicate is already found
                }
            }
            if(duplicate){ // Checking if a duplicate is found after the inner loop
                break; // Exiting the outer loop since a duplicate is already found
            }
        }

        if(duplicate){ // Checking if a duplicate is found
            System.out.println("True"); // Printing "True" if a duplicate is found
        }else{
            System.out.println("False"); // Printing "False" if no duplicate is found
        }
    }
}
