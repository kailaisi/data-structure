package leetcode;

import java.util.TreeMap;

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
 * 解题思路：对于预定信息，我们可以将数据通过有序的排列来处理。可以按照start进行顺序排列，然后end作为另一个数据和其一起保存起来。
 * 然后按照start进行排序。可以考虑使用map，map的key是start数值，value保存end数值
 * 时间复杂度：O(n^2),
 * 空间复杂度：O(1)
 */
class SolutionLT729Third {

    public static void main(String[] args) {
        SolutionLT729Third lt = new SolutionLT729Third();
        System.out.println(lt.book(37, 50));
        System.out.println(lt.book(33, 50));
        System.out.println(lt.book(4, 17));
    }

    private TreeMap<Integer, Integer> map;

    public SolutionLT729Third() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer pre = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((pre == null || map.get(pre) <= start)//start之前没有数据。或者数据的结束值比start小
                && next == null || end <= next) {//start之后没数据。或者数据的结束值比next小
            map.put(next, next);
            return true;
        }
        return false;
    }

}
