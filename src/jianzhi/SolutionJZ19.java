package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 知识点：数组
 * 解题思路：对于数组，相当于一圈一圈的循环
 *          先从左到右，再往下，再往左，再往上。
 *          注意：如果是奇数行的，不会有往左。
 *          如果是奇数列的，不再有往上。
 */
public class SolutionJZ19 {
    public static void main(String[] args) {
        int[] i1 = {1, 2};
        int[] i2 = {3, 4};
        int[] i3 = {9, 10, 11, 12};
        int[] i4 = {13, 14, 15, 16};
        int[][] i = {i1, i2};
        ArrayList<Integer> list = printMatrix(i);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int height = matrix.length;
        if (height == 0) {
            return list;
        }
        int width = matrix[0].length;
        int min = Math.min(width, height);
        int max = (int) (Math.round(min / 2.0));
        for (int index = 0; index < max; index++) {
            int right = width - index, bottom = height - index;
            for (int i = index; i < right; i++) {//向右
                list.add(matrix[index][i]);
            }
            for (int i = index + 1; i < bottom; i++) {//向下
                list.add(matrix[i][right - 1]);
            }
            if (2 * (index + 1) <= height) {
                for (int i = right - 2; i > index; i--) {//向左
                    list.add(matrix[bottom - 1][i]);
                }
            }
            if (2 * (index + 1) <= width) {
                for (int i = bottom - 1; i > index; i--) {//向上
                    list.add(matrix[i][index]);
                }
            }
        }
        return list;
    }


}
