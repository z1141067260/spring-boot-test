package com.boot.test.face.request;

import com.alibaba.fastjson.JSONObject;
import com.boot.test.face.XkpApiClient;
import com.boot.test.face.config.Constants;
import com.boot.test.face.response.ResponseBase;
import com.boot.test.face.response.TokenResponse;
import com.boot.test.face.util.EncryptionFactory;
import org.springframework.util.MultiValueMap;

import java.util.Calendar;

/**
 * @author WangW
 * @date 2020/11/20 17:27
 * @description 通用请求参数
 */
public abstract class AbstractRequestBase<T extends ResponseBase> extends Constants {

    /**
     * 返回请求头
     * @return
     */
    public abstract MultiValueMap<String, String> getHeader();

    /**
     * 返回请求类型
     * @return
     */
    public abstract String getMethod();

    /**
     * 返回请求地址
     * @return
     */
    public abstract String getUrl();

    /**
     * 返回请求body
     * @param <T>
     * @return
     */
    public abstract <T> T getRequestMap();

    /**
     * 返回反参接收类
     * @return
     */
    public abstract Class<T> getResponse();


    protected String jm(String str){
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("request_data", EncryptionFactory.tEncryptDES(Constants.AIFACE_SECRETALGORITHM,
                Constants.AIFACE_SECRETKEY, str));
        return jsonObject.toJSONString();
    }

    protected void inspectToken(){
        if(!nowStr().equals(AIFACE_TIME)){
            refreshToken();
        }
    }

    protected void refreshToken(){
        XkpApiClient xkpApiClient = new XkpApiClient();
        TokenResponse tokenResponse = xkpApiClient.getToken();
        Constants.AIFACE_TOKEN = tokenResponse.getAccessToken();
        Constants.AIFACE_TIME = nowStr();
    }


    public String nowStr(){
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH)+1) + "-" + now.get(Calendar.DAY_OF_MONTH);
    }
}
