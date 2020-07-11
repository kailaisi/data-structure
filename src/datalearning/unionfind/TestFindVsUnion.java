package datalearning.unionfind;

import java.util.Random;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/7/10 9:03
 */
class TestFindVsUnion {
    public static void main(String[] args) {
        int size=100000;
        int m=100000;
        QuickFind find = new QuickFind(size);
        QuickUnion union = new QuickUnion(size);
        QuickUnion2 quickUnion2 = new QuickUnion2(size);
        QuickUnion3 quickUnion3 = new QuickUnion3(size);
        QuickUnion4 quickUnion4 = new QuickUnion4(size);
       // System.out.println("QuickFind :"+testUF(find,m)+"s");
      //  System.out.println("QuickUnion :"+testUF(union,m)+"s");
        System.out.println("QuickUnion2 :"+testUF(quickUnion2,m)+"s");
        System.out.println("QuickUnion3 :"+testUF(quickUnion3,m)+"s");
        System.out.println("QuickUnion4 :"+testUF(quickUnion4,m)+"s");
    }


    private static double testUF(UF uf,int m){
        int size = uf.getSize();
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.connect(a,b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }
        long end = System.currentTimeMillis();
        return (end-start);
    }
}
