package week5;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        
        MyQueue queue = new MyQueue();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue {
        
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void enqueue(Integer n) {
            stack1.push(n);
        }

        public Integer dequeue() {
            if (size() == 0) {
                return null;
            }
            if (stack2.isEmpty()) {
                shiftStacks();
            }
            return stack2.pop();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }

        public Integer peek() {
            if (size() == 0) {
                return null;
            }
            if (stack2.isEmpty()) {
                shiftStacks();
            }
            return stack2.peek();
        }

        // Only shifts stacks if necessary 
        private void shiftStacks() {
            if (stack2.isEmpty()) { // shifting items while stack2 contains items would mess up our queue's ordering
                while ( ! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }


    }
}
