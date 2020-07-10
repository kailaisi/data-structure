package datalearning.unionfind;

/**
 * 描述：基于树实现的。这里当合并的时候，让A的根节点，指向B的根节点。从而最后判断A和B是否处于连接的时候，直接判断其根节点是否相同
 * <p/>作者：wu
 * <br/>创建时间：2020/7/10 8:52
 */
class QuickUnion implements UF {
    //数组，数组的值为父节点的下标。
    private int[] parent;

    public QuickUnion(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    @Override
    public void connect(int p, int q) {
        int root = findRoot(p);
        int root1 = findRoot(q);
        parent[root] = root1;
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
        while (parent[p] == p) {
            p = parent[p];
        }
        return p;
    }
}
