package datalearning.test

import datalearning.avl.AVLTree
import datalearning.tree.BSTMap
import datalearning.rb.RBTree

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/26 11:50
 */
fun main() {
    val list = Utils.readFile("F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt")
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

    start = System.nanoTime()
    val rbTree = RBTree<String, Int>()
    list.forEach {
        if (rbTree.contains(it)) {
            rbTree.set(it, 1.minus(rbTree.get(it) ?: 0))
        } else {
            rbTree.add(it, 1)
        }
    }
    list.forEach {
        rbTree.contains(it)
    }
    end = System.nanoTime()
    println("RBTree:${(end - start) / 1000000000.0}s")
}