package com.test.alltest.domain.weixinDomain.menuDomain;

import java.util.List;

/**
 * @author MeiYF
 * @time 2018/11/21 14:36
 **/
public class Button {
	private String name;//必须,菜单标题，不超过16个字节，子菜单不超过60个字节
	private String type;//必须,菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
	private String key;//click等点击类型必须,菜单KEY值，用于消息接口推送，不超过128字节
	private String url;//view、miniprogram类型必须,网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
	private String media_id;//media_id类型和view_limited类型必须,调用新增永久素材接口返回的合法media_id
	private String appid;//miniprogram类型必须,小程序的appid（仅认证公众号可配置）
	private String pagepath;//miniprogram类型必须,小程序的页面路径
	private List<Button> sub_button;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public List<Button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<Button> sub_button) {
		this.sub_button = sub_button;
	}
}
