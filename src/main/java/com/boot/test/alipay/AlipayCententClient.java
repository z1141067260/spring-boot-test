package com.boot.test.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.boot.test.alipay.pojo.OrderCreatePojo;
import com.boot.test.alipay.pojo.QrcodeCreatePojo;
import com.boot.test.alipay.pojo.SkuCreateInfoPojo;
import com.boot.test.model.userBean;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WangW
 * @date 2020/11/05 16:24
 * @description 阿里云客户端配置中心
 */
public class AlipayCententClient {


    /**
     * 订单支付回调地址
     */
    private static String notifyOrderUrl = "回调地址";

    /**
     * OpenApi网关调用地址
     * 线上：https://openapi.alipay.com/gateway.do
     * 沙盒：https://openapi.alipaydev.com/gateway.do
     */
    private static String serverUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 支付宝分配给开发者的应用ID
     */
    private static String appId = "2016103100780929";

    /**
     * 通过RSA2生成的私钥
     */
    private static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCnm/YoZnJ8odWL0gUFI6B8fw2HmQ46uSuehtI2+QWWAxwqHG1lBdvpBQ+WI+AUJDZK0PM+5k1Gpqincp9bIGGvYYP5L8kH/9KgaJvVFIuKKwF5av1BaZgEeqmdmUC2lCNXyd+S5kwvQdTZQAn9gM8pNWwB+jdJRGz5spRetN/vggpbkO5OUNiYdQPnj2nPEe8nt2ptfpxBmveEmkW42YXjPr3vk1eCPY6LYFjJZcTZMTEmw32bXp6faV5/sybxDL5J/XH1L5EPT4vunQjI6jjCclQRGUYoRk7YKlrkI2odX41mhB5uB7b0cbnCkeAiYxYC6A3Sz0pka0zqWzj2UdznAgMBAAECggEAPs3M7hR9P8AwUWUP5n4UC7Jb8nxifZSXCJ7CNEEZW72slwbx4tHQNj9kOMEWnNV41o33J5GKUTfvqFbl6XJ3yAzFM+E49dthJCQuiChbpRk6QzHY1eLoSH1iAyDCw+c8Ww/Uy6mp0Gddh05cr/XNKkbPQupsPvL51pKYz+f8pTS8yjxl/2fExodLc7uRNpe5i94UHAeo83lk/It08mDAZ3ODsPMs59RGVSWPOwO/KRLOGXPOqohOhG81Q/ksD0q8he/i0nVFLOqIkgC9QOE+hv1NQUiG6L1dIwejRCZz4Kkqmnq19hKUkPYYkrMBhFuqEA8XIab81YiiGaDv6LJnqQKBgQDPRaSBlNCnopCvgufTo3nvw3hgZn3dLfLgLYKctPoNfWuGBjFs0CqM0Ky0rNjA5OoCgki9pMSCh/G7JBojUi1fQvP4ZYSj0Jfwm+ZS6h8ZxYCANAkgloiLnWwO19GgqENBmhS0MtIqaGdnltw5LylCjhTOLL9X0FrpBwGHrjQr1QKBgQDPA0WQaRY7gdqCgF+wFaEmKlc+4SyKdjgCmHtrcsuPtJBaTEiDYvLdmm2KkKFiL2hPZ5xI83mQLyJjSRmE9zwR3fhBdlBUSp1ngbHZjt9POzPwS8v6Ox6Ot0ziJUIjnqcROcmNkBzooieZNPtG0eVpoJ4sovxavJ8ryjdJCcsvywKBgQC6RzmwZ6Ead2SXCAv3TZ1h2QfPg20soYX86YnP8mokQ4ql2d0DkRYcldIRUqI+wbx54sMjBPjC4xBiAvEmu00hpxeCLyKE4wwaZtIZxGWNEM4K6jklu4QeDa22rUmtnGtNgv+Gb4IoMMp188QZ9IOdV/nkzZxtfEin0u8SFIK4vQKBgCwj0HNoVNs/Zu4onT6YfhH7OTspHCwx5ON4y+gvRARSRe1bEqMhOBPUV8MR77dV0HIN758Ge0cpJbXx4kUdymss30BmD97JQiLN3rQ66JamUv7LyqSCcpOPtg8KTr31mD3uCnHq5p8b5EGgsGt7WeVZ4CA4aIKYcYAO0Bb8xZxdAoGBALDBSrK+um42O4OtngkA2Z9JtNvsw7oQSYlH2ooOaFIJ+JG3cCGC+Cmy5/mYf2l1uKJkhpVXZILuzm7oSD3p8hDErwmGjNswi56N3aPD1H9IHHFiVwjhuFETNxfCXjuRCJdBRPumUSwP965lrICTmL+kvnsC6sB2GYBy4P1SgOOp";

