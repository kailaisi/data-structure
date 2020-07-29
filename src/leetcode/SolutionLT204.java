package leetcode;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
class SolutionLT204 {
    //todo
    public static void main(String[] args) {
        int primes = new SolutionLT204().countPrimes(10);
        System.out.println(primes);
    }

    public int countPrimes(int n) {
        boolean[] booleans = new boolean[n];
        Arrays.fill(booleans, true);
        for(int i=2;i*i<n;i++){
            if(isPrimes(i)){
                for(int j=i*i;j<n;j+=i){
                    booleans[j]=false;
                }
            }

        }
        int count=0;
        for(int i=2;i<n;i+=1){
            if(booleans[i]){
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return  false;
            }
        }
        return true;
    }
}