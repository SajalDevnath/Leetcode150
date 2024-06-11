package DSAQuestions;

import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);        // Creating a Scanner object to read input from the console
        System.out.print("Enter the size of array: ");      // Prompting the user to enter the size of the array
        int size = sc.nextInt();        // Reading the size of the array from the user input
        int[] arr = new int[size];      // Creating an array of integers with the specified size

        System.out.print("Enter the numbers: ");        // Prompting the user to enter the numbers for the array
        for (int i = 0; i < size; i++) {        // Looping through each index of the array
            arr[i] = sc.nextInt();      // Reading each number from the user input and storing it in the array
        }

        System.out.print("The numbers are: ");      // Printing a message before displaying the array elements
        for (int i = 0; i < size; i++) {        // Looping through each index of the array
            System.out.print(arr[i] + " ");         // Printing each element of the array followed by a space
        }
        System.out.println();       // Moving to the next line after printing all elements

        System.out.print("Enter the target integer: ");         // Prompting the user to enter the target integer
        int target = sc.nextInt();      // Reading the target integer from the user input

        for (int i = 0; i < size; i++) {        // Outer loop to iterate through each element of the array
            for (int j = i + 1; j < size; j++) {        // Inner loop to iterate through the elements after the current element
                if ((arr[i] + arr[j]) == target) {      // Checking if the sum of the current pair of elements equals the target
                    System.out.println("[" + i + ", " + j + "]");       // Printing the indices of the pair that sums to the target
                    return;         // Exiting the program since a valid pair is found
                }
            }
        }
        System.out.println("No pairs found!");      // Printing a message if no valid pairs are found after all iterations
    }
}
