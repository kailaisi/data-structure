package datalearning.unionfind;

/**
 * 描述：基于树实现的。路径压缩
 * 基于QuickUnion4的基础上进行优化。
 * 优化方向：每次查找的时候进行优化，将节点直接指向根节点
 * <p/>作者：wu
 * <br/>创建时间：2020/7/10 8:52
 */
class QuickUnion5 implements UF {
    //数组，数组的值为父节点的下标。
    private int[] parent;

    //用于保存i为根的结合中元素的个数
    private int[] rank;

    public QuickUnion5(int size) {
        parent = new int[size];
        rank=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    @Override
    public void connect(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
            //这里qRoot的高度并没有变化，所以不需要变化
        } else if(rank[pRoot]>rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{
            parent[qRoot]=pRoot;
            rank[pRoot]++;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找p所对应的根节点
     * 时间复杂度为h，h为树的高度
     */
    private int findRoot(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("数组越界");
        }
        if (parent[p] != p) {
            //这里是相对于4进行优化的地方，通过这种方式，可以实现将多个节点都连接到根节点
            parent[p]=findRoot(parent[p]);
        }
        return p;
    }
}
