package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 * 2. getValue(int row, int col)
 *
 * 返回矩形中坐标 (row,col) 的当前值。
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
 * 输出：
 * [null,1,null,5,5,null,10,5]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
 * // 初始的 (4x3) 矩形如下：
 * // 1 2 1
 * // 4 3 4
 * // 3 2 1
 * // 1 1 1
 * subrectangleQueries.getValue(0, 2); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
 * // 此次更新后矩形变为：
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * subrectangleQueries.getValue(3, 1); // 返回 5
 * subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
 * // 此次更新后矩形变为：
 * // 5   5   5
 * // 5   5   5
 * // 5   5   5
 * // 10  10  10
 * subrectangleQueries.getValue(3, 1); // 返回 10
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * 示例 2：
 *
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * 输出：
 * [null,1,null,100,100,null,20]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // 返回 100
 * subrectangleQueries.getValue(2, 2); // 返回 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // 返回 20
 *  
 *
 * 提示：
 *
 * 最多有 500 次updateSubrectangle 和 getValue 操作。
 * 1 <= rows, cols <= 100
 * rows == rectangle.length
 * cols == rectangle[i].length
 * 0 <= row1 <= row2 < rows
 * 0 <= col1 <= col2 < cols
 * 1 <= newValue, rectangle[i][j] <= 10^9
 * 0 <= row < rows
 * 0 <= col < cols
 *
 * 题解思路：
 * 参考Android中SparseArray的思路。每次更新的时候，并不更新具体位置的数据，而是记录下来我的修改记录。
 *  在获取数据的时候，将修改记录反向查找，找到修改的范围包含了对应坐标的值则是最新值。因为之前不管该坐标修改了多少次，最后总是会覆盖
 *      因为最多只有500次的数据更新或者值的获取，因此不管是更新还是获取都是O(1)级别的。
 *      关键点在于保存修改的记录。可以创建一个新类来保存？
 *
 */
class SolutionLT1476Second {
    private int[][] angle;
    private List<History> history=new ArrayList<>();
    public static void main(String[] args) {
    }

    public SolutionLT1476Second(int[][] rectangle) {
        angle=rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        history.add(new History(row1,col1,row2,col2,newValue));
    }

    public int getValue(int row, int col) {
        int size = history.size();
        for(int i=size-1;i>=0;i--){
            History his = this.history.get(i);
            if(his.rows1<=row && his.rows2>=row  && his.cols1<=col && his.cols2>=col){
                return his.newValue;
            }
        }
        return angle[row][col];
    }

    public static class History{
        int rows1;
        int cols1;
        int rows2;
        int cols2;
        int newValue;

        public History(int rows1, int cols1, int rows2, int cols2, int newValue) {
            this.rows1 = rows1;
            this.cols1 = cols1;
            this.rows2 = rows2;
            this.cols2 = cols2;
            this.newValue = newValue;
        }
    }
}