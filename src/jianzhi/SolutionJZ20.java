package jianzhi;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * 知识点：栈
 * 解题思路：
 *  既然需要找个一个时间复杂度为o(1)的min函数，那么我们可以通过一个地方来保存我们的最小值。这时候
 *  可以考虑使用优先级队列PriorityQueue。因为它是按照从小到大来进行排序。
 *  当我们pop元素的时候，记得也要从优先级队列PriorityQueue中移除。
 */
public class SolutionJZ20 {
    PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
    LinkedList<Integer> list=new LinkedList<Integer>();
    public static void main(String[] args) {
        SolutionJZ20 test = new SolutionJZ20();
        test.push(1);
        test.push(3);
        test.push(0);
        test.push(5);
        System.out.println(test.top());
        System.out.println(test.min());
        test.pop();
        System.out.println(test.top());
        System.out.println(test.min());
        test.pop();
        System.out.println(test.top());
        System.out.println(test.min());
    }


    public void push(int node) {
        list.addFirst(node);
        queue.add(node);
    }

    public void pop() {
        Integer first = list.removeFirst();
        queue.remove(first);
    }

    public int top() {
        return  list.getFirst();
    }

    public int min() {
       return queue.peek();
    }
}
