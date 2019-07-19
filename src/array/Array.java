package array;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2019/7/16 15:36
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("兄弟，超出现在的范围了");
        }
        if (size == data.length) {
            resize(size * 2);
        }
        for (int i = size; i > index; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 进行空间的整理
     *
     * @param size
     */
    private void resize(int newSize) {
        E[] newData = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("兄弟，超出现在的范围了");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("兄弟，超出现在的范围了");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (E i : data) {
            if (i.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("兄弟，超出现在的范围了");
        }
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
       return remove(0);
    }

    public E removeLast() {
      return remove(size - 1);
    }

    public void removeElement(E e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Length:").append(data.length).append(";Size:").append(size).append(";Data:");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
        }
        return builder.toString();
    }

    public E getLast() {
        return get(size-1);
    }
}
