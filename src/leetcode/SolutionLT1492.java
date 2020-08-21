package leetcode;

/**
 *
 */
class SolutionLT1492 {
    public static void main(String[] args) {
        SolutionLT1492 lt167 = new SolutionLT1492();
        int[] numbers = new int[]{1,2,3,4};
        int b = lt167.kthFactor(2, 2);
        System.out.println(b);
    }

    public int kthFactor(int n, int k) {
        for(int i=1;i<n/2+1 && i!=n;i++){
            if (n%i==0){
                k-=1;
                if(k==0){
                    return i;
                }
            }
        }
        if(k==1){
            return n;
        }
        return -1;
    }
}