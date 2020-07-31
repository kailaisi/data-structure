package leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 * 解题思路：最大公约数
 * 这里如果能够进行分组，肯定对应的数量是有公约数的。
 * 首先根据value值进行一次分组。然后看对应的数量能否组成一个最大公约数>1的数据
 *
 *  最大公约数有多种算法。可以自行百度查找。
 */
class SolutionLT914 {
    public static void main(String[] args) {
        int[] ints = {1,1,1,2,2,2,3,3};
        boolean b = new SolutionLT914().hasGroupsSizeX(ints);
        System.out.println(b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<deck.length;i++){
            int key = deck[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        Set<Integer> set = map.keySet();
        int gcd=map.get(deck[0]);
        //这里遍历，获取最大公约数
        for (Integer key : set) {
            if(map.get(key)==1){
                return false;
            }
            //这里获取一个最大公约数
            gcd=getGcd(gcd,map.get(key));
            if(gcd==1){
                return false;
            }
        }
        return true;
    }

    private int getGcd(int a, Integer b) {
        if(a%b==0){
            return b;
        }
        return getGcd(b,a%b);
    }
}