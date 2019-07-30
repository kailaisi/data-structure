package test

import tree.AVLMap
import tree.BSTMap
import interf.Map
import link.LinkedListMap
import tree.RBTree
import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/26 17:54
 */
object MapMain{
    fun testMap(map: Map<String,Int>,filename:String): Double {
        val list = Utils.readFile(filename)
        Collections.sort(list)
        var start = System.nanoTime()
        list.forEach {
            if (map.contains(it)) {
                map.set(it, 1.minus(map.get(it) ?: 0))
            } else {
                map.add(it, 1)
            }
        }
        list.forEach {
            map.contains(it)
        }
        var end = System.nanoTime()
        return (end - start) / 1000000000.0
    }
}

fun main() {
    var map = BSTMap<String, Int>()
    var filename = "F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt"
    println(MapMain.testMap(map, filename))

    var avlMap = AVLMap<String, Int>()
    println(MapMain.testMap(avlMap, filename))

    var listMap = LinkedListMap<String, Int>()
    println(MapMain.testMap(listMap,filename))

    var rbTree = RBTree<String, Int>()
    println(MapMain.testMap(rbTree,filename))
}