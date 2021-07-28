package com.boot.test.face.config;

public class Constants {
	
	/** 这些内容在demo中仅为举例，第三方系统使用时，请务必自行添加为配置文件类的内容，方便灵活配置修改 **/
	/**
	 * 人脸认证服务平台URL地址
	 */
	protected static final String AIFACE_URL = "http://202.195.195.9:8080/aiface";
	/**
	 * APP_KEY
	 */
	protected static final String AIFACE_APPKEY = "nFBu3c0RfYjj5IgzATLp";
	/**
	 * APP_SECRET
	 */
	protected static final String AIFACE_APPSECRET = "BtrvIeiY1Cv6UoNeTre4";
	/**
	 * 加密密钥
	 */
	protected static final String AIFACE_SECRETKEY = "12345678abcdefgh87654321";
	/**
	 * 加密方式.1:3DESC 目前只支持这一种加密方式
	 */
	protected static final Integer AIFACE_SECRETALGORITHM = 1;
	/** end **/

	/**
	 * 得到令牌后填充
	 */
	protected static String AIFACE_TOKEN =  "";

	protected static String AIFACE_TIME =  "";
}
