package datalearning.test;

import datalearning.interf.Queue;
import datalearning.queue.ArrayQueue;
import datalearning.queue.LinkedListQueue;
import datalearning.queue.LoopQueue;

import java.util.Random;

public class QueueMain {

    public static void main(String[] args) {
        int opt = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println(testQueue(arrayQueue, opt));
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(testQueue(loopQueue, opt));
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println(testQueue(linkedListQueue, opt));
    }

    private static double testQueue(Queue<Integer> queue, int optCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            queue.dequeueu();
        }
        long end = System.nanoTime();
        return (end - start) / (1000000000.0);
    }

}
