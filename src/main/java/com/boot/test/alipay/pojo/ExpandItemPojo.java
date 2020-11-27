package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author WangW
 * @date 2020/11/10 15:33
 * @description 订单中心商品实体类
 */
public class ExpandItemPojo {

    /**
     * 场景码（小程序商品：APP_ORDER）
     * 必选
     */
    @JSONField(name = "scene")
    private String scene = "APP_ORDER";

    /**
     * 商品归属主体ID
     * 例：商品归属主体类型为店铺，则商品归属主体ID为店铺ID；归属主体为小程序，则归属主体ID为小程序ID
     * 必选
     */
    @JSONField(name = "traget_id")
    private String tragetId;

    /**
     * 商品归属主体类型: 5（店铺） 8（小程序）
     * 必选
     */
    @JSONField(name = "targent_type")
    private String targentType;

    /**
     * 商品所属标准类目ID（参考：https://opendocs.alipay.com/mini/011lxt）
     * 特殊可选
     */
    @JSONField(name = "standard_category_id")
    private String standardCategoryId;

    /**
     * 商品名称
     * 必选
     */
    @JSONField(name = "name")
    private String name;

    /**
     * 商品描述
     * 可选
     */
    @JSONField(name = "description")
    private String description;

    /**
     * 商品类型：STANDARD_GOODS（标品）、NON_STANDARD_GOODS（非标品）
     * 必选
     */
    @JSONField(name = "type")
    private String type;

    /**
     * 商品扩展信息（具体KEY请参见产品文档）
     * 特殊可选
     */
    @JSONField(name = "ext_info")
    List<ItemExtInfoPojo> extInfo;

    /**
     * 商品SKU列表（至少1个，最多20个）
     * 必选
     */
    @JSONField(name = "sku_list")
    List<SkuCreateInfoPojo> skuList;

    /**
     * 素材列表（最多3个），素材内容为素材key（素材key获取方式参照：https://opendocs.alipay.com/apis/api_4/alipay.merchant.item.file.upload）
     * 可选
     */
    @JSONField(name = "material_list")
    List<MaterialCreatePojo> materialList;

    /**
     * 商品属性列表
     * 可选
     */
    @JSONField(name = "property_list")
    List<ItemPropertyInfo> propertyList;

    /**
     * 商品属性列表
     */
    public class ItemPropertyInfo {
        /**
         * 属性名称
         */
        @JSONField(name = "property_key")
        private String propertyKey;

        /**
         * 属性值列表
         */
        @JSONField(name = "property_value_list")
        private String[] propertyValueList;

        public String getPropertyKey() {
            return propertyKey;
        }

        public void setPropertyKey(String propertyKey) {
            this.propertyKey = propertyKey;
        }

        public String[] getPropertyValueList() {
            return propertyValueList;
        }

        public void setPropertyValueList(String[] propertyValueList) {
            this.propertyValueList = propertyValueList;
        }
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getTragetId() {
        return tragetId;
    }

    public void setTragetId(String tragetId) {
        this.tragetId = tragetId;
    }

    public String getTargentType() {
        return targentType;
    }

    public void setTargentType(String targentType) {
        this.targentType = targentType;
    }

    public String getStandardCategoryId() {
        return standardCategoryId;
    }

    public void setStandardCategoryId(String standardCategoryId) {
        this.standardCategoryId = standardCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ItemExtInfoPojo> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(List<ItemExtInfoPojo> extInfo) {
        this.extInfo = extInfo;
    }

    public List<SkuCreateInfoPojo> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuCreateInfoPojo> skuList) {
        this.skuList = skuList;
    }

    public List<MaterialCreatePojo> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<MaterialCreatePojo> materialList) {
        this.materialList = materialList;
    }

    public List<ItemPropertyInfo> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<ItemPropertyInfo> propertyList) {
        this.propertyList = propertyList;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
