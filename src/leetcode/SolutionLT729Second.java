package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 729  我的日程安排表 I
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 * <p>
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * <p>
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 * <p>
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * <p>
 * 示例 1:
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * 解释:
 * 第一个日程安排可以添加到日历中.  第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了。
 * 第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20 。
 * 说明:
 * <p>
 * 每个测试用例，调用 MyCalendar.book 函数最多不超过 100次。
 * 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。
 * <p>
 * 解题思路：暴力法，每次将预定的起始位置和结束位置保存下来。每次book的时候，检测是否和之前预定的时间有冲突。
 * 1.保存方式    每次都是2个数字的数组。可以使用list来进行保存
 * 2.检测冲突：新增的时间点，start或者end位于之前保存的数据中间
 * 时间复杂度：O(n^2),
 * 空间复杂度：O(1)
 */
class SolutionLT729Second {

    public static void main(String[] args) {
        SolutionLT729Second lt = new SolutionLT729Second();
        System.out.println(lt.book(37,50));
        System.out.println(lt.book(33, 50));
        System.out.println(lt.book(4, 17));
    }

    private List<int[]> list;

    public SolutionLT729Second() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] ints : list) {
            int s1 = ints[0];
            int e1 = ints[1];
            if (!(s1>=end || e1<=start)) { //起始位置比e1大，或者结束时间比s1小。都满足条件，剩下的就不满足了
                return false;
            }
        }
        list.add(new int[]{start,end});
        return true;
    }

}
