package com.boot.test.alipay.request.user;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.boot.test.alipay.AlipayCententClient;

/**
 * @author WangW
 * @date 2020/11/04 15:49
 * @description 用户信息模块
 */
public class UserInfoRequest {

    /**
     * 参考文档：https://opendocs.alipay.com/apis/api_2/alipay.user.info.share
     * 支付宝会员授权信息查询接口
     * @param accessToken 用户的AccessToken
     */
    public static AlipayUserInfoShareResponse share(String accessToken){
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        AlipayUserInfoShareResponse response = null;
        try {
            response = AlipayCententClient.getAlipayClient().execute(request,accessToken);
            if(!response.isSuccess()){
                return null;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;
    }
}
