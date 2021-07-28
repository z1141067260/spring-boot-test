package com.boot.test.tree;

import java.util.Collection;

/**
 * @author WangW
 * @date 2020/11/25 9:24
 * @description 树的接口类
 */
public interface Tree<E> extends Collection<E> {


    @Override
    boolean add(E e);



    E get(int index);


    E set(int index, E element);

}
