package jianzhi;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * 知识点：栈
 * 解题思路：
 *  使用辅助栈。栈1，保存数据。栈2保存最小数字。比如先存的5，再存2的时候，那么2如栈。如果再存的是6，那么不会进行入栈了。
 */
public class SolutionJZ20second {
    Stack<Integer> v1=new Stack<>();
    Stack<Integer> v2=new Stack<>();
    public static void main(String[] args) {
        SolutionJZ20second test = new SolutionJZ20second();
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
        v1.add(node);
        if(v2.isEmpty() || node<=v2.peek()){//为了防止入2，再入，2。当pop出来一个2的时候，2仍然是最小数字这种情况
            v2.add(node);
        }
    }

    public void pop() {
        Integer pop = v1.pop();
        if(v2.peek()==pop){
            v2.pop();
        }
    }

    public int top() {
        return  v1.peek();
    }

    public int min() {
        return  v2.peek();
    }
}
