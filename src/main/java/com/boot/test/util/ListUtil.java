package com.boot.test.util;

import com.boot.test.alipay.request.open.QrcodeRequest;
import com.boot.test.alipay.request.system.OauthRequest;
import com.boot.test.model.userBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static List<userBean> getUserBeanList(){
        List<userBean> list = new ArrayList<>();
        list.add(new userBean(1, "张三", "20"));
        list.add(new userBean(2, "李四", "21"));
        list.add(new userBean(3, "王五", "22"));
        list.add(new userBean(4, "神六", "23"));
        return list;
    }

    public static List<Map<String, Object>> getHashMapList(){
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(MapUtil.getMap(1, "张三", "20"));
        list.add(MapUtil.getMap(2, "李四", "21"));
        list.add(MapUtil.getMap(3, "王五", "22"));
        list.add(MapUtil.getMap(4, "神六", "23"));
        return list;
    }

    public static void main(String[] args) {
        OauthRequest oauthRequest =new OauthRequest();
        oauthRequest.getToken("sdfdf");
    }
}
