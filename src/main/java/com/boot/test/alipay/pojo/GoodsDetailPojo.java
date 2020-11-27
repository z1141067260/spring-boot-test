package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author WangW
 * @date 2020/11/04 17:47
 * @description 订单商品传参类
 */
public class GoodsDetailPojo {

    /**
     * 商品的编号
     * 必传
     */
    @JSONField(name = "goods_id")
    private String goodsId;

    /**
     * 商品名称
     * 必传
     */
    @JSONField(name = "goods_name")
    private String goodsName;

    /**
     * 商品数量
     * 必传
     */
    @JSONField(name = "quantity")
    private Integer quantity;

    /**
     * 商品单价，单位为元
     * 必传
     */
    @JSONField(name = "price")
    private String price;

    /**
     * 商品类目
     * 非必传
     */
    @JSONField(name = "goods_category")
    private String goodsCategory;

    /**
     * 商品类目树，从商品类目根节点到叶子节点的类目id组成，类目id值使用|分割
     * 非必传
     */
    @JSONField(name = "categories_tree")
    private String categoriesTree;

    /**
     * 商品描述信息
     * 非必传
     */
    @JSONField(name = "body")
    private String body;

    /**
     * 商品的展示地址
     * 非必传
     */
    @JSONField(name = "show_url")
    private String showUrl;

    /**
     * 支付宝定义的统一商品编号(订单退款时才用到的字段)
     */
    @JSONField(name = "alipay_goods_id")
    private String alipayGoodsId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getCategoriesTree() {
        return categoriesTree;
    }

    public void setCategoriesTree(String categoriesTree) {
        this.categoriesTree = categoriesTree;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getAlipayGoodsId() {
        return alipayGoodsId;
    }

    public void setAlipayGoodsId(String alipayGoodsId) {
        this.alipayGoodsId = alipayGoodsId;
    }
}
