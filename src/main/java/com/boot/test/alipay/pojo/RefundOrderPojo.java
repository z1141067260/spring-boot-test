package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author WangW
 * @date 2020/11/05 11:10
 * @description 订单退款实体类
 */
public class RefundOrderPojo {

    /**
     * 订单支付时传入的商户订单号,不能和 trade_no同时为空。
     * 特殊可选
     */
    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 支付宝交易号，和商户订单号不能同时为空
     * 特殊可选
     */
    @JSONField(name = "trade_no")
    private String tradeNo;

    /**
     * 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
     * 必选
     */
    @JSONField(name = "refund_amount")
    private String refundAmount;

    /**
     * 订单退款币种信息
     * 可选
     * USD
     */
    @JSONField(name = "refund_currency")
    private String refundCurrency;

    /**
     * 退款的原因说明
     * 可选
     */
    @JSONField(name = "refund_reason")
    private String refundReason;

    /**
     * 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
     * 可选
     */
    @JSONField(name = "out_request_no")
    private String outRequestNo;

    /**
     * 商户的操作员编号
     * 可选
     */
    @JSONField(name = "operator_id")
    private String operatorId;

    /**
     * 商户的门店编号
     * 可选
     */
    @JSONField(name = "store_id")
    private String storeId;

    /**
     * 	商户的终端编号
     * 	可选
     */
    @JSONField(name = "terminal_id")
    private String terminalId;


    /**
     * 银行间联模式下有用，其它场景请不要使用； 双联通过该参数指定需要退款的交易所属收单机构的pid;
     * 可选
     */
    @JSONField(name = "org_pid")
    private String orgPid;

    /**
     * 查询选项，商户通过上送该参数来定制同步需要额外返回的信息字段，数组格式。如：["refund_detail_item_list"]
     * 可选
     */
    @JSONField(name = "query_options")
    private String[] queryOptions;

    /**
     * 退款时分账实体类
     */
    @JSONField(name = "refund_royalty_parameters")
    private List<RefundRoyaltyParametersPojo> refundRoyaltyParameters;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
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

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid;
    }

    public String[] getQueryOptions() {
        return queryOptions;
    }

    public void setQueryOptions(String[] queryOptions) {
        this.queryOptions = queryOptions;
    }

    public List<RefundRoyaltyParametersPojo> getRefundRoyaltyParameters() {
        return refundRoyaltyParameters;
    }

    public void setRefundRoyaltyParameters(List<RefundRoyaltyParametersPojo> refundRoyaltyParameters) {
        this.refundRoyaltyParameters = refundRoyaltyParameters;
    }
}
