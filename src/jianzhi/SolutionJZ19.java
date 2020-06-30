package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 知识点：数组
 * 解题思路：
 */
public class SolutionJZ19 {
    public static void main(String[] args) {
        int[] i1 = {1, 2, 3, 4};
        int[] i2 = {5,6,7,8};
        int[] i3 = {9,10,11,12};
        int[] i4 = {13,14,15,16};
        int[][] i={i1,i2,i3,i4};
        ArrayList<Integer> list = printMatrix(i);
        for (int j=0;j<list.size();j++){
            System.out.println(list.get(j));
        }
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int height = matrix.length;
        if(height ==0){
            return list;
        }
        int width = matrix[0].length;
        int min=Math.min(width,height);
        int max=(int) (Math.round(min/2.0));
        for(int index=0;index<max;index++){
            int left=index,right=width-index,bottom=height-index;
            for(int i=left;i<right;i++){
                list.add(matrix[index][i]);
            }
            for (int i=right;i<bottom;i++){
                list.add(matrix[i][right]);
            }
            for (int i=right;i<bottom;i++){
                list.add(matrix[i][right]);
            }
            for(int i=right-1;i>left;i--){
                list.add(matrix[bottom][i]);
            }
            for(int i=bottom-1;i>left;i--){
                list.add(matrix[i][left]);
            }
        }
        return  list;
    }

    /**
     *
     * @param index 层数
     */
    private void printMatrix(int[][] matrix, ArrayList list, int index,int max,int width,int height) {
        if(index>=max){
            return;
        }

    }
}
