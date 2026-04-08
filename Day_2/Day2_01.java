//Sort a stack using another stack
//Sort a stack in ascending order using another temp stack
//Input: 34 3 31 98 92 23

import java.util.Stack;

public class Day2_01 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(34);
        stack.push(3);      
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Input: " + stack);
        sort(stack);
        System.out.println("Output: " + stack);
    }
    static void sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

            //loop run until the original stack becomes empty
        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    
}
