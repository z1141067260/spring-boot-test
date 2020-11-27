package com.boot.test.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<String, Object> getMap(){
        return getMap(1, "张三", "20");
    }

    public static Map<String, Object> getMap(Integer id, String name, String age){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("age", age);
        return map;
    }
}
