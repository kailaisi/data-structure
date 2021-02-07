package leetcode;

import java.util.HashMap;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 * 解题思路：1.先通过循环对每一个节点进行复制，然后通过map保存复制之前和复制之后的节点关系
 *           2.第二次遍历关系，这次只处理random信息。主节点对应的random，通过map获取其复制之后的节点对应的节点信息。
 */
public class SolutionJZ25 {
    public static void main(String[] args) {
        RandomListNode A = new RandomListNode(1);
        RandomListNode B = new RandomListNode(2);
        RandomListNode C = new RandomListNode(3);
        RandomListNode D = new RandomListNode(4);
        RandomListNode E = new RandomListNode(5);
        A.next = B;
        A.random = C;
        B.next = C;
        B.random = D;
        C.next = D;
        C.random = E;
        D.next = E;
        D.random = A;
        RandomListNode node = Clone(A);
        while (node != null) {
            System.out.println(node.label);
            node = node.next;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        //创建一个头结点
        RandomListNode first = new RandomListNode(0);
        RandomListNode node = first;
        //当前指针，先遍历一遍，复制所有的节点,
        RandomListNode current = pHead;
        while (current != null) {
            RandomListNode randomListNode = new RandomListNode(current.label);
            //将节点和对应复制的节点通过map来保存
            map.put(current, randomListNode);
            node.next = randomListNode;
            node = node.next;
            current = current.next;
        }
        //第一遍循环，处理random。直接从map中取出
        current = pHead;
        RandomListNode second = first.next;
        while (current != null) {
            second.random = map.get(current.random);
            current = current.next;
            second = second.next;
        }
        return first.next;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