    /**
     * 仅支持JSON
     */
    private static String format = "json";

    /**
     * 请求使用的编码格式，如utf-8,gbk,gb2312等
     */
    private static String charset = "utf-8";

    /**
     * 支付宝提供公钥
     */
    private static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAijwwNxIYH7XfGZmkCwyQh/Uje7pXgz15LGX76QAEMvNblPy5do0HLUEng8MB0A7XvQTBVi5uC3kQ1PSA69W87efa6TgjPDYun2+/2l5q2RBfPGsQGVT3VMyZMkHWkY/0hMD0CY2noxTCnrRbJhyfPCrtJXh5n92HeYyCwExkZWCbusUdJzZRuWW0USpAuxM5yA5+ixDBQLPyizowdVfa+9E4xCy1oxrfg6GAHS058LISEtCseYPVlNgpZDftvCn9gILVm8cuU4pD7gp9E/Eya1Gux/Bx6U2etJ/tNXUkZ6hoGFdfDJ7zKmX35DvYoN2BNasyP9A3VZe2hRt7B7epIwIDAQAB";

    /**
     * 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     */
    private static String signType = "RSA2";

    /**
     * 阿里云调用客户端
     */
    private static AlipayClient alipayClient = new DefaultAlipayClient(
            serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);

    private AlipayCententClient(){}

    public static AlipayClient getAlipayClient() {
        return alipayClient;
    }

    public static String getNotifyOrderUrl() {
        return notifyOrderUrl;
    }

    public static String getCharset() {
        return charset;
    }

    public static String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public static String getSignType() {
        return signType;
    }

    public static String getAppId() {
        return appId;
    }

    public static void main(String[] args) {
//        OrderCreatePojo tradeCreate = new OrderCreatePojo();
//        tradeCreate.setOutTradeNo("订单编号");
//        tradeCreate.setSellerId("卖家支付宝用户ID");
//        tradeCreate.setTotalAmount("订单金额");
//        tradeCreate.setSubject("订单标题");
//        tradeCreate.setBuyerId("买家的支付宝唯一用户号");
//        tradeCreate.setReceiverAddressInfo("收货人姓名","收货人地址", "收货人手机号", null, "sdfsdfsdfsdf");
//        String bizCentext = tradeCreate.toString();
//        System.out.println(bizCentext);
//
//        JSONObject jsonObject = JSONObject.parseObject(bizCentext);
//
//        System.out.println(jsonObject);


        List<SkuCreateInfoPojo> list = new ArrayList<>();


        SkuCreateInfoPojo t = new SkuCreateInfoPojo();
        t.setPrice(0);
        t.setInventory(1);
        list.add(t);

        SkuCreateInfoPojo t1 = new SkuCreateInfoPojo();
        t1.setPrice(4);
        t1.setInventory(1);
        list.add(t1);

        SkuCreateInfoPojo t2 = new SkuCreateInfoPojo();
        t2.setPrice(1);
        t2.setInventory(1);
        list.add(t2);

        SkuCreateInfoPojo t3 = new SkuCreateInfoPojo();
        t3.setPrice(1);
        t3.setInventory(1);
        list.add(t3);

//        list = list.stream().sorted(Comparator.comparing(SkuCreateInfoPojo::getPrice)).collect(Collectors.toList());
        List<List<SkuCreateInfoPojo>> listList = new ArrayList<>();




        for (SkuCreateInfoPojo skuCreateInfoPojo : list) {
            List<SkuCreateInfoPojo> s = new ArrayList<>();
            if(listList.size() > skuCreateInfoPojo.getPrice()){
                try {
                    s = listList.get(skuCreateInfoPojo.getPrice());
                }catch (IndexOutOfBoundsException e){ //只捕获数组下标越界异常，双重保险
                    s = new ArrayList<>();
                }
            } else {
                Integer sg = skuCreateInfoPojo.getPrice() - listList.size();
                for (int i = 0; i < sg; i++){
                    listList.add(new ArrayList<>());
                }
                listList.add(skuCreateInfoPojo.getPrice(), s);
            }
            s.add(skuCreateInfoPojo);
        }

        System.out.println("sssss");
    }
}
