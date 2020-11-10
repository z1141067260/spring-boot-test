package com.boot.test.stream;

import com.boot.test.util.ListUtil;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author : WangW
 * @Date : 2020/10/20 16:26
 * @description :Terminal
 */
public class stream_5 {

    //forEach末端实例1
    public void forEach(){
        Stream.of("one", "two", "three", "four")
                .filter(n -> n.length() >3)
                .forEach(n -> System.out.print(n));
    }
    //总结：forEach属于terminal操作，执行后Stream的元素已经被消费了。但一般认为，forEach 和常规 for 循环的差异不涉及到性能，它们仅仅是函数式风格与传统 Java 风格的差别。


    /**
     * findFirst末端实例1
     *
     * 这里比较重点的是它的返回值类型：Optional。
     * 这也是一个模仿 Scala 语言中的概念，作为一个容器，它可能含有某值，或者不包含。使用它的目的是尽可能避免 NullPointerException。
     */
    public Optional<Integer> findFirst(){
        return ListUtil.getIntList().stream().findFirst();
    }


    /**
     * reduce末端实例1
     */
    public void reduce(){
        String concat = Stream.of("A", "B", "C", "D").
                reduce("",String::concat);

        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0)
                .reduce(Double.MAX_VALUE, Double::max);

        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);

        concat = Stream.of("a", "b", "c", "d", "e", "f")
                .filter(x -> x.compareTo("z") > 0)
                .reduce("", String::concat);
    }
}
