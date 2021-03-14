package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 * 注意：
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 * 示例 1：
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 * 提示：
 * <p>
 * 1 <= commands.length <= 10^4
 * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
 * 0 <= obstacles.length <= 10^4
 * -3 * 10^4 <= xi, yi <= 3 * 10^4
 * 答案保证小于 2^31
 * 解题思路： 实现的逻辑：
 * 1。取当前机器人的方向，开始移动
 * 2.每移动一次，判断是否有障碍物，如果存在，则结束当前路径的移动
 * 3.若没有障碍物，则更新的当前位置，然后与最远距离作比较，然后保存最大值。
 * 4.移动完毕，返回保存的最远距离
 * 代码逻辑：1.首先我们需要有个一值来判断我们当前的方向，比如说用direcet：1，2，3，4。分别表示东南西北。
 * 2.每移动一步判断障碍物，为了可以快速查找，可以将所有的点在hashmap中去保存（这里要考虑两个节点的话，两个节点都是障碍物）
 * 3.遇到障碍就停止，然后更新距离
 * 4.返回保存的最远距离结果
 * <p>
 * <p>
 * <p>
 * 时间复杂度：
 * 空间复杂度：
 */
class SolutionLT874 {
    public static void main(String[] args) {
        SolutionLT874 lt = new SolutionLT874();
        System.out.println(lt.robotSim(new int[]{4,-1,3},new int[][]{}));//25
        System.out.println(lt.robotSim(new int[]{4,-1,4,-2,4},new int[][]{{2,4}}));//65
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;//最远距离结果
        int direction = 0;//方向  0：北，1：东  2：南   3：西
        int[] direY=new int[]{1,0,-1,0};
        int[] direX=new int[]{0,1,0,-1};
        //当前位置节点
        int x = 0;//节点
        int y = 0;
        //保存节点信息
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if(command==-2){//左转，需要将direction-1,然后为了防止<0,我们按照+3/4来计算结果
                direction=(direction+3)%4;
            }else if (command==-1){//右转
                direction=(direction+1)%4;
            }else{
                int next_x=0;
                int next_y=0;
                for (int i=0;i<command;i++){
                     next_x=x+direX[direction];
                     next_y=y+direY[direction];
                     if (set.contains(next_x+","+next_y)){
                         break;
                     }
                     x=next_x;
                     y=next_y;
                     res=Math.max(res,x*x+y*y);
                }
            }
        }
        return res;
    }
}
