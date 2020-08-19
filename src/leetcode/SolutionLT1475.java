package leetcode;

import java.util.Arrays;

/**
 *
 */
public class SolutionLT1475 {
    public static void main(String[] args) {
        SolutionLT1475 lt1078 = new SolutionLT1475();
        System.out.println(Arrays.toString(lt1078.finalPrices(new int[]{10,1,1,6})));
    }

    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        if(length<2){
            return  prices;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i +1; j < length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}