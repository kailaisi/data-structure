package leetcode;

import java.util.Arrays;

/**
 * 948. 令牌放置
 * 你的初始 能量 为 P，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
 * 令牌可能的两种使用方法如下：
 * 如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。
 * 如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。
 * 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。
 * 在使用任意数量的令牌后，返回我们可以得到的最大 分数 。
 * 示例 1：
 * 输入：tokens = [100], P = 50
 * 输出：0
 * 解释：无法使用唯一的令牌，因为能量和分数都太少了。
 * 示例 2：
 * 输入：tokens = [100,200], P = 150
 * 输出：1
 * 解释：令牌 0 正面朝上，能量变为 50，分数变为 1 。不必使用令牌 1 ，因为你无法使用它来提高分数。
 * 示例 3：
 * 输入：tokens = [100,200,300,400], P = 200
 * 输出：2
 * 解释：按下面顺序使用令牌可以得到 2 分：
 * 1. 令牌 0 正面朝上，能量变为 100 ，分数变为 1
 * 2. 令牌 3 正面朝下，能量变为 500 ，分数变为 0
 * 3. 令牌 1 正面朝上，能量变为 300 ，分数变为 1
 * 4. 令牌 2 正面朝上，能量变为 0 ，分数变为 2
 * 提示：
 * 0 <= tokens.length <= 1000
 * 0 <= tokens[i], P < 104
 * 解题思路：贪心算法。对于该题，我们为了得分。肯定是需要将需要能量小的点翻正来得分，然后将能量大的翻反来获取能量。
 * 并且只要能量能够将令牌翻正，那就先翻正，然后能量不够再考虑翻反来获取分数。
 * 但是这里有个条件，要保证我获取到能量之后，能够继续得分 ，否则的话就没有必要丢分了。所以这里需要记录一下上次是得分还是丢分的情况。
 * 另一个需要注意的情况是：如果我们现在手里的分数是0，那么我们是没有办法去丢分的。
 * 时间复杂度：O（n），这里是需要排序的，我们采用了Arrays的排序方式，另一个，需要对数据进行遍历比较分数然后做处理，考虑一直能够得分的情况，最坏的情况下是遍历所有数据，=
 * 空间复杂度：O（n）
 */
class SolutionLT948 {
    public static void main(String[] args) {
        SolutionLT948 lt = new SolutionLT948();
        System.out.println(lt.bagOfTokensScore(new int[]{100}, 50));//0
        System.out.println(lt.bagOfTokensScore(new int[]{100, 200}, 150));//1
        System.out.println(lt.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));//2
        System.out.println(lt.bagOfTokensScore(new int[]{71, 55, 82}, 54));//0
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        //先进行一次排序
        Arrays.sort(tokens);
        int start = 0;
        int end = tokens.length - 1;
        int score = 0;
        //用来记录上次是否是得分
        boolean getScore = true;
        while (start <= end) {
            int token = tokens[start];
            if (P >= token) {//可以得分的情况
                getScore = true;
                score++;
                P = P - token;
                start++;
            } else if (P < token && score > 0) {//无法得分的情况，这时候翻牌子,前提是我们现在手里有分数
                if (getScore) {//上次是得分，现在可以丢分了。
                    getScore = false;
                    score--;
                    P += tokens[end];
                    end--;
                } else {//如果刚才已经是丢分了，那么再丢分就不合适了
                    break;
                }
            } else {
                break;
            }
        }
        if (!getScore) {//最后一次是丢分，这时候是没必要的，将丢失的分加上来
            score++;
        }
        return score;
    }
}