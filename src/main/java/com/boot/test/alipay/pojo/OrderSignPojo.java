package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author WangW
 * @date 2020/11/05 17:17
 * @description 订单支付成功返参实体类
 */
public class OrderSignPojo {

    /**
     * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss。
     */
    private String notifyTime;

    /**
     * 通知的类型。trade_status_sync
     */
    private String notifyType;

    /**
     * 通知校验 ID。
     */
    private String notifyId;

    /**
     * 支付宝分配给开发者的应用 Id。
     */
    private String appId;

    /**
     * 支付宝交易凭证号。
     */
    private String tradeNo;

    /**
     * 原支付请求的商户订单号。
     */
    private String outTradeNo;

    /**
     * 商户业务 ID，主要是退款通知中返回退款申请的流水号。
     */
    private String outBizNo;

    /**
     * 买家支付宝账号对应的支付宝唯一用户号。以 2088 开头的纯 16 位数字。
     */
    private String buyerId;

    /**
     * 卖家支付宝用户号。
     */
    private String sellerId;

    /**
     * 买家支付宝账号。
     */
    private String buyerLogonId;

    /**
     * 卖家支付宝账号。
     */
    private String sellerEmail;

    /**
     * 本次交易支付的订单金额，单位为人民币（元）。
     */
    private String totalAmount;

    /**
     * 商家在交易中实际收到的款项，单位为人民币（元）。
     */
    private String receiptAmount;

    /**
     * 用户在交易中支付的金额。
     */
    private String buyerPayAmount;

    /**
     * 退款通知中，返回总退款金额，单位为元，支持两位小数。
     */
    private String refundFee;

    /**
     * 商品的标题/交易标题/订单标题/订单关键字等，是请求时对应的参数，原样通知回来。
     */
    private String subject;

    /**
     * 该订单的备注、描述、明细等。对应请求时的 body 参数，原样通知回来。
     */
    private String body;

    /**
     * 该笔交易创建的时间。格式为 yyyy-MM-dd HH:mm:ss。
     */
    private String gmtCreate;

    /**
     * 该笔交易的买家付款时间。格式为 yyyy-MM-dd HH:mm:ss。
     */
    private String gmtPayment;

    /**
     * 该笔交易的退款时间。格式为 yyyy-MM-dd HH:mm:ss。
     */
    private String gmtRefund;

    /**
     * 该笔交易结束时间。格式为 yyyy-MM-dd HH:mm:ss。。
     */
    private String gmtClose;

    /**
     * 公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。本参数必须进行 UrlEncode 之后才可以发送给支付宝。
     */
    private String passbackParams;

    /**
     * 本交易支付时所使用的所有优惠券信息
     */
    private String voucherDetailList;

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(String buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
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

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    public String getGmtRefund() {
        return gmtRefund;
    }

    public void setGmtRefund(String gmtRefund) {
        this.gmtRefund = gmtRefund;
    }

    public String getGmtClose() {
        return gmtClose;
    }

    public void setGmtClose(String gmtClose) {
        this.gmtClose = gmtClose;
    }

    public String getPassbackParams() {
        return passbackParams;
    }

    public void setPassbackParams(String passbackParams) {
        this.passbackParams = passbackParams;
    }

    public String getVoucherDetailList() {
        return voucherDetailList;
    }

    public void setVoucherDetailList(String voucherDetailList) {
        this.voucherDetailList = voucherDetailList;
    }
}
