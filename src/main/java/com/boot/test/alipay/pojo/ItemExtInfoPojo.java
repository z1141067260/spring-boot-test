package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author WangW
 * @date 2020/11/10 15:53
 * @description 商品扩展信息类
 */
public class ItemExtInfoPojo {

    /**
     * 扩展信息的key
     * DETAIL_URL：订单中心里用户可在订单详情页中点击商品图片跳转至对应页面。
     * 必选
     */
    @JSONField(name = "ext_key")
    private String extKey;

    /**
     * 扩展信息的值
     * ext_key=DETAIL_URL，则必填商品详情页地址
     * 如：pages/index/index；系统会自动拼接成地址 alipays://platformapi/startapp?appId=2019xxxxxxxx&page=pages/index/index
     * 必选
     */
    @JSONField(name = "ext_value")
    private String extValue;

    public String getExtKey() {
        return extKey;
    }

    public void setExtKey(String extKey) {
        this.extKey = extKey;
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }
}
