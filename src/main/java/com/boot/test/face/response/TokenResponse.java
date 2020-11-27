package com.boot.test.face.response;

/**
 * @author WangW
 * @date 2020/11/23 9:52
 * @description outhToken的实体类
 */
public class TokenResponse extends ResponseBase{

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
