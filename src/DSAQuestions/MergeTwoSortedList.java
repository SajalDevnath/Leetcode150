package DSAQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        // Creating a Scanner object to read input from the console

        // Input for List 1
        System.out.print("Enter the number of elements of list 1: ");
        int num1 = sc.nextInt();        // Reading the number of elements in list 1
        ArrayList<Integer> list1 = new ArrayList<>();       // Creating an ArrayList to store elements of list 1

        // Handling case when list 1 is not empty
        if (num1 > 0) {
            System.out.print("Enter the numbers of list 1: ");
            for (int i = 0; i < num1; i++) {
                list1.add(sc.nextInt());        // Adding each element of list 1 to the ArrayList
            }
        } else {
            System.out.println("List 1 is empty.");         // Informing user when list 1 is empty
        }

        // Input for List 2
        System.out.print("Enter the number of elements of list 2: ");
        int num2 = sc.nextInt();        // Reading the number of elements in list 2
        ArrayList<Integer> list2 = new ArrayList<>();       // Creating an ArrayList to store elements of list 2

        // Handling case when list 2 is not empty
        if (num2 > 0) {
            System.out.print("Enter the numbers of list 2: ");
            for (int i = 0; i < num2; i++) {
                list2.add(sc.nextInt());        // Adding each element of list 2 to the ArrayList
            }
        } else {
            System.out.println("List 2 is empty.");         // Informing user when list 2 is empty
        }

        // Merging and sorting the lists if they are not empty
        if (!list1.isEmpty() || !list2.isEmpty()) {
            list1.addAll(list2);        // Merge list2 into list1
            Collections.sort(list1);        // Sort the merged list (list1)

            // Displaying the merged and sorted list
            System.out.print("Merged sorted list: ");
            for (int i = 0; i < list1.size(); i++) {
                int num = list1.get(i);
                System.out.print(num + " ");        // Printing each element of the merged list followed by a space
            }
        } else {
            System.out.println("Both lists are empty. No merge operation performed."); // Informing user when both lists are empty
        }
    }
}
