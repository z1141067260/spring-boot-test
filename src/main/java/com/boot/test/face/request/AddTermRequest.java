package com.boot.test.face.request;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.boot.test.face.response.AddTermResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

/**
 * @author WangW
 * @date 2020/11/24 9:23
 * @description 添加设备组
 */
public class AddTermRequest extends AbstractRequestBase<AddTermResponse> {

    private final String URL = "/managerapi/createterm";

    public String method = "POST";

    private MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

    @JSONField(name = "termname")
    private String termname;

    @JSONField(name = "termcode")
    private String termcode;

    @JSONField(name = "showname")
    private String showname;

    @JSONField(name = "termtype")
    private Integer termtype;

    @JSONField(name = "ioflag")
    private Integer ioflag = 0;

    @JSONField(name = "address")
    private String address;

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "pwd")
    private String pwd;

    @JSONField(name = "group_code")
    private String groupCode;

    @JSONField(name = "group_name")
    private String groupName;


    public String getTermname() {
        return termname;
    }

    public void setTermname(String termname) {
        this.termname = termname;
    }

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public Integer getTermtype() {
        return termtype;
    }

    public void setTermtype(Integer termtype) {
        this.termtype = termtype;
    }

    public Integer getIoflag() {
        return ioflag;
    }

    public void setIoflag(Integer ioflag) {
        this.ioflag = ioflag;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
    public Class<AddTermResponse> getResponse() {
        return AddTermResponse.class;
    }

    @Override
    public Object getRequestMap() {
        JSONObject json = new JSONObject();
        if(termname == null || termname.equals("")){
            throw new RuntimeException("参数值不能为空[termname]");
        }
        if(termcode == null || termcode.equals("")){
            throw new RuntimeException("参数值不能为空[termcode]");
        }
        if(termtype==null){
            throw new RuntimeException("参数值不能为空[termtype]");
        }
        json.put("termname", termname);
        json.put("termcode", termcode);
        json.put("showname", showname);
        json.put("termtype", termtype);
        json.put("ioflag", ioflag);
        json.put("address", address);
        json.put("uid", uid);
        json.put("pwd", pwd);
        json.put("group_code", groupCode);
        json.put("group_name", groupName);
        return json.toString();
    }
}
