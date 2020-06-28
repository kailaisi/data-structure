import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 解题思路：
 * 这里需要对数组进行排序。那么排序是有很多种的。其实我们可以使用PriorityQueue的小头堆来进行一次排序
 */
public class SolutionJZ29 {
    public static void main(String[] args) {
        int[] ints = new int[3];
        ints[0] = 3;
        ints[1] = 32;
        ints[2] = 321;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if(input.length==0){
            return new ArrayList<>();
        }
        if(k>input.length){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(input.length);
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}