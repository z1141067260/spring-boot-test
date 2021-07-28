package com.boot.test.tree;

import org.apache.commons.collections4.list.TreeList;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author WangW
 * @date 2020/11/25 9:30
 * @description 测试
 */
public class Test {

    public static void main(String[] args) {
        TreeList<Integer> i = new TreeList<>();
        i.add(0, 1);
        i.add(1,2);
        System.out.println(i.get(1));
//        ArrayList;
//        Map

    }
}
