#排序算法
排序算法无处不在，在实际的生活中，按照身高排序，字母排序，成绩排序，MVP排序等等。

排序看似简单，但是背后却隐藏着多种多样的算法和思想。

排序算法：
#### 时间复杂度为O(n^2)

* 冒泡排序
* 选择排序
* 插入排序
* 希尔排序
#### 时间复杂度为O(nlogn)的排序算法
* 快速排序
* 归并排序
* 堆排序
#### 时间复杂度为线性的的排序算法
* 计数排序
* 桶排序
* 基数排序
#### 鸡尾酒算法
* 能够在特定条件下，减少排序的回合数。
* 代码量增加了1倍
* 大部分元素已经有序的情况下能够更好地发挥优势
#### 快速排序
快速排序思路：
找一个基准点，然后将比基准点小的放到左边，比基准点大的放到右边。
然后将左边的继续按照上面的逻辑进行迭代处理，直到所有的处理都完成。
#### 堆排序
堆排序是运用了最大堆，最小堆的相关原理来实现排序的功能。
 先通过构建最大堆，然后通过将顶点的位置放到末尾，然后调整二叉堆，将次一个大的节点放到堆顶。循环往复，从而调整数据
 
#### 计数排序
计数排序其实是对数据进行一次统计，统计每个数字的出现次数。然后根据统计的次数数据来进行排序
局限性：
   * 对于范围较大的数据不适用，比较占用空间。
   * 只适合于整数（字符也可以）的数据
   
