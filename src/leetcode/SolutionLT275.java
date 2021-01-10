package leetcode;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * 示例:
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 * 说明:
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 *
 * 思路：暴力法：  论文被引用的次数为c[i]。比应用次数大的个数是length-(i+1)
 * 因为是有序的，所以可以通过比较两个数来进行，如果不符合条件，就下一个。符合条件就返回当前的符合的个数length-i   。因为当前的i位置是符合条件的。
 */
class SolutionLT275 {

    public static void main(String[] args) {
        SolutionLT275 lt = new SolutionLT275();
        System.out.println(lt.hIndex(new int[]{0,1,4,4,5,6}));
        System.out.println(lt.hIndex(new int[]{0,1,2,5,6}));
        System.out.println(lt.hIndex(new int[]{0,1,4,5,6}));
        System.out.println(lt.hIndex(new int[]{0}));
        System.out.println(lt.hIndex(new int[]{3}));
    }

    public int hIndex(int[] citations) {
        int length = citations.length;
        for (int i = 0; i <length; i++) {
            if(citations[i]>length-(i+1)){
                return length-(i);
            }
        }
        return 0;
    }
}