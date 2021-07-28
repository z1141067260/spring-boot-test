package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author WangW
 * @date 2020/11/05 16:24
 * @description 小程序二维码实体类
 */
public class QrcodeCreatePojo {

    /**
     * 小程序的的页面路径
     */
    @JSONField(name = "url_param")
    private String urlParam;

    /**
     * 小程序的启动参数，打开小程序的query ，在小程序 onLaunch的方法中获取
     */
    @JSONField(name = "query_param")
    private String queryParam;

    /**
     * 对应的二维码描述  长度：32
     */
    @JSONField(name = "describe")
    private String describe;

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static void main(String[] args) {
        QrcodeCreatePojo qrcodeCreate = new QrcodeCreatePojo();
        qrcodeCreate.setUrlParam("小程序的的页面路径");
        System.out.println(qrcodeCreate.toString());
    }
}
