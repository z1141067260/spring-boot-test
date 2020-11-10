package com.boot.test.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author : WangW
 * @Date : 2020/10/20 15:02
 * @description : 构造流的几种常见方法
 */
public class stream_1 {
    /**
     * Stream是Java8的一大亮点，是对容器对象功能的增强，它专注于对容器对象进行各种非常便利、高效的 聚合操作（aggregate operation）或者大批量数据操作。
     * Stream API借助于同样新出现的Lambda表达式，极大的提高编程效率和程序可读性。
     * 同时，它提供串行和并行两种模式进行汇聚操作，并发模式能够充分利用多核处理器的优势，使用fork/join并行方式来拆分任务和加速处理过程。
     * 所以说，Java8中首次出现的 java.util.stream是一个函数式语言+多核时代综合影响的产物。
     * @param args
     */
    public static void main(String[] args) {
        //1、Individual values
        Stream stream = Stream.of("a", "b", "c");
        //2、Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        //3、Collections  Map并不能stream化
        List<String> list = Arrays.asList(strArray);
        Set<String> set = new HashSet<>();
        stream = set.stream();
        stream = list.stream();

        //总结：以上举例stream实例化过程，Arrays转换stream过程，Collections转换stream过程，后两者不能为null
    }
}
