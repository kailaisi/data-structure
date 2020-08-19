package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 */
public class SolutionLT989 {
    public static void main(String[] args) {
        SolutionLT989 lt1078 = new SolutionLT989();
        System.out.println(lt1078.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }

    private List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        int cur=K;
        ArrayList<Integer> list = new ArrayList<>();
        int i=length;
        while (--i>=0 ||cur>0){
            if(i>=0){
                cur+=A[i];//K加上最后一个数字
            }
            list.add(cur%10);//和的最后一位记录
            cur/=10;//刨除个位数进行计算。该逻辑其实和将K变为数组，然后逐位想➕的道理是一样的
        }
        Collections.reverse(list);
        return list;
    }
}