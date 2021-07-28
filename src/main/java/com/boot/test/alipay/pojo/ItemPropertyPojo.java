package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author WangW
 * @date 2020/11/10 16:24
 * @description 商品属性类
 */
public class ItemPropertyPojo {
    /**
     * 属性名称
     */
    @JSONField(name = "propertyKey")
    private String propertyKey;

    /**
     * 属性值列表
     */
    @JSONField(name = "property_value")
    private String propertyValue;

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
