package datalearning.link
import datalearning.interf.Set
/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 9:33
 */
class LinkedListSet<E>: Set<E> {
    var linkedList= LinkedList<E>()

    override fun add(e: E) {
        if(!linkedList.contains(e)){
            linkedList.addFirst(e)
        }
    }

    override fun remove(e: E) {
        linkedList.removeElement(e)
    }

    override fun getSize(): Int =linkedList.size

    override fun contains(e: E): Boolean =linkedList.contains(e)

    override fun isEmpty(): Boolean =linkedList.isEmpty()

}

fun main() {
    var set = LinkedListSet<Int>()
    set.add(1)
    set.remove(1)
    println(set.getSize())
}