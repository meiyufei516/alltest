package com.test.alltest.domain.weixinDomain.menuDomain;

/**
 * @author MeiYF
 * @time 2018/11/21 15:28
 **/
public class ReturnMess {
	private String errcode;     //返回码
	private String errmsg;      //说明
	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
