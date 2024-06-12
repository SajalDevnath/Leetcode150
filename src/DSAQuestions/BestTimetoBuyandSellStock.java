package DSAQuestions;

import java.util.Scanner;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);        // Creating a Scanner object to read input from the console
        System.out.print("Enter the size: ");       // Prompting the user to enter the size of the array
        int size = sc.nextInt();        // Reading the size of the array from the user input
        int[] days = new int[size];         // Creating an array of integers with the specified size

        System.out.print("Enter the days: ");       // Prompting the user to enter the elements of the array
        for (int i = 0; i < size; i++) {        // Looping through each index of the array
            days[i] = sc.nextInt();         // Reading each number from the user input and storing it in the array
        }

        System.out.print("The days are: ");         // Printing a message before displaying the array elements
        for (int i = 0; i < size; i++) {        // Looping through each index of the array
            System.out.print(days[i] + " ");        // Printing each element of the array followed by a space
        }
        System.out.println();       // Moving to the next line after printing all elements

        int minimum = days[0];      // Initializing the minimum variable with the first element of the array
        int profit = 0;         // Initializing the profit variable to 0
        for (int i = 0; i < size; i++) {        // Looping through each element of the array
            int cost = days[i] - minimum;       // Calculating the potential profit if selling on day i
            profit = Math.max(profit, cost);        // Updating the maximum profit if the current profit is higher
            minimum = Math.min(minimum, days[i]);       // Updating the minimum value if the current day is lower
        }

        System.out.print("The profit is: " + profit);       // Printing the maximum profit
    }
}
