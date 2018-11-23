package com.test.alltest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author MeiYF
 * @time 2018/11/20 13:59
 **/
@Configuration
@ConfigurationProperties(prefix="proj.sys.define")
public class SysConfig {

	private String wxNum;
	private String wxAppID;
	private String wxAppSecret;
	private String wxUrl;
	private String wxToken;
	private String wxEncodingAESKey;
	private String wxUserName;

	public String getWxUserName() {
		return wxUserName;
	}

	public void setWxUserName(String wxUserName) {
		this.wxUserName = wxUserName;
	}

	public String getWxNum() {
		return wxNum;
	}

	public void setWxNum(String wxNum) {
		this.wxNum = wxNum;
	}

	public String getWxAppID() {
		return wxAppID;
	}

	public void setWxAppID(String wxAppID) {
		this.wxAppID = wxAppID;
	}

	public String getWxAppSecret() {
		return wxAppSecret;
	}

	public void setWxAppSecret(String wxAppSecret) {
		this.wxAppSecret = wxAppSecret;
	}

	public String getWxUrl() {
		return wxUrl;
	}

	public void setWxUrl(String wxUrl) {
		this.wxUrl = wxUrl;
	}

	public String getWxToken() {
		return wxToken;
	}

	public void setWxToken(String wxToken) {
		this.wxToken = wxToken;
	}

	public String getWxEncodingAESKey() {
		return wxEncodingAESKey;
	}

	public void setWxEncodingAESKey(String wxEncodingAESKey) {
		this.wxEncodingAESKey = wxEncodingAESKey;
	}
}
