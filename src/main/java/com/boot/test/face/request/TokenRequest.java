package com.boot.test.face.request;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.boot.test.face.config.Constants;
import com.boot.test.face.response.TokenResponse;
import com.boot.test.face.util.EncryptionFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author WangW
 * @date 2020/11/20 18:14
 * @description
 */
public class TokenRequest extends AbstractRequestBase<TokenResponse> {

    private final String URL = "/oauth/token";

    private String method = "POST";

    private MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

    @JSONField(name = "app_secret")
    private String appSecret = Constants.AIFACE_APPSECRET;

    @Override
    public MultiValueMap<String, String> getHeader() {
        headers.set("Content-Type", "aalication/form-data");
        headers.set("app_key", Constants.AIFACE_APPKEY);
        return headers;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public String getRequestMap() {
        return jm(toString());
    }

    @Override
    public Class<TokenResponse> getResponse() {
        return TokenResponse.class;
    }


    @Override
    public String toString() {
        return "{" +
                "appSecret='" + appSecret + '\'' +
                '}';
    }
}
