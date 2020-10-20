package java8Lambda.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : WangW
 * @Date : 2020/10/20 15:46
 * @description : 存储各种List集合
 */
public class ListUtil {


    public static List<String> getStrList(){
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");
        strList.add("f");
        strList.add("g");
        strList.add("h");
        return strList;
    }

    public static List<Integer> getIntList(){
        List<Integer> IntList = new ArrayList<>();
        IntList.add(1);
        IntList.add(2);
        IntList.add(3);
        IntList.add(4);
        IntList.add(5);
        IntList.add(6);
        IntList.add(7);
        IntList.add(8);
        IntList.add(9);
        return IntList;
    }
}
