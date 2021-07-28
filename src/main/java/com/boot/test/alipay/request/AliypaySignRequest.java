package com.boot.test.alipay.request;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.boot.test.alipay.AlipayCententClient;
import com.boot.test.alipay.pojo.OrderSignPojo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author WangW
 * @date 2020/11/05 16:24
 * @description 验签结果类
 */
public class AliypaySignRequest {

    /**
     * 订单异步通知验签
     * 参考文档：https://opendocs.alipay.com/open/204/105301
     * @param request 请求文
     * @return 支付宝数据
     */
    public static OrderSignPojo rsaCheckOrder(HttpServletRequest request){
        Map requestParams = request.getParameterMap();

        Map<String, String> params = new HashMap<>(16);
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(params,
                    AlipayCententClient.getAlipayPublicKey(),
                    AlipayCententClient.getCharset(),
                    AlipayCententClient.getSignType());
            if (signVerified) {
                OrderSignPojo orderSign = JSONObject.parseObject(JSONObject.toJSONString(params), OrderSignPojo.class);
                String appId = params.get("app_id");
                if(appId != null && AlipayCententClient.getAppId().equals(appId)){
                    return orderSign;
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            System.out.println("支付宝订单回调验签失败");
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, String > params = new HashMap<>(16);
        params.put("app_id", "appID");
        params.put("notify_time", "2020-11-05 17:27");
        params.put("notify_type", "2020-11-05 17:27");
        params.put("notify_id", "2020-11-05 17:27");
        params.put("trade_no", "2020-11-05 17:27");
        params.put("out_trade_no", "2020-11-05 17:27");
        params.put("out_biz_no", "2020-11-05 17:27");
        params.put("buyer_id", "2020-11-05 17:27");
        params.put("buyer_logon_id", "2020-11-05 17:27");
        params.put("seller_id", "2020-11-05 17:27");
        params.put("seller_email", "2020-11-05 17:27");
        params.put("trade_status", "2020-11-05 17:27");
        params.put("total_amount", "2020-11-05 17:27");
        params.put("receipt_amount", "2020-11-05 17:27");
        params.put("buyer_pay_amount", "2020-11-05 17:27");
        params.put("refund_fee", "2020-11-05 17:27");
        params.put("subject", "2020-11-05 17:27");
        params.put("body", "2020-11-05 17:27");
        params.put("gmt_create", "2020-11-05 17:27");
        params.put("gmt_payment", "2020-11-05 17:27");
        params.put("gmt_refund", "2020-11-05 17:27");
        params.put("gmt_close", "2020-11-05 17:27");
        params.put("fund_bill_list", "2020-11-05 17:27");
        params.put("passback_params", "2020-11-05 17:27");
        params.put("voucher_detail_list", "2020-11-05 17:27");
        OrderSignPojo orderSign = JSONObject.parseObject(params.toString(), OrderSignPojo.class);
        System.out.println(orderSign);
    }

}
