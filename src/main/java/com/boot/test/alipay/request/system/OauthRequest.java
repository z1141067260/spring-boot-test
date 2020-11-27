package com.boot.test.alipay.request.system;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.boot.test.alipay.AlipayCententClient;

/**
 * @author WangW
 * @date 2020/11/04 15:49
 * @description 小程序用户授权类
 */
public class OauthRequest {

    /**
     * 参考文档：https://opendocs.alipay.com/apis/api_9/alipay.user.info.auth
     * 用户登录授权
     * @param request
     */
    public static AlipaySystemOauthTokenResponse token(AlipaySystemOauthTokenRequest request){
        AlipaySystemOauthTokenResponse response = null;
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
     * 通过Code获取用户的AccessToken
     * @param authCode 前端获取的一次性Code
     */
    public static AlipaySystemOauthTokenResponse getToken(String authCode){
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(authCode);
        return token(request);
    }

    /**
     * 通过RefreshToken刷新AccessToken
     * @param refreshToken 用户的RefreshToken
     */
    public static AlipaySystemOauthTokenResponse refreshToken(String refreshToken){
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("refresh_token");
        request.setRefreshToken(refreshToken);
        return token(request);
    }
}
