package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 *
 *
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 *
 *
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 *
 * 示例 4：
 * 输入：points = [[1,2]]
 * 输出：1
 *
 * 示例 5：
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 * 提示：
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 *
 * 解题思路：为了能够使用最小的箭，那么我们需要使每个箭能够尽可能的穿过最多的气球。
 *          我们以右边界排序，比如说第一个点的右边界为x，那么所有左边界比x小都可以引爆，引爆之后，找下一个最小的右边界。。。
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT452 {
    public static void main(String[] args) {
        SolutionLT452 lt = new SolutionLT452();
        System.out.println(lt.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));//2
        System.out.println(lt.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));//4
        System.out.println(lt.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));//2
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length==0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
              return   Integer.compare(p1[1],p2[1]);
            }
        });

        int pos=points[0][1];
        int ans=1;
        for (int[] point:points){
            if (point[0]>pos){//出现了节点在当前右边界的右边了
                pos=point[1];
                ans++;
            }
        }
        return ans;
    }
}
