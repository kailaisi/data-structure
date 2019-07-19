package test;

import array.ArrayStack;
import interf.Stack;
import link.LinkedListStack;

import java.util.Random;

public class StackMain {

    public static void main(String[] args) {
        int opt = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println(testStack(arrayStack, opt));
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println(testStack(linkedListStack, opt));
    }

    private static double testStack(Stack<Integer> queue, int optCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            queue.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            queue.pop();
        }
        long end = System.nanoTime();
        return (end - start) / (1000000000.0);
    }
}
