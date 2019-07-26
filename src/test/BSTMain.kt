package test

import Utils
import tree.AVLTree
import tree.BSTMap
import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/26 11:50
 */
fun main() {
    val list = Utils.readFile("F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt")
    Collections.sort(list)
    var start = System.nanoTime()
    val bst = BSTMap<String, Int>()
    list.forEach {
        if (bst.contains(it)) {
            bst.set(it, 1.minus(bst.get(it) ?: 0))
        } else {
            bst.add(it, 1)
        }
    }
    list.forEach {
        bst.contains(it)
    }
    var end = System.nanoTime()
    println("BST:${(end - start) / 1000000000.0}s")
    start = System.nanoTime()
    val avlTree = AVLTree<String, Int>()
    list.forEach {
        if (avlTree.contains(it)) {
            avlTree.set(it, 1.minus(avlTree.get(it) ?: 0))
        } else {
            avlTree.add(it, 1)
        }
    }
    list.forEach {
        avlTree.contains(it)
    }
    end = System.nanoTime()
    println("AVL:${(end - start) / 1000000000.0}s")
    print(end - start)
}