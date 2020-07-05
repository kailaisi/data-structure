package jianzhi;

import java.util.ArrayList;
import java.util.Collections;

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
 *  分治方法。先将数组进行拆分。
 *  然后将其排序，
 *  排序后的两个数组再合并到一起（通过排序）。在这个过程中统计逆序对
 */
public class SolutionJZ35 {
    public static void main(String[] args) {
        int[] ints = {7, 2, 4, 3, 1, 6, 5, 0};
        int[] aints={1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(ints));
    }
    public static int InversePairs(int [] array) {
        if(array==null ||array.length<=1){
            return 0;
        }
        int[] copy=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i]=array[i];
        }
        return InversePairsCore(array,copy,0,array.length-1);
    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if(low==high){
            return 0;
        }
        int mid=(low+high)>>1;
        //左侧的数量
        int leftCount=InversePairsCore(array,copy,low,mid)%1000000007;
        //右侧的数量
        int rightCount=InversePairsCore(array,copy,mid+1,high)%1000000007;
        //计算二者合并成新的数组时，产生的逆序对数量
        int count=0;
        int i=mid;
        int j=high;
        int locCopy=high;
        //排序的时候，依次从最后一位取出数据，然后放到copy数组中，在这个过程中，计算逆序对数量
        while (i>=low && j>mid){
            if(array[i]>array[j]){//这时候，i比mid~j之间的都要大。
                //这里原来使用了mid+1-j。其实是重复了。因为如果low-mid是[2,3,4]，mid-heigh是[0,1]。在计算3的时候，mid+1-j。计算了4比0大。再计算2时，仍然会统计4比0大。所以会存在重复问题
                count+=(j-mid);
                copy[locCopy]=array[i];//将i放到顺序数组的最后
                locCopy--;
                i--;
                if(count>=1000000007){
                    count%=1000000007;
                }
            }else{//
                copy[locCopy--]=array[j--];
            }
        }
        //到这里为止，可能存在，i或者j遍历完了，但是另一个仍然还存在数据。所以继续。
        for (;i>=low;i--){
            copy[locCopy--]=array[i];
        }
        for (; j>mid ; j--) {
            copy[locCopy--]=array[j];
        }
        //到这里为止，copy已经是顺序的数组，从小到大。然后将copy数组赋值给array数据，将其low，到high的位置从小到大排序
        for(int k=low;k<=high;k++){
            array[k]=copy[k];
        }
        return (leftCount+rightCount+count)%1000000007;
    }

    // 二分查找法，查找位置
    static int binarySearch(ArrayList<Integer> array, int size, int value) {
        //定义低位
        int lo = 0;
        //定义高位
        int hi = size - 1;
        //遍历循环，知道搜索到目标
        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array.get(mid);

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        System.out.println(lo);
        System.out.println(-lo);
        return -lo;  // value not present
    }
}
