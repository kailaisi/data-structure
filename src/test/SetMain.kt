package test

import Utils
import datalearning.interf.Set
import datalearning.link.LinkedListSet
import datalearning.tree.AVLSet
import datalearning.tree.BSTSet

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/26 18:39
 */
fun main() {
    var filename = "F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt"
    var bstSet = BSTSet<String>()
    println("BSTSet time:${testSet(bstSet, filename)}")
    println()
    var linkedListSet = LinkedListSet<String>()
    println("linkedListSet time:${testSet(linkedListSet, filename)}")
    println()
    var avlSet = AVLSet<String>()
    println("BSTSet time:${testSet(avlSet, filename)}")

}

fun testSet(set: Set<String>, fileName: String): Double {
    val list = Utils.readFile(fileName)
    var start = System.nanoTime()

    println("Total words:${list.size}")

    list.forEach {
        set.add(it)
    }
    println("Total different words:${set.getSize()}")
    var end = System.nanoTime()
    return (end - start) / 1000000000.0
}