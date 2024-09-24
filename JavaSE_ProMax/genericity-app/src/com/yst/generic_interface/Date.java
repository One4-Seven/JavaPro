package com.yst.generic_interface;

import java.util.ArrayList;

// 泛型接口
public interface Date <E extends Father> {
    void add(E e);
    ArrayList<E> getFromName(String name);

}
