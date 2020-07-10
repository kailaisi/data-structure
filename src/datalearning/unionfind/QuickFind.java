package datalearning.unionfind;

/**
 * 描述：快速查询，最简单的并查集，基于数组的实现。
 * <p/>作者：wu
 * <br/>创建时间：2020/7/9 9:24
 */
class QuickFind implements UF {
    //用来将传入的数据映射出来对应的节点id
    private int[] ids;

    public QuickFind(int size) {
        ids=new int[size];
        for (int i = 0; i < size; i++) {
            ids[i]=i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {//O(1)级别
        return find(p)==find(q);
    }

    @Override
    public void connect(int p, int q) {//O(n)级别
        int pID = find(p);
        int qID = find(q);
        if(pID==qID){
            return;
        }
        for(int i=0;i<ids.length;i++){
            if(ids[i]==qID){
                ids[i]=pID;
            }
        }
    }

    //查找元素p所对应的集合编号
    private int find(int p){
        if(p<0 ||p>=ids.length){
            throw new IllegalArgumentException("数组越界");
        }
        return ids[p];
    }

    @Override
    public int getSize() {
        return ids.length;
    }
}
