package datalearning.unionfind;

/**
 * 描述：快速查询
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
    public boolean isConnected(int p, int q) {
        return false;
    }

    @Override
    public void connect(int p, int q) {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
