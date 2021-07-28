package com.boot.test.alipay.request.open;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayOpenAppQrcodeCreateRequest;
import com.alipay.api.response.AlipayOpenAppQrcodeCreateResponse;
import com.boot.test.alipay.AlipayCententClient;
import com.boot.test.alipay.pojo.QrcodeCreatePojo;

/**
 * @author WangW
 * @date 2020/11/04 15:49
 * @description 二维码生成类
 */
public class QrcodeRequest {


    /**
     * 生成支付宝小程序二维码
         * 参考文档：https://opendocs.alipay.com/apis/009zva
     */
    public static AlipayOpenAppQrcodeCreateResponse create(QrcodeCreatePojo qrcodeCreate){
        AlipayOpenAppQrcodeCreateRequest request = new AlipayOpenAppQrcodeCreateRequest();

        request.setBizContent(qrcodeCreate.toString());
        AlipayOpenAppQrcodeCreateResponse response = null;
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
}
