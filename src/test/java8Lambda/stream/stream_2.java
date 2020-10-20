package java8Lambda.stream;

import java.util.stream.IntStream;

/**
 * @author : WangW
 * @Date : 2020/10/20 15:08
 * @description : 数值流的构造
 */
public class stream_2 {

    public static void main(String[] args) {
        //例1，循环遍历1-3
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        //例2，循环遍历1，3
        IntStream.range(1, 3).forEach(System.out::println);
        //例3，与例1相同
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        //总结：注意使用过程中range与rangeClosed的区别
    }
}
