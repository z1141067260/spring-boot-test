package com.boot.test.face.request;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.boot.test.face.response.AddTermResponse;
import com.boot.test.face.response.DelTermResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author WangW
 * @date 2020/11/24 10:15
 * @description 删除设备
 */
public class DelTermRequest extends AbstractRequestBase<DelTermResponse>{

    private final String URL = "/managerapi/deleteterm";

    public String method = "POST";

    private MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

    @JSONField(name = "termcode")
    private String termcode;

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    @Override
    public MultiValueMap<String, String> getHeader() {
        headers.add("access_token", "");
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
    public Class<DelTermResponse> getResponse() {
        return DelTermResponse.class;
    }

    @Override
    public Object getRequestMap() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("termcode", termcode);
        return jsonObject.toString();
    }
}
