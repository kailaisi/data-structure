package datalearning.unionfind;

/**
 * 描述：并查集接口。不考虑增加和删除节点的操作，也就是集合是固定的
 * <p/>作者：wu
 * <br/>创建时间：2020/7/9 9:24
 */
interface UF {
    boolean isConnected(int p,int q);//元素是谁无所谓，将元素和数组的索引做映射

    /**
     * 连接p和q代表的数据
     * @param p
     * @param q
     */
    void connect(int p,int q);

    int getSize();
}
