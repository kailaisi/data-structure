package leetcode;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * 解题思路：如果i位置有花的话，那么肯定之后的三个位置都没有花，才能栽种一个。否则都不能种花
 * 如果数组第一个位置没有花，那么只要第二个位置没有花即可。不需要判断后面的位置信息
 */
class SolutionLT605 {
    public static void main(String[] args) {
        SolutionLT605 lt53 = new SolutionLT605();
        System.out.println(lt53.canPlaceFlowers(new int[]{1,0,0,0,1},1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {//不需要种花，直接返回true
            return true;
        }
        int length = flowerbed.length;
        if (length == 1) {//只有一个位置，那么最多种一个
            return flowerbed[0] == 0 && n == 1;
        }
        int i = 0;
        int count = 0;
        while (i < length) {
            //如果某个位置没有花，那么左右都没有花，就可以种。如果是起始位置或者末尾位置，则只需要考虑一侧即可
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i]=1;
                count++;
            }
            if(count>=n){
                return true;
            }
            i++;
        }
        return false;
    }
}