package com.practice.java.dsa;

import java.util.Stack;

public class BalancedParantheses {

    public static void main(String[] args) {
        String input = "[()";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(input.charAt(i));
            } else {
                if (stack.empty()) {
                  System.out.println("Not balanced");
                  return;
              }
                char prevChar = stack.peek();
                if ((currentChar == ')' && prevChar != '(') || (currentChar == '}' && prevChar != '{') || (currentChar == ']' && prevChar != '[')) {
                    System.out.println("Not balanced");
                    return;
                }
                stack.pop();
            }
        }
        System.out.println(stack.empty() ? "Balanced" : "Not Balanced");
    }

}
