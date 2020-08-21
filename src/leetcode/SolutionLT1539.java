package leetcode;

/**
 *
 */
class SolutionLT1539 {
    public static void main(String[] args) {
        SolutionLT1539 lt167 = new SolutionLT1539();
        int[] numbers = new int[]{6};
        int b = lt167.findKthPositive(numbers, 5);
        System.out.println(b);
    }

    public int findKthPositive(int[] arr, int k) {
        int length = arr.length;
        int i1=0;
        for (int i = 0; i < length; i++) {
            if(i==0){
                i1=arr[i]-1;
            }else {
                i1 = arr[i] - arr[i-1] - 1;
            }
            if (k > i1) {
                k -= i1;
            } else {
                if(i==0){
                    return k;
                }else {
                    return arr[i-1] + k;
                }
            }
        }
        return arr[length - 1] + k;
    }
}