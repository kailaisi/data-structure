package test;

import maxheap.MaxHeap;

import java.util.Random;
import java.util.concurrent.TransferQueue;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2019/7/23 11:00
 */
class HeapMain {

    private static double testHeap(Integer[] testData,boolean isHeapify){
        long start = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap=new MaxHeap<>(testData);
        }else{
            maxHeap=new MaxHeap<>();
            for(int num:testData){
                maxHeap.add(num);
            }
        }
        int[] arr = new int[testData.length];
        for(int i=0;i<testData.length;i++){
            arr[i]=maxHeap.extratMax();
        }
        for(int i=0;i<testData.length-1;i++){
            if(arr[i]<arr[i+1]){
                throw new IllegalArgumentException("数据出现错误");
            }
        }
        long end = System.nanoTime();
        return (end-start)/1000000000.0;
    }
    public static void main(String[] args) {
        int n=1000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i=0;i<n;i++){
            testData[i]=random.nextInt(Integer.MAX_VALUE);
        }
        double t1=testHeap(testData,false);
        double t2=testHeap(testData, true);
        System.out.println("without heap:"+t1);
        System.out.println("with heap:"+t2);
    }
}
