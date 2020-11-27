package com.boot.test.face;

import com.alibaba.fastjson.JSONObject;
import com.boot.test.face.config.Constants;
import com.boot.test.face.request.*;
import com.boot.test.face.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangW
 * @date 2020/11/23 9:39
 * @description API调用客户端
 */
public class XkpApiClient extends Constants {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    private <T extends ResponseBase> T doPost(AbstractRequestBase<T> requestBase) {
        HttpEntity<T> requestEntity = new HttpEntity<>(requestBase.getRequestMap(), requestBase.getHeader());
        HttpMethod Method = HttpMethod.valueOf(requestBase.getMethod());

        ResponseEntity<JSONObject> exchange = restTemplate.exchange(AIFACE_URL + requestBase.getUrl(), Method,
                requestEntity, JSONObject.class);
        JSONObject s = exchange.getBody();
        return s.getObject(s.toString(), requestBase.getResponse());
//        if ("{}".equals(body)) {
//            return null;
//        }

//        return JSONObject.parseObject(body, requestBase.getResponse());
    }

    /**
     * 获取Token
     * @return
     */
    public TokenResponse getToken(){
        TokenRequest tokenRequest = new TokenRequest();
        return this.doPost(tokenRequest);
    }

    /**
     * 添加授权名单
     */
    public AddGrantResponse addGrant(){
        AddGrantRequest addGrantRequest = new AddGrantRequest();
        return this.doPost(addGrantRequest);
    }

    /**
     * 移除授权名单
     */
    public void delGrant(){
        DelGrantRequest delGrantRequest = new DelGrantRequest();
        DelGrantResponse delGrantResponse = this.doPost(delGrantRequest);
    }

    /**
     * 创建设备
     */
    public void addTerm(){
        AddTermRequest addTermRequest = new AddTermRequest();
        AddTermResponse addTermResponse = this.doPost(addTermRequest);
    }

    /**
     * 删除设备
     */
    public void delTerm(){
        DelTermRequest delTermRequest = new DelTermRequest();
        DelTermResponse delTermResponse = this.doPost(delTermRequest);
    }

    /**
     * 查询人员信息
     */
    public void getPersons(){
        GetPersonsRequest getPersonsRequest = new GetPersonsRequest();
        GetPersonsResponse getPersonsResponse = this.doPost(getPersonsRequest);
    }

    public static void main(String[] args) {
//        XkpApiClient xkpApiClient = new XkpApiClient();
//        xkpApiClient.getToken();

        Map<String, Object> map = new HashMap<>();
        map.put("1", "123");
        map.put("2", "456");
        map.put("3", "789");
        System.out.println(map);
    }


}
