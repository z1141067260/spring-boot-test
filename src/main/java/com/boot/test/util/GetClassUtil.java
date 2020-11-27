package com.boot.test.util;

import com.boot.test.anno.userIofoItf;
import com.boot.test.model.userBean;
import org.apache.catalina.User;
import org.springframework.util.ObjectUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class GetClassUtil {

    public static Object getClassListField(Object o, String UserInfoDate) {
        if (o == null) {
            return null;
        }
        String objectClassName = o.getClass().getName();
        //判断是否是list对象
        if (!objectClassName.contains(ArrayList.class.getName())) {
            System.out.println("可以处理其他对象，或抛出处理");
            return null;
        }
        List<?> objectList = (List<?>) o;
        List<Map<String, Object>> list = null;
        for (int i = 0; i < objectList.size(); i++) {
            Object arrayObject = objectList.get(i);
            Class<?> beanClass = arrayObject.getClass();
            //判断对象是Map集合还是Array对象
            if (beanClass.getName().contains(HashMap.class.getName())) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(mapToDex((HashMap<String, Object>) objectList.get(i), UserInfoDate));
            } else {
                annoArrayToDex(arrayObject, beanClass.getDeclaredFields(), UserInfoDate);
            }
        }

        if (list != null) {
            return list;
        } else {
            return objectList;
        }
    }

    //Map只是普通处理
    public static HashMap<String, Object> mapToDex(HashMap<String, Object> map, String UserInfoDate) {
        for (String key : map.keySet()) {
            if (UserInfoDate.contains(key)) {
                //加密处理
                map.put(key, getDex(key, map.get(key)));
            }
        }
        return map;
    }

    public static void annoArrayToDex(Object arrayObject, Field[] fields, String UserInfoDate) {
        for (Field field : fields) {
            userIofoItf userIofoItf = field.getAnnotation(userIofoItf.class);
            if (userIofoItf == null) {
                continue;
            }
            if (UserInfoDate.contains(userIofoItf.value())) {
                try {
                    field.setAccessible(true);
                    field.set(arrayObject, getDex(userIofoItf.value(), field.get(arrayObject)));
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //未使用注解进行对比判断
    
    public static void arrayToDex(Object arrayObject, Field[] fields, String UserInfoDate) {
        for (Field field : fields) {
            if (UserInfoDate.contains(field.getName())) {
                try {
                    field.setAccessible(true);
                    field.set(arrayObject, getDex(field.getName(), field.get(arrayObject)));
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字段加密处理中心(理论上value值必然是String)
     * @param key       匹配的值
     * @param value     要加密的数据
     * @return
     */
    public static Object getDex(String key, Object value) {
        switch (key) {
            case "id":
                value = "id加密:" + value;
                break;
            case "name":
                value = "name加密:" + value;
                break;
            case "age":
                value = "age加密:" + value;
                break;
        }
        return value;
    }


    public static void main(String[] args) {
        List<userBean> list = (List<userBean>) getClassListField(ListUtil.getUserBeanList(), "name");
        List<Map<String, Object>> maps = (List<Map<String, Object>>) getClassListField(ListUtil.getHashMapList(), "name");
        System.out.println("处理成功");
    }
}
