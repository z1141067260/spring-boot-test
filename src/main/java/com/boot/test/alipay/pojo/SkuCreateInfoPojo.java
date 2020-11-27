package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author WangW
 * @date 2020/11/10 16:04
 * @description 商品SKU实体类
 */
public class SkuCreateInfoPojo {

    /**
     * 售价，单位分
     * 必选
     */
    @JSONField(name = "price")
    private Integer price;

    /**
     * 标价，单位分
     * 必选
     */
    @JSONField(name = "original_price")
    private Integer originalPrice;

    /**
     * 库存
     * 可选
     */
    @JSONField(name = "inventory")
    private Integer inventory;

    /**
     * SKU素材列表（最多3个）
     * 可选
     */
    private List<MaterialCreatePojo> material_list;

    /**
     * SKU属性列表
     * 可选
     */
    private List<ItemSkuPropertyInfo> property_list;

    /**
     * SKU属性列表
     */
    public class ItemSkuPropertyInfo {
        /**
         * 属性名称
         * 必填
         */
        @JSONField(name = "propertyKey")
        private String propertyKey;

        /**
         * 属性值
         * 必填
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public List<MaterialCreatePojo> getMaterial_list() {
        return material_list;
    }

    public void setMaterial_list(List<MaterialCreatePojo> material_list) {
        this.material_list = material_list;
    }

    public List<ItemSkuPropertyInfo> getProperty_list() {
        return property_list;
    }

    public void setProperty_list(List<ItemSkuPropertyInfo> property_list) {
        this.property_list = property_list;
    }
}
