//package com.boot.test.util;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.enums.WriteDirectionEnum;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.alibaba.excel.write.metadata.fill.FillConfig;
//import com.alibaba.excel.write.metadata.fill.FillWrapper;
//import com.hwinfo.common.exception.CommonException;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URLEncoder;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * EasyExcel导出工具类
// */
//@Slf4j
//public class EasyExcelUtil {
//    /**
//     * 插入单个列表
//     *
//     * @param path     文件相对路径
//     * @param fileName 文件名
//     * @param response
//     * @param list     要输入的列表
//     * @throws IOException
//     */
//    public static void commonWriteExcel(String path, String fileName, HttpServletResponse response, List list) {
//        // 如果类中存在index字段的话，就会从1开始设置index
//        ObjectUtil.setIndex(list);
//        log.info("要插入Excel中的列表是" + list);
//        InputStream templateFileName = EasyExcelUtil.class.getClassLoader().getResourceAsStream(path);
//        ExcelWriter excelWriter = null;
//        try {
//            excelWriter = EasyExcel.write(response.getOutputStream()).withTemplate(templateFileName).build();
//        } catch (IOException e) {
//            throw new CommonException("流输出异常");
//        }
//        WriteSheet writeSheet = EasyExcel.writerSheet().build();
//        try {
//            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
//            response.setContentType("application/vnd.ms-excel");
//            response.setCharacterEncoding("utf-8");
//            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
//            excelWriter.fill(list, writeSheet);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new CommonException(e.getMessage());
//        } finally {
//            // 千万别忘记关闭流
//            excelWriter.finish();
//            list = null; //help gc
//        }
//    }
//
//    /**
//     * 插入多个列表形式
//     *
//     * @param path
//     * @param fileName
//     * @param response
//     * @param lists    多个列表传入
//     * @throws IOException
//     */
//    public static void commonWriteExcelMultipleList(String path, String fileName, HttpServletResponse response, List... lists) throws IOException {
//
//        InputStream templateFileName = EasyExcelUtil.class.getClassLoader().getResourceAsStream(path);
//        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).withTemplate(templateFileName).build();
//        WriteSheet writeSheet = EasyExcel.writerSheet().build();
//        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.VERTICAL).build();
//        try {
//            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
//            response.setContentType("application/vnd.ms-excel");
//            response.setCharacterEncoding("utf-8");
//            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
//            for (int i = 0; i < lists.length; i++) {
//                excelWriter.fill(new FillWrapper("data" + (i + 1), lists[i]), fillConfig, writeSheet);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new CommonException(e.getMessage());
//        } finally {
//            // 千万别忘记关闭流
//            excelWriter.finish();
//            Arrays.fill(lists, null); // help gc
//        }
//    }
//}
