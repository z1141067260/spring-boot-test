package java8Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : WangW
 * @Date : 2020/10/20 14:11
 * @description : 体验java8 Lambda表达式+StreamAPI
 */
public class StreamAPI_Test {

    /**
     * Stream是Java8的一大亮点，是对容器对象功能的增强，它专注于对容器对象进行各种非常便利、高效的 聚合操作（aggregate operation）或者大批量数据操作。
     * Stream API借助于同样新出现的Lambda表达式，极大的提高编程效率和程序可读性。
     * 同时，它提供串行和并行两种模式进行汇聚操作，并发模式能够充分利用多核处理器的优势，使用fork/join并行方式来拆分任务和加速处理过程。
     * 所以说，Java8中首次出现的 java.util.stream是一个函数式语言+多核时代综合影响的产物。
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> semester = getIntegerList();
//        semester.stream().filter(s -> s.getColor() == RED).mapToInt(s -> s.getWeight()).sum();

    }




    private static List<Integer> getIntegerList(){
        List<Integer> stringCollection = new ArrayList<>();
        stringCollection.add(1);
        stringCollection.add(2);
        stringCollection.add(3);
        stringCollection.add(4);
        stringCollection.add(5);
        stringCollection.add(6);
        stringCollection.add(7);
        stringCollection.add(8);
        return stringCollection;
    }
}
