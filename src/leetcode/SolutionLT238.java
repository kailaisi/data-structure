package leetcode;

/**
 *
 */
class SolutionLT238 {
    public static void main(String[] args) {
        SolutionLT238 lt167 = new SolutionLT238();
        int[] numbers = new int[]{1,2,3,4};
        int b = lt167.findKthPositive(numbers, 2);
        System.out.println(b);
    }

    public int findKthPositive(int[] arr, int k) {
        int length = arr.length;
        for(int i = 0; i< length-1;i++){
            int i1=0;
            if(i==0){
                i1=arr[0]-1;
            }
            else {
                i1= arr[i + 1] - arr[i] - 1;
            }
            if(k>i1){
                k-=i1;
            }else{
                return arr[i]+k;
            }
        }
        return arr[length-1]+k;
    }
}