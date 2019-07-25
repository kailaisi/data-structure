package segmenttree

import java.util.*

/**
 *描述：线段树
 *<p/>作者：wu
 *<br/>创建时间：2019/7/24 10:13
 */
class SegmentTree<E>(array: Array<E>, var merger: Merger<E>) {
    var data: Array<E?> = Arrays.copyOf(array, array.size)

    var tree: Array<E?> = arrayOfNulls<Any>(array.size.times(4)) as Array<E?>

    init {
        buildSegmentTree(0, 0, data.size - 1)
    }

    /**
     * 创建表示[l,r]区间的线段树
     */
    private fun buildSegmentTree(treeIndex: Int, l: Int, r: Int) {
        if(treeIndex>=tree.size){
            return
        }
        if (l == r) {
            tree[treeIndex] = data[l]
            return
        }
        var leftTree = lefChild(treeIndex)
        var rightTree = rightChild(treeIndex)
        var mid = l + (r - l) / 2
        buildSegmentTree(leftTree, l, mid)
        buildSegmentTree(rightTree, mid+1, r)
        tree[treeIndex] = merger.merge(tree[leftTree]!!, tree[rightTree]!!)
    }

    fun getSize(): Int = data.size

    fun get(index: Int): E {
        if (index < 0 || index >= data.size) {
            throw IllegalArgumentException("索引越界了啊")
        }
        return data[index]!!
    }

    fun query(queryL:Int,queryR:Int): E {
        if(queryL<0||queryL>=data.size
                ||queryR<0||queryR>=data.size||queryL>queryR){
            throw IllegalArgumentException("索引不对啊。。")
        }
        return query(0,0,data.size-1,queryL,queryR)
    }

    /**
     * 在from..to之间，搜索满足在queryL到queryR区间的数据
     */
    private fun query(treeIndex: Int, from: Int, to: Int, queryL: Int, queryR: Int): E {
        if(from==queryL && to==queryR){
            return tree[treeIndex]!!
        }
        var mid=from+(to-from)/2
        var lefChild = lefChild(treeIndex)
        var rightChild = rightChild(treeIndex)
        if(queryL>=mid+1){
            return query(rightChild,mid+1,to,queryL,queryR)
        }else if(queryR<=mid){
            return query(lefChild,from,mid,queryL, queryR)
        }else{
            var left = query(lefChild, from, mid, queryL, mid)!!
            var right = query(rightChild, mid + 1, to, mid + 1, queryR)!!
            return merger.merge(left,right)
        }
    }
    fun update(index: Int, e: E) {
        if(index>=data.size){
            return
        }
        set(0,0,data.size-1,index,e)
    }

    private fun set(treeIndex: Int, from: Int, to: Int,index: Int, e: E){
        if(from==to){
            println("set tree[$treeIndex]=$e")
            tree[treeIndex]=e
            return
        }
        var mid=from+(to-from)/2
        var lefChild = lefChild(treeIndex)
        var rightChild = rightChild(treeIndex)
        if(index>=mid+1){
             set(rightChild,mid+1,to,index,e)
        }else{
            set(lefChild,from,mid,index,e)
        }
        var e1 = merger.merge(tree[lefChild]!!, tree[rightChild]!!)
        tree[treeIndex]= e1
        println("set tree[$treeIndex]=$e1")
    }
    private fun lefChild(index: Int) = index * 2 + 1

    private fun rightChild(index: Int) = index * 2 + 2
    override fun toString(): String {
        return buildString {
            tree.forEach {
                this.append("$it ")
            }
        }
    }
}

/**
 * 进行类的➕运算
 */
interface Merger<E> {
    fun merge(a: E, b: E): E
}

fun main() {
    var nums = arrayOf(-2, 0,3,-5,4)
    var tree = SegmentTree(nums, object : Merger<Int> {
        override fun merge(a: Int, b: Int): Int {
            return a.plus(b)
        }
    })
    print(tree)
    println(tree.query(0, 2))
    println(tree.query(2, 4))
    println(tree.query(0, 4))
}