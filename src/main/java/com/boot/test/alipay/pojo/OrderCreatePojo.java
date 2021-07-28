package com.boot.test.alipay.pojo;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author WangW
 * @date 2020/11/05 16:24
 * @description 创建订单实体类
 */
public class OrderCreatePojo {

    /**
     * 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
     * 必传
     */
    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 卖家支付宝用户ID。
     * 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
     */
    @JSONField(name = "seller_id")
    private String sellerId;

    /**
     *订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * 必传
     */
    @JSONField(name = "total_amount")
    private String totalAmount;

    /**
     * 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * 非必传
     */
    @JSONField(name = "discountable_amount")
    private String discountableAmount;

    /**
     * 商品标题/交易标题/订单标题/订单关键字等。
     * 注意：不可使用特殊字符，如 /，=，& 等。
     * 必传
     */
    @JSONField(name = "subject")
    private String subject;

    /**
     * 对交易或商品的描述
     * 非必传
     */
    @JSONField(name = "body")
    private String body;

    /**
     * 买家的支付宝唯一用户号（2088开头的16位纯数字）
     * 注意：对应小程序用户的user_id
     */
    @JSONField(name = "buyer_id")
    private String buyerId;

    /**
     * 销售产品码。
     * 如果签约的是当面付快捷版，则传OFFLINE_PAYMENT;
     * 其它支付宝当面付产品传FACE_TO_FACE_PAYMENT；
     * 不传默认使用FACE_TO_FACE_PAYMENT；
     * 非必传
     */
    @JSONField(name = "product_code")
    private String productCode;

    /**
     * 商户操作员编号
     * 非必传
     */
    @JSONField(name = "operator_id")
    private String operatorId;

    /**
     * 商户门店编号
     * 非必传
     */
    @JSONField(name = "store_id")
    private String storeId;

    /**
     * 商户机具终端编号
     * 非必传
     */
    @JSONField(name = "terminal_id")
    private String terminalId;

    /**
     * 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。
     * m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
     * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
     */
    @JSONField(name = "timeout_express")
    private String timeoutExpress;

    /**
     * 物流信息
     * 非必传
     */
    @JSONField(name = "logistics_detail")
    private LogisticsDetail logisticsDetail;

    /**
     * 收货人及地址信息
     * 非必传
     */
    @JSONField(name = "receiver_address_info")
    private ReceiverAddressInfo receiverAddressInfo;

    /**
     * 订单包含的商品列表信息，其它说明详见：“订单商品传参类”
     * 非必传
     */
    @JSONField(name = "goods_detail")
    private List<GoodsDetailPojo> goodsDetail;

    /**
     * 业务扩展参数
     * 非必传
     */
    @JSONField(name = "extend_params")
    private ExtendParams extendParams;


    /**
     * 物流信息
     */
    private class LogisticsDetail {

        /**
         * 物流类型
         * POST 平邮,
         * EXPRESS 其他快递,
         * VIRTUAL 虚拟物品,
         * EMS EMS,
         * DIRECT 无需物流。
         */
        @JSONField(name = "logistics_type")
        private String logisticsType;

        public String getLogisticsType() {
            return logisticsType;
        }

        public void setLogisticsType(String logisticsType) {
            this.logisticsType = logisticsType;
        }

        public LogisticsDetail() {
        }

        public LogisticsDetail(String logisticsType) {
            this.logisticsType = logisticsType;
        }
    }

    /**
     * 收货人及地址信息
     */
    private class ReceiverAddressInfo {
        /**
         * 收货人的姓名
         * 非必传
         */
        @JSONField(name = "name")
        private String name;

        /**
         * 收货地址
         * 非必传
         */
        @JSONField(name = "address")
        private String address;

        /**
         * 收货人手机号
         * 非必传
         */
        @JSONField(name = "mobile")
        private String mobile;

        /**
         * 收货地址邮编
         * 非必传
         */
        @JSONField(name = "zip")
        private String zip;

        /**
         * 中国标准城市区域码
         * 非必传
         */
        @JSONField(name = "division_code")
        private String divisionCode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getDivisionCode() {
            return divisionCode;
        }

        public void setDivisionCode(String divisionCode) {
            this.divisionCode = divisionCode;
        }

        public ReceiverAddressInfo() {
        }

        public ReceiverAddressInfo(String name, String address, String mobile, String zip, String divisionCode) {
            this.name = name;
            this.address = address;
            this.mobile = mobile;
            this.zip = zip;
            this.divisionCode = divisionCode;
        }
    }

    /**
     * 业务扩展参数
     */
    private class ExtendParams {
        /**
         * 系统商编号
         * 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
         * 非必传
         */
        @JSONField(name = "sys_service_provider_id")
        private String sysServiceProviderId;

        /**
         * 卡类型
         * 非必传
         */
        @JSONField(name = "card_type")
        private String cardType;

        /**
         * 商家订单详情页地址。实时同步时可传入商家小程序对应的订单详情页地址。
         * 传入该值将在 小程序订单中心 对应订单详情页展示 查看订单明细 入口。
         * 同时，传入该值将使 账单详情页 中 查看订单详情 入口跳转地址变为 merchant_order_url。用户点击两处入口都会跳转至商家指定的小程序页面。
         * 可选(订单中心模块)
         */
        @JSONField(name = "merchant_order_url")
        private String merchantOrderUrl;

        /**
         * 存放系统自定义字段
         */
        @JSONField(name = "date")
        private Object date;

    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDiscountableAmount() {
        return discountableAmount;
    }

    public void setDiscountableAmount(String discountableAmount) {
        this.discountableAmount = discountableAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public LogisticsDetail getLogisticsDetail() {
        return logisticsDetail;
    }

    public void setLogisticsDetail(String logisticsType) {
        this.logisticsDetail = new LogisticsDetail(logisticsType);
    }

    public ReceiverAddressInfo getReceiverAddressInfo() {
        return receiverAddressInfo;
    }

    public void setReceiverAddressInfo(String name, String address, String mobile, String zip, String divisionCode) {
        this.receiverAddressInfo = new ReceiverAddressInfo(name, address, mobile, zip, divisionCode);
    }

    public List<GoodsDetailPojo> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<GoodsDetailPojo> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
