package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * [[2,2],[2,2],[2,2],[2,2],[2,2],[2,2],[1,1]]
 * 提示：
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * <p>
 * 解题思路：本题从本质上讲，其实还是进行排序，是按照点到原点的距离的大小进行排序。这个距离其实是没有必要求平方根的。
 * 我们可以使用一个大根堆来实时的维护前K个最小的平方距离。这里我们使用优先级队列。
 * 可以先将前k个数据放入到堆中，然后遍历k+1往后的数据，如果比队列顶部的小，则移除队列头，然后将该数字加入。
 * 时间复杂度：O(nlogK)。对于优先级队列，使用的是最大堆，插入和弹出操作的单词时间都是logK的时间复杂度。
 * 空间复杂度：O(K)。优先级队列中最多有K个点
 */
class SolutionLT973Second {
    public static void main(String[] args) {
        SolutionLT973Second lt = new SolutionLT973Second();
        System.out.println(lt.kClosest(new int[][]{{1,3},{-2,2}},1));//[-2,2]
        System.out.println(lt.kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2));//[[3,3],[-2,4]]
        System.out.println(lt.kClosest(new int[][]{{2, 2}, {2, 2}, {1, 1}, {2, 2}, {2, 2}, {2, 2}, {2, 2}}, 1));//[1,1]
        System.out.println(lt.kClosest(new int[][]{{-5,4}, {-6,-5}, {4,6}}, 2));//[[-5,4],[4,6]]
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return  (o2[0] * o2[0] + o2[1] * o2[1])-(o1[0] * o1[0] + o1[1] * o1[1]) ;
            }
        });
        int length = points.length;
        for (int i = 0; i < K; i++) {
            queue.add(points[i]);
        }
        for (int i = K; i < length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            int[] peek = queue.peek();
            int big = peek[0] * peek[0] + peek[1] * peek[1];
            if (dist < big) {
                queue.poll();
                queue.offer(points[i]);
            }
        }
        int[][] ints = new int[K][2];
        for (int i = 0; i < K; i++) {
            ints[i] = queue.poll();
        }
        return ints;
    }

}