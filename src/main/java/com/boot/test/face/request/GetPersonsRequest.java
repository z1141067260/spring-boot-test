package com.boot.test.face.request;

import com.boot.test.face.response.GetPersonsResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author WangW
 * @date 2020/11/24 13:45
 * @description 查询人员信息
 */
public class GetPersonsRequest extends AbstractRequestBase<GetPersonsResponse>{


    private final String URL = "/managerapi/getpersons";

    public String method = "POST";

    private MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();


    private String outid;

    private String ver;

    private String ecode;

    private Integer pagesize;

    public String getOutid() {
        return outid;
    }

    public void setOutid(String outid) {
        this.outid = outid;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
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
        return null;
    }

    @Override
    public Class<GetPersonsResponse> getResponse() {
        return GetPersonsResponse.class;
    }
}
