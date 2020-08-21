package leetcode;

import java.util.Arrays;

/**
 *
 */
class SolutionLT1502 {
    public static void main(String[] args) {
        SolutionLT1502 lt167 = new SolutionLT1502();
        int[] numbers = new int[]{3,5,1};
        boolean b = lt167.canMakeArithmeticProgression(numbers);
        System.out.println(b);
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        if(length<3){
            return true;
        }
        int a=arr[1]-arr[0];
        for(int i = 0; i< length-1;i++){
            if((arr[i+1]-arr[i])!=a){
                return false;
            }
        }
        return true;
    }
}