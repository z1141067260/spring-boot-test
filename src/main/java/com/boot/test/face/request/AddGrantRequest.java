package com.boot.test.face.request;

import com.alibaba.fastjson.JSONObject;
import com.boot.test.face.response.AddGrantResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangW
 * @date 2020/11/24 10:26
 * @description 添加授权名单
 */
public class AddGrantRequest extends AbstractRequestBase<AddGrantResponse> {

    private final String URL = "/managerapi/addgrant";

    public String method = "POST";

    private MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();


    private List<Grants> grants;

    public List<Grants> getGrants() {
        return grants;
    }

    public void setGrants(String termcode, String outid, String name, String startime, String endtime) {
        Grants grants = new Grants(termcode, outid, name, startime, endtime);
        this.grants = new ArrayList<>();
        this.grants.add(grants);
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
    public <T> T getRequestMap() {
        if(grants==null || grants.isEmpty()){
            throw new RuntimeException("参数值不能为空[grants]");
        }
        JSONObject json = new JSONObject();
        json.put("grants", grants);

        JSONObject params = new JSONObject();
        params.put("request_data", json);
        return null;
    }

    @Override
    public Class<AddGrantResponse> getResponse() {
        return AddGrantResponse.class;
    }


    private class Grants {

        private String termcode;

        private String outid;

        private String name;

        private String starttime;

        private String endtime;

        public Grants(String termcode, String outid, String name, String starttime, String endtime) {
            this.termcode = termcode;
            this.outid = outid;
            this.name = name;
            this.starttime = starttime;
            this.endtime = endtime;
        }

        public String getTermcode() {
            return termcode;
        }

        public void setTermcode(String termcode) {
            this.termcode = termcode;
        }

        public String getOutid() {
            return outid;
        }

        public void setOutid(String outid) {
            this.outid = outid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }
    }
}
