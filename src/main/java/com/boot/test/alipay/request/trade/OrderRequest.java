package com.boot.test.alipay.request.trade;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.boot.test.alipay.AlipayCententClient;
import com.boot.test.alipay.pojo.OrderCreatePojo;
import com.boot.test.alipay.pojo.RefundOrderPojo;

/**
 * @author WangW
 * @date 2020/11/04 15:49
 * @description 收单交易类
 */
public class OrderRequest {

    /**
     * 参考文档：https://opendocs.alipay.com/apis/api_1/alipay.trade.create
     * 统一收单交易创建接口
     * @param tradeCreate 订单入参类
     * @return
     */
    public static AlipayTradeCreateResponse createOrder(OrderCreatePojo tradeCreate){
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        request.setNotifyUrl(AlipayCententClient.getNotifyOrderUrl());
        request.setBizContent(tradeCreate.toString());
        AlipayTradeCreateResponse response = null;
        try {
            response = AlipayCententClient.getAlipayClient().execute(request);
            if(!response.isSuccess()){
                return null;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 统一收单交易关闭接口
     * @param outTradeNo 创建交易传入的商户订单号
     * @return
     */
    public static AlipayTradeCloseResponse closeOrderToOutTrade(String outTradeNo){
        return closeOrder(null, outTradeNo, null);
    }

    /**
     * 统一收单交易关闭接口
     * @param tradeNo 支付宝交易号
     * @return
     */
    public static AlipayTradeCloseResponse closeOrderToTrade(String tradeNo){
        return closeOrder(tradeNo, null, null);
    }

    /**
     * 统一收单交易关闭接口(tradeNo优先级高于outTradeNo)
     * 参考文档：https://opendocs.alipay.com/apis/api_1/alipay.trade.close
     * @param tradeNo       支付宝交易号
     * @param outTradeNo    创建交易传入的商户订单号
     * @param operatorId    卖家端自定义的的操作员 ID
     * @return
     */
    public static AlipayTradeCloseResponse closeOrder(String tradeNo, String outTradeNo, String operatorId){
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("trade_no", tradeNo);
        jsonObject.put("out_trade_no", outTradeNo);
        jsonObject.put("operator_id", operatorId);
        request.setBizContent(jsonObject.toJSONString());
        AlipayTradeCloseResponse response = null;
        try {
            response = AlipayCententClient.getAlipayClient().execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(!response.isSuccess()){
            return null;
        }
        return response;
    }

    /**
     * 统一收单交易撤销接口
     * @param outTradeNo 原支付请求的商户订单号,和支付宝交易号不能同时为空
     * @return
     */
    public static AlipayTradeCancelResponse cancelOrderToOutTrade(String outTradeNo){
        return cancelOrder(null, outTradeNo);
    }

    /**
     * 统一收单交易撤销接口
     * @param tradeNo 支付宝交易号，和商户订单号不能同时为空
     * @return
     */
    public static AlipayTradeCancelResponse cancelOrderToTrade(String tradeNo){
        return cancelOrder(tradeNo, null);
    }

    /**
     * 统一收单交易撤销接口
     * 只有发生支付系统超时或者支付结果未知时可调用撤销
     * 参考文档：https://opendocs.alipay.com/apis/api_1/alipay.trade.cancel
     * @param tradeNo 支付宝交易号，和商户订单号不能同时为空
     * @param outTradeNo 原支付请求的商户订单号,和支付宝交易号不能同时为空
     * @return
     */
    public static AlipayTradeCancelResponse cancelOrder(String tradeNo, String outTradeNo){
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("trade_no", tradeNo);
        jsonObject.put("out_trade_no", outTradeNo);
        request.setBizContent(jsonObject.toJSONString());
        AlipayTradeCancelResponse response = null;
        try {
            response = AlipayCententClient.getAlipayClient().execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(!response.isSuccess()){
            return null;
        }
        return response;
    }

    /**
     * 统一收单交易退款接口
     * 参考文档：https://opendocs.alipay.com/apis/api_1/alipay.trade.refund
     * @param refundOrderPojo 订单退款信息
     * @return
     */
    public static AlipayTradeRefundResponse refundOder(RefundOrderPojo refundOrderPojo){
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(refundOrderPojo.toString());
        AlipayTradeRefundResponse response = null;
        try {
            response = AlipayCententClient.getAlipayClient().execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(!response.isSuccess()){
            return null;
        }
        return response;
    }

    /**
     * 统一收单交易退款查询
     * @param tradeNo 支付宝交易号，和商户订单号不能同时为空
     * @return
     */
    public static AlipayTradeFastpayRefundQueryResponse refundOrderQueryToOutTrade(String tradeNo){
        return refundOrderQuery(tradeNo, null, null, null, null);
    }

    /**
     * 统一收单交易退款查询
     * @param outTradeNo 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
     * @return
     */
    public static AlipayTradeFastpayRefundQueryResponse refundOrderQueryToTrade(String outTradeNo){
        return refundOrderQuery(null, outTradeNo, null, null, null);
    }

    /**
     * 统一收单交易退款查询
     * 参考文档：https://opendocs.alipay.com/apis/api_1/alipay.trade.fastpay.refund.query
     * @param tradeNo       支付宝交易号，和商户订单号不能同时为空
     * @param outTradeNo    订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
     * @param outRequestNo  请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
     * @param orgPid        银行间联模式下有用，其它场景请不要使用；   双联通过该参数指定需要查询的交易所属收单机构的pid;
     * @param queryOptions  查询选项，商户通过上送该参数来定制同步需要额外返回的信息字段，数组格式。如：["refund_detail_item_list"]
     * @return
     */
    public static AlipayTradeFastpayRefundQueryResponse refundOrderQuery(String tradeNo, String outTradeNo, String outRequestNo, String orgPid, String[] queryOptions){
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("trade_no", tradeNo);
        jsonObject.put("out_trade_no", outTradeNo);
        jsonObject.put("out_request_no", outRequestNo);
        jsonObject.put("org_pid", orgPid);
        jsonObject.put("query_options", queryOptions);
        request.setBizContent(jsonObject.toJSONString());
        AlipayTradeFastpayRefundQueryResponse response = null;
        try {
            response = AlipayCententClient.getAlipayClient().execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(!response.isSuccess()){
            return null;
        }
        return response;
    }
}
