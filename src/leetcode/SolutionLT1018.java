package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 * 示例 1：
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *  
 * 提示：
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 * 注意事项：这里可能会存在越界情况
 * 其实我们只关心最后一位即可。如果数据大于10了，我们取个位数，查看个位数是否是0或者5即可
 */
public class SolutionLT1018 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        List<Boolean> list = new SolutionLT1018().prefixesDivBy5(ints);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,true,true,true,true,false]");
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        ArrayList<Boolean> list = new ArrayList<>();
        int count=0;
        for(int i=0;i<A.length;i++){
            count=2*count+A[i];
            if (count>10) {//我们只关心最后一位是不是0或者5.如果数据大于10了，我们就取最后一位
                count=count%10;
            }
            System.out.print(count+" ");
            if(count%5==0){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        System.out.println("");
        return list;
    }
}
