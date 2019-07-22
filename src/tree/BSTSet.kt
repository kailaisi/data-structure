package tree

import interf.Set
import kotlin.random.Random

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 8:56
 */
class BSTSet<E : Comparable<E>> : Set<E> {
    var bst = BST<E>()
    override fun add(e: E) = bst.add(e)


    override fun remove(e: E) = bst.remove(e)


    override fun getSize(): Int = bst.size()


    override fun contains(e: E): Boolean = bst.contains(e)

    override fun isEmpty() = bst.isEmpty()

}

fun main() {
    val bst = BSTSet<Int>()
    for (i in 0..20) {
        var e = Random.nextInt(50)
        print("$e ->")
        bst.add(e)
    }
    println()
    for (i in 0..5) {
        var e = Random.nextInt(20)
        print("$e ->")
        bst.remove(e)
    }
    println()
}