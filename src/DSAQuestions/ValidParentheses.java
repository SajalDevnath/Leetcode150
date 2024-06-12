package DSAQuestions;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String expression = "";         // Initializing the expression string
        Stack<Character> s = new Stack<>();         // Creating a stack to store characters

        // Loop through each character in the expression string
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);         // Get the character at the current position
            if (ch == '(' || ch == '{' || ch == '[') {        // Check if the character is an opening bracket
                s.push(ch);         // Push the opening bracket onto the stack
            } else {        // If the character is a closing bracket
                if (!s.empty()) {         // Check if the stack is not empty
                    char top = s.peek();        // Peek at the top character of the stack
                    // Check if the top character is the matching opening bracket
                    if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
                        s.pop();        // Pop the top character from the stack if it matches
                    } else {
                        System.out.println("Invalid Parentheses");      // Print invalid if it doesn't match
                        return;         // Exit the program
                    }
                } else {
                    System.out.println("Invalid Parentheses");      // Print invalid if stack is empty and a closing bracket is found
                    return;         // Exit the program
                }
            }
        }
        if (s.empty()) {      // After processing all characters, check if the stack is empty
            System.out.println("Valid Parentheses");        // If empty, all brackets were matched correctly
        } else {
            System.out.println("Invalid Parentheses");      // If not empty, some opening brackets were not matched
        }

    }
}
