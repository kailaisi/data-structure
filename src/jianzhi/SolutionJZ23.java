package jianzhi;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 知识点：树，栈
 * 解题思路：
 * 后序遍历的数组，最后一个应该是中间位。
 * 按照最后一个数字，按照中间位
 * 将数组拆分为2个，一个数组比他小，一个数组比他大。
 * 如果都比他大，那么就去掉最后一个继续迭代
 * 如果都比他小，去掉最后一个继续迭代
 * 如果能拆分2个，则每个都需要进行检测。
 *
 */
public class SolutionJZ23 {

    public static void main(String[] args) {
        int[] ints = {4,6,12,8,16,14,10};
        boolean res = VerifySquenceOfBST(ints);
        System.out.println(res);
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 遍历所有
     *
     * @return
     */
    private static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start ==end) {
            return true;
        }
        int middle = findMiddle(sequence, start, end);
        if (middle == end) {//都比最后一个小
           return VerifySquenceOfBST(sequence, start, end - 1);
        } else if (middle == start) {//第一个就比最后一个大
            for (int i = start; i <= end; i++) {
                if (sequence[i] < sequence[end]) {
                    return false;
                }
            }
            return VerifySquenceOfBST(sequence, start, end - 1);
        } else {
            for(int i=middle;i<end;i++){
                if(sequence[i]<sequence[end]){
                    return false;
                }
            }
            return VerifySquenceOfBST(sequence, start, middle-1) && VerifySquenceOfBST(sequence, middle, end-1);
        }
    }

    private static int findMiddle(int[] sequence, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (sequence[i] > sequence[end]) {
                return i;
            }
        }
        return end;
    }

}
