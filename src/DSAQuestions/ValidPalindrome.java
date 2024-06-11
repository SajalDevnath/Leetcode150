package DSAQuestions;

import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);        // Creating a Scanner object to read input from the console
        System.out.print("Enter a String: ");       // Prompting the user to enter a string
        String s = sc.nextLine();       // Reading the entire line of input entered by the user

        // Cleaning the input string by removing all non-alphanumeric characters and converting it to lowercase
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverse = "";        // Initializing an empty string to hold the reversed cleaned string

        // Looping through the cleaned string in reverse order
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reverse = reverse + cleaned.charAt(i);      // Building the reverse string by concatenating characters
        }

        // Checking if the cleaned string is equal to its reverse
        if (cleaned.equals(reverse)) {
            System.out.println("It's a palindrome");        // Printing "It's a palindrome" if the strings are equal
        } else {
            System.out.println("Not a palindrome");         // Printing "Not a palindrome" if the strings are not equal
        }

    }
}
