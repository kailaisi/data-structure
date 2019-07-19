package interf;

/**
 * 描述：栈
 * <p/>作者：wu
 * <br/>创建时间：2019/7/17 13:13
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
