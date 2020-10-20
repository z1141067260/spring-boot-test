package java8Lambda.stream;

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
