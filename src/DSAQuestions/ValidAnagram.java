package DSAQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);        // Creating a Scanner object to read input from the console
        System.out.print("Enter 1st word: ");       // Prompting the user to enter the first word
        String s = sc.nextLine();       // Reading the first word entered by the user
        System.out.print("Enter 2nd word: ");       // Prompting the user to enter the second word
        String t = sc.nextLine();       // Reading the second word entered by the user

        char c1[] = s.toCharArray();        // Converting the first word to a character array
        char c2[] = t.toCharArray();        // Converting the second word to a character array

        // The following commented block is an alternative method to check for anagrams using sorting.
        // Sorting the character arrays allows for a more efficient anagram check.

        //      boolean anagram = false;        // Initializing a boolean variable to track whether the words are anagrams
        //      if(c1.length != c2.length){         // Checking if the lengths of the words are different
        //          return false;       // Returning false if the lengths are different, as they cannot be anagrams
        //      }
        //      Arrays.sort(c1);        // Sorting the characters of the first word
        //      Arrays.sort(c2);        // Sorting the characters of the second word
        //
        //      for(int i = 0; i < c1.length; i++){         // Looping through the characters of the first word
        //          if(c1[i] != c2[i]){         // Checking if the characters at the same position are different
        //              return false;       // Returning false if any characters are different, as they cannot be anagrams
        //          }
        //      }
        //      return true;        // Returning true if all characters match, indicating that the words are anagrams

        if(c1.length != c2.length){         // Checking if the lengths of the words are different
            System.out.println("Not an anagram");       // Printing that the words are not anagrams if lengths are different
            System.exit(0);         // Exiting the program as the words cannot be anagrams
        }
        Arrays.sort(c1);        // Sorting the characters of the first word
        Arrays.sort(c2);        // Sorting the characters of the second word

        for (int i = 0; i < c1.length; i++) {       // Looping through the characters of the first word
            if(c1[i] != c2[i]){         // Checking if the characters at the same position are different
                System.out.println("Not an anagram");       // Printing that the words are not anagrams if any characters differ
                System.exit(0);         // Exiting the program as the words cannot be anagrams
            }
        }
        System.out.println("Its an anagram");       // Printing that the words are anagrams if all characters match

    }
}
