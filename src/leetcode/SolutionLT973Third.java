package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

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
 * 解题思路：借鉴快速排序的思想。
 * 快速排序每次划分一个点，然后将数组分为两部分，其中小于等于分界值的point的元素会被放到左侧。大于的放到右侧
 * 这里我们有个不一样的地方，其实我们如果发现K个大小的数据在左侧的话，那么右侧的我们就可以不再处理，直接在左侧的数组中去查找数据就可以了
 * 我们需要定义一个函数，能够将数组进行分组，
 * 比如说以下标point为基准点，[left,point-1]的区间都比point坐标的小。[point+1,right]都比point坐标的大
 * 然后根据point的情况再处理
 * K=i-left+1    说明point就是我们要找的值。
 * K<i-left+1    说明K在point的左侧。这时候我们递归在[left,point]位置去查找
 * K>i-left+1    说明K在point的右侧。这时候我们递归在[point,right]位置去查找
 * <p>
 * 空间复杂度：O(K)。优先级队列中最多有K个点
 */
class SolutionLT973Third {
    Random random = new Random();

    public static void main(String[] args) {
        SolutionLT973Third lt = new SolutionLT973Third();
        System.out.println(lt.kClosest(new int[][]{{1, 3}, {-2, 2}}, 2));//[-2,2]
         System.out.println(lt.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));//[[3,3],[-2,4]]
        System.out.println(lt.kClosest(new int[][]{{2, 2}, {2, 2}, {1, 1}, {2, 2}, {2, 2}, {2, 2}, {2, 2}}, 1));//[1,1]
    }

    public int[][] kClosest(int[][] points, int K) {
        range(points, 0, points.length - 1, K);
        return Arrays.copyOf(points, K);
    }

    private void range(int[][] points, int left, int right, int k) {
        if(right<=left){
            return;
        }
        int point = random.nextInt(right - left + 1) + left;
        //步骤1  将随机位置point移动到末尾
        swap(points, point, right);
        //步骤2  从头遍历，两个指针，比point位置大的，移动到右侧
        int start = left - 1;
        for (int i = left; i < right; i++) {
            if (compare(points, i, right) < 0) {//这里注意，我们需要将比它小的进行左移，而相等的则不需要左移否则可能会导致跟它相同的和他本身没办法区分了
                start++;
                swap(points, start, i);
            }
        }
        //步骤3  将比k小的位置的坐标切换回来
        start++;
        swap(points, start, right);
        //步骤3  查看k的坐标，跟K作比较
        if (start == k) {
            return;
        }
        if (start < k) {
            range(points, start+1, right, k);
        } else {
            range(points, left, start-1, k);
        }
    }

    private int compare(int[][] points, int start, int end) {
        int[] o1 = points[start];
        int[] o2 = points[end];
        return o1[0] * o1[0] + o1[1] * o1[1] - (o2[0] * o2[0] + o2[1] * o2[1]);
    }


    private void swap(int[][] points, int k, int end) {
        int[] temp = points[k];
        points[k] = points[end];
        points[end] = temp;
    }

}