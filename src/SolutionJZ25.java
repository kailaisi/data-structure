/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 知识点：链表
 * 解题思路：未完成
 */
public class SolutionJZ25 {
    public static void main(String[] args) {
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null){
            return null;
        }
        RandomListNode node = new RandomListNode(pHead.label);
        node.next=Clone(pHead.next);
        node.random=Clone(pHead.random);
        return node;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
