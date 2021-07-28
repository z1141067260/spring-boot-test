package com.boot.test.face.request;

import com.boot.test.face.response.DelGrantResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangW
 * @date 2020/11/24 11:21
 * @description 移除授权名单
 */
public class DelGrantRequest extends AbstractRequestBase<DelGrantResponse>{


    private final String URL = "/managerapi/removegrant";

    public String method = "POST";

    private MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();


    private String termcode;

    private List<Persons> personsList;

    private Integer clearflag;

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public List<Persons> getPersons() {
        return personsList;
    }

    public void setPersons(String outid, String name) {
        Persons persons = new Persons(outid, name);
        if(personsList == null){
            personsList = new ArrayList<>();
        }
        personsList.add(persons);
    }

    public Integer getClearflag() {
        return clearflag;
    }

    public void setClearflag(Integer clearflag) {
        this.clearflag = clearflag;
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
    public Class<DelGrantResponse> getResponse() {
        return DelGrantResponse.class;
    }

    private class Persons {

        private String outid;

        private String name;

        public Persons(String outid, String name) {
            this.outid = outid;
            this.name = name;
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
    }
}
