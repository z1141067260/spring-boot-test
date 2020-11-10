package com.boot.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : WangW
 * @Date : 2020/10/20 15:17
 * @description : 流转换为其他数据结构
 */
public class stream_3 {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("a", "b", "c");
        //1、Array
        String[] strArray1 = stream1.toArray(String[]::new);

        Stream<String> stream2 = Stream.of("a", "b", "c");
        Stream<String> stream3 = Stream.of("a", "b", "c");
        //2、Collection
        List<String> list1 = stream2.collect(Collectors.toList());


        List<String> list2 = stream3.collect(Collectors.toCollection(ArrayList::new));

        Stream<String> stream4 = Stream.of("a", "b", "c");
        Stream<String> stream5 = Stream.of("a", "b", "c");

        Set set1 = stream4.collect(Collectors.toSet());
        Stack stack1 = stream5.collect(Collectors.toCollection(Stack::new));

        Stream<String> stream6 = Stream.of("a", "b", "c");
        //3、String
        String str = stream6.collect(Collectors.joining());
        System.out.println(str);

        //总结，上述一个流只能使用一次，可以支持Array-Collection-String之间的转换
    }
}
