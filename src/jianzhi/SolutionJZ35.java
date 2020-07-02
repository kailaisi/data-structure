package jianzhi;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 *      题目保证输入的数组中没有的相同的数字
 *      数据范围：
 * 	          对于%50的数据,size<=10^4
 * 	          对于%75的数据,size<=10^5
 * 	          对于%100的数据,size<=2*10^5
 *
 *      示例
 *      输入：1,2,3,4,5,6,7,0
 *      输出： 7
 * 知识点：数组
 * 解题思路：
 *   数组遍历，每放进去一个数据，看该数据，在前面的所有数据中的排序位置。然后就可以确定增加当前位置的数字，所能组成的逆序对。
 */
public class SolutionJZ35 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(ints));
    }
    public static int InversePairs(int [] array) {
        int[] ints = new int[array.length];
        int count=0;
        for(int i=0;i<array.length-1;i++){
            binarySearch()
            if(array[i]<array[i+1]){
                count++;
            }
        }
        return count%1000000007;
    }
    // 二分查找法，查找位置
    static int binarySearch(int[] array, int size, int value) {
        //定义低位
        int lo = 0;
        //定义高位
        int hi = size - 1;
        //遍历循环，知道搜索到目标
        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }
}
