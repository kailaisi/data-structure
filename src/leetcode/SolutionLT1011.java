package leetcode;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
class SolutionLT1011 {
    public static void main(String[] args) {
        SolutionLT1011 lt = new SolutionLT1011();
       // System.out.println(lt.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
       // System.out.println(lt.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(lt.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public int shipWithinDays(int[] weights, int D) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canWight(weights, D, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * 称重为k的船，能否在D次运输完成
     */
    public boolean canWight(int[] weight, int D, int k) {
        int sum = 0;
        int total = 0;
        for (int i = 0; i < weight.length; i++) {
            if(weight[i]>k){//如果某个数据大小超过了称重的限制，直接返回false
                return false;
            }
            if (sum + weight[i] > k) {
                total++;
                if (total > D) {
                    return false;
                }
                sum = 0;
            }
            sum+=weight[i];
        }
        if(sum>0){//如果剩余的还有重量，那么总数需要+1；
            total++;
        }
        return D >= total;
    }

}