package com.boot.test.face.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>Title: EncryptionFactory.java</p>
 * <p>Description: 3DESC加解密</p>
 */
public class ThreeDESUtil {

	// 定义加密算法
	private static final String Algorithm = "DESede";

	public static void main(String[] args) {
		System.out.println(encryptMode("12345678abcdefgh87654321", "BtrvIeiY1Cv6UoNeTre4"));
	}
	/**
	  * @Title:			encryptMode 
	  * @Description:	加密
	  * @param:			@param src
	  * @param:			@param key
	  * @param:			@return
	  * @return: 		String
	  * @author:		李园园
	  * @data:			2018年5月25日
	 */
	public static String encryptMode(String key,String src) {
		try {
			return URLEncoder.encode(Base64.encodeBase64String(encryptMode(src.getBytes("utf-8"), key)), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 加密 src为源数据的字节数组
	public static byte[] encryptMode(byte[] src,String key) throws Exception {
		SecretKey deskey = new SecretKeySpec(build3Deskey(key), Algorithm);
		// 实例化cipher
		Cipher cipher = Cipher.getInstance(Algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		return cipher.doFinal(src);
	}


	/**
	  * @Title:			decryptMode 
	  * @Description:	 解密函数
	  * @param:			@param src
	  * @param:			@param key
	  * @param:			@return
	  * @param:			@throws Exception
	  * @return: 		byte[]
	 */
	public static String decryptMode(String key,String src) {
		try {
			src = URLDecoder.decode(src,"UTF-8");
			return new String(decryptMode(Base64.decodeBase64(src),key),"utf-8");
		} catch (Exception e) {

		}
		return null;
	}
	
	// 解密函数
	public static byte[] decryptMode(byte[] src,String key) throws Exception {
		SecretKey deskey;
		deskey = new SecretKeySpec(build3Deskey(key), Algorithm);
		Cipher cipher = Cipher.getInstance(Algorithm);
		cipher.init(Cipher.DECRYPT_MODE, deskey);
		return cipher.doFinal(src);
	}

	// 根据字符串生成密钥24位的字节数组
	public static byte[] build3Deskey(String keystr) throws Exception {
		byte[] key = new byte[24];
		byte[] temp = keystr.getBytes("utf-8");
		if (key.length > temp.length) {
			System.arraycopy(temp, 0, key, 0, temp.length);

		} else {
			System.arraycopy(temp, 0, key, 0, key.length);

		}
		return key;
	}

}
