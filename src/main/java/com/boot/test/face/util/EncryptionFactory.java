package com.boot.test.face.util;

/** 
 * <p>Title: EncryptionFactory.java</p>  
 * <p>Description: 加解密工厂</p>  
 */
public class EncryptionFactory {

	/**
	  * @Title:			tDecryptDES 
	  * @Description:	解密
	  * @param:			@param secretalgorithm  密钥算法 ，1：3DESC 2DESC
	  * @param:			@param key
	  * @param:			@param data
	  * @param:			@return
	  * @return: 		String
	 */
	public static String tDecryptDES(Integer secretalgorithm,String key,String data) {  
        switch (secretalgorithm) {
	        case 1:  //3DESC
	        	return ThreeDESUtil.decryptMode(key, data);
	        case 2: //DESC
				return null;
	        case 3: 
	        	return null;
	        default:  
	            break;  
        }  
        return null;
    }
	
	/**
	  * @Title:			tEncryptDES
	  * @Description:	加密
	  * @param:			@param secretalgorithm  密钥算法 ，1：3DESC 2DESC
	  * @param:			@param key
	  * @param:			@param data
	  * @param:			@return
	  * @return: 		String
	 */
	public static String tEncryptDES(Integer secretalgorithm,String key,String data) {  
        switch (secretalgorithm) {
	        case 1:  //3DESC
	        	return ThreeDESUtil.encryptMode(key, data);
	        case 2://DESC
				return null;
	        case 3: 
	        	return null;
	        default:  
	            break;  
        }  
        return null;
    }
	
}
