package com.boot.test.stream;


import com.boot.test.util.ListUtil;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author : WangW
 * @Date : 2020/10/20 17:21
 * @description :Optional的使用案例
 */
public class optionalStream {

    public static void main(String[] args) {
        String strA = "abcd" , strB = null;

        Optional.ofNullable(strA).ifPresent(System.out::println);
        Optional.ofNullable(strB).ifPresent(System.out::println);
        Optional<Integer> optional = Optional.ofNullable(2);
        System.out.println(optional.orElse(1));

        Stream<Integer> integers = ListUtil.getIntList().stream();
        Integer sum = integers.reduce(0, (a,b)->a+b);
        integers.reduce(0,Integer::sum);
        System.out.println(sum);
//        sum = integers.reduce(0, Integer::sum);
//        System.out.print(sum);
    }
}
