package com.yst.generic_class;

// 泛型类 默认为 Object 类型
public class MyList1<E> {
    private Object[] arr = new Object[20];
    private int index;

    public boolean add(E e) {
        arr[index++] = e;
        return true;
    }

    public E get(int index) {
        return (E) arr[index];
    }
}
