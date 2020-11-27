//package com.boot.test.util;
//
//import com.hwinfo.common.exception.CommonException;
//import org.apache.commons.lang3.StringUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
///**
// * @author hulinhao
// * 对象工具类
// **/
//public class ObjectUtil {
//    /**
//     * 将Integer和Double类型为null的值，设置为0
//     *
//     * @param object
//     * @throws Exception
//     */
//    public static void setNullToZero(Object object) {
//        //得到object类的全部属性（修饰符+类型+名字)
//        Class<?> aClass = object.getClass();
//        List<Field> allField = getAllField(object);
//        for (Field field : allField) {
//            Type genericType = field.getGenericType();
//            try {
//                if (genericType.equals(Double.class)) {
//                    Double value = (Double) aClass.getMethod(generatorGetMethod(field)).invoke(object);
//                    if (value == null) {
//                        field.set(object, 0D);
//                    }
//                } else {
//                    Integer value = (Integer) aClass.getMethod(generatorGetMethod(field)).invoke(object);
//                    if (value == null) {
//                        field.set(object, 0);
//                    }
//                }
//            } catch (Exception e) {
//                throw new CommonException("将null转化为0失败");
//            }
//        }
//    }
//
//    /**
//     * Object的空字符串转化为null
//     *
//     * @param object
//     */
//    public static void setFieldBlankToNull(Object object) {
//        //得到object类的全部属性（修饰符+类型+名字）
//        List<Field> allField = getAllField(object);
//        Class<?> aClass = object.getClass();
//        for (Field field : allField) {
//            //获取属性类型
//            try {
//                if (field.getGenericType().equals(String.class)) {
//                    // 取消属性的访问权限控制，即使private属性也可以进行访问。
//                    field.setAccessible(true);
//                    Method method = aClass.getMethod(generatorGetMethod(field));
//                    //调用get
//                    String val = (String) method.invoke(object);
//                    if (StringUtils.isBlank(val)) {
//                        //设置该属性的值为null
//                        field.set(object, null);
//                    }
//                }
//            } catch (Exception e) {
//                throw new CommonException("将空字符串转化为null失败");
//            }
//        }
//    }
//
//    /**
//     * 属性为BigDecimal的都除以number值
//     *
//     * @param object
//     * @throws Exception
//     */
//    public static void setBigDecimal(Object object, int number) {
//        if (object == null) {
//            return;
//        }
//        //得到object类的全部属性（修饰符+类型+名字）
//        Class<?> aClass = object.getClass();
//        List<Field> objectFields = getAllField(object);
//        for (Field field : objectFields) {
//            try {
//                // 如果是BigDecimal类，就除以number
//                if (field.getGenericType().equals(BigDecimal.class)) {
//                    field.setAccessible(true);
//                    Method method = aClass.getMethod(generatorGetMethod(field));
//                    BigDecimal value = (BigDecimal) method.invoke(object);
//                    if (value == null) {
//                        value = new BigDecimal(0);
//                    } else {
//                        String tempNoZero = value.divide(new BigDecimal(number)).stripTrailingZeros().toPlainString();
//                        value = new BigDecimal(tempNoZero);
//                    }
//                    field.set(object, value);
//                }
//            } catch (Exception e) {
//                throw new CommonException(object + "除以" + number + "失败");
//            }
//        }
//    }
//
//    /**
//     * 设置列表index属性（包括父类的index）
//     *
//     * @param list
//     */
//    public static void setIndex(List list) {
//        // 得到object类的全部属性（修饰符+类型+名字
//        if (list.isEmpty()) {
//            return;
//        }
//        Object object = list.get(0);
//        List<Field> fieldList = getAllField(object);
//        // 是否存在index字段
//        Optional<Field> optional = fieldList.stream()
//                .filter(field -> field.getName().equals("index")).findFirst();
//        if (optional.isPresent()) {
//            Field field = optional.get();
//            field.setAccessible(true);
//            try {
//                for (int i = 0; i < list.size(); i++) {
//                    field.set(list.get(i), i + 1);
//                }
//            } catch (IllegalAccessException e) {
//                throw new CommonException("index属性转换出错");
//            }
//        }
//    }
//
//    /**
//     * 得到一个类的所有属性
//     */
//    private static List<Field> getAllField(Object object) {
//        // 得到object类的全部属性（修饰符+类型+名字）
//        Class<?> aClass = object.getClass();
//        List<Field> list = new ArrayList<>();
//        while (!aClass.equals(Object.class)) {
//            Field[] objectFields = aClass.getDeclaredFields();
//            list.addAll(Arrays.asList(objectFields));
//            aClass = aClass.getSuperclass();
//        }
//        // 取消属性的访问权限控制
//        list.forEach(field -> field.setAccessible(true));
//        return list;
//    }
//
//    /**
//     * 生成相关属性get方法
//     *
//     * @param field 属性
//     * @return
//     */
//    private static String generatorGetMethod(Field field) {
//        return "get" + upStringFirstChar(field.getName());
//    }
//
//    /**
//     * 生成相关属性set方法
//     *
//     * @param field 属性
//     * @return
//     */
//    private static String generatorSetMethod(Field field) {
//        return "set" + upStringFirstChar(field.getName());
//    }
//
//    /**
//     * 字符串第一个字母大写
//     *
//     * @param s
//     * @return
//     * @throws Exception
//     */
//    private static String upStringFirstChar(String s) {
//        byte[] items = s.getBytes();
//        items[0] = (byte) ((char) items[0] - 'a' + 'A');
//        return new String(items);
//    }
//
////    /**
////     * 测试是否生效使用
////     * @param args
////     */
////    public static void main(String[] args) {
////        Student student = new Student();
////        System.out.println(student);
////        setNullToZero(student);
////        System.out.println(student);
////    }
////
////    @Data
////    @Accessors(chain = true)
////    private static class Student {
////        private Double name;
////        private Integer age;
////    }
//}
