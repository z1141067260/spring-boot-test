package com.boot.test.alipay.request.item;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.FileItem;
import com.alipay.api.request.AlipayMerchantItemFileUploadRequest;
import com.alipay.api.request.AntMerchantExpandItemOpenCreateRequest;
import com.alipay.api.request.AntMerchantExpandItemOpenQueryRequest;
import com.alipay.api.response.AlipayMerchantItemFileUploadResponse;
import com.alipay.api.response.AntMerchantExpandItemOpenCreateResponse;
import com.alipay.api.response.AntMerchantExpandItemOpenQueryResponse;
import com.boot.test.alipay.AlipayCententClient;

/**
 * @author WangW
 * @date 2020/11/10 15:07
 * @description 订单中心商品操作类
 */
public class ExpandItemRequest {


    public static AlipayMerchantItemFileUploadResponse fileUpload(){
        AlipayMerchantItemFileUploadRequest request = new AlipayMerchantItemFileUploadRequest();
        request.setScene("SYNC_ORDER");
        FileItem FileContent = new FileItem("C:/Downloads/ooopic_963991_7eea1f5426105f9e6069/16365_1271139700.jpg");
        request.setFileContent(FileContent);
        AlipayMerchantItemFileUploadResponse response = null;
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
     * 创建商品接口
     * 参考文献：https://opendocs.alipay.com/apis/api_4/ant.merchant.expand.item.open.create/
     * 注：api_4对应SDK4以上版本
     * @param expandItemRequest
     * @return
     */
    public static AntMerchantExpandItemOpenCreateResponse itemOpenCreate(ExpandItemRequest expandItemRequest){
        AntMerchantExpandItemOpenCreateRequest request = new AntMerchantExpandItemOpenCreateRequest();
        request.setBizContent(expandItemRequest.toString());
        AntMerchantExpandItemOpenCreateResponse response = null;
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
     * 查询商品接口
     * 参考文献：https://opendocs.alipay.com/apis/api_4/ant.merchant.expand.item.open.query/
     * @param scene 必选         场景码（具体值请参见产品文档）: COMMON
     * @param targetId 必选      商品归属主体ID
     * @param targetType 必选    商品归属主体类型: 5（店铺） 8（小程序）
     * @param status 可选        商品状态：EFFECT（有效）、INVALID（无效）
     * @return
     */
    public static AntMerchantExpandItemOpenQueryResponse itemOpenQuery(String scene, String targetId, String targetType, String status){
        AntMerchantExpandItemOpenQueryRequest request = new AntMerchantExpandItemOpenQueryRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("scene", scene);
        jsonObject.put("target_id", targetId);
        jsonObject.put("target_type", targetType);
        jsonObject.put("status", status);
        request.setBizContent(jsonObject.toJSONString());
        AntMerchantExpandItemOpenQueryResponse response = null;
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
}
