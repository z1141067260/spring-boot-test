package com.boot.test.stream;

import com.boot.test.util.ListUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : WangW
 * @Date : 2020/10/20 15:44
 * @description : Intermediate
 */
public class stream_4 {

    //Map中间端实例1 转换大写
    public List<String> mapToUpperCase(){
        List<String> output = ListUtil.getStrList().stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        return output;
    }
    //Map中间端实例2 平方数
    public List<Integer> mapSquare(){
        List<Integer> squareNums = ListUtil.getIntList().stream().
                map(n -> n * n).
                collect(Collectors.toList());
        return squareNums;
    }


    //flatMap中间端实例1 一对多
    public List<Integer> flatMap(){
        Stream<List<Integer>> inputStream = Stream.of(
                ListUtil.getIntList(),
                ListUtil.getIntList(),
                ListUtil.getIntList());
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        List<Integer> childList = outputStream.collect(Collectors.toList());
        return childList;
    }


    //filter中间端实例1  留下偶数
    public Integer[] filterEvens(){
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).
                filter(n -> n%2 == 0).
                toArray(Integer[]::new);
        return evens;
    }

    //filter中间端实例2  把单词挑出来
    public List<String> filterAndFlatMap(){
        List<String> output = Stream.of("abc", "bcd", "bcd").
                flatMap(line -> Stream.of(line.split("abc"))).
                filter(word -> word.length() >0).
                collect(Collectors.toList());
        return output;
    }

    //peek中间端实例1
    public void peek(){
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() >3)
                .peek(e -> System.out.print(e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println(e))
                .collect(Collectors.toList());
    }


    public List<Integer> skipAndLimit(){
        return ListUtil.getIntList().stream().limit(4).skip(2).collect(Collectors.toList());
    }


}
