package tree
import interf.Set
/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/26 18:48
 */
class AVLSet<E:Comparable<E>>:Set<E>{
    private var set = AVLTree<E, Any>()
    override fun add(e: E) = set.add(e, Any())

    override fun remove(e: E) {
        set.remove(e)
    }

    override fun getSize(): Int = set.getSize()

    override fun contains(e: E): Boolean = set.contains(e)

    override fun isEmpty(): Boolean = set.isEmpty()
}