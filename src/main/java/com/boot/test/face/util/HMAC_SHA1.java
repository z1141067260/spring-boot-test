package com.boot.test.face.util;

import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
/**
 * Title: HMAC_SHA1.java
 * Description: HMAC_SHA1加密
 */
public class HMAC_SHA1 {

	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	private static Mac mac = null;

	public HMAC_SHA1(String HMAC_SHA1_KEY) throws NoSuchAlgorithmException, InvalidKeyException{
		//根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
		SecretKeySpec signinKey = new SecretKeySpec(HMAC_SHA1_KEY.getBytes(), HMAC_SHA1_ALGORITHM);
		//生成一个指定 Mac 算法 的 Mac 对象
		mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		//用给定密钥初始化 Mac 对象
		mac.init(signinKey);
	}

    /**
     * 加密图片HAX数据
     * @param data
     * @return
     */
    public String genHMAC(byte[] data) {
        byte[] result = null;
        if (mac==null) {
            return null;
        }
        //将byte[]转十六进制String
        String datastr = byte2hex(data);
        //完成 Mac 操作
        byte[] rawHmac = mac.doFinal(datastr.getBytes());
        result = Base64.getEncoder().encode(rawHmac);
        if (null != result) {
            return new String(result);
        } else {
            return null;
        }
    }
    
    
    /**
	 * byte[]转十六进制String
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		try {
			if ((b == null) || (b.length <= 0)) {
				return null;
			}
			StringBuffer sb = new StringBuffer();
			String stmp = "";
			for (int n = 0; n < b.length; ++n) {
				stmp = Integer.toHexString(b[n] & 0xFF);
				if (stmp.length() == 1)
					sb.append("0" + stmp);
				else {
					sb.append(stmp);
				}
			}

			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
