package com.test.alltest.schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.alltest.config.CashClass;
import com.test.alltest.config.SysConfig;
import com.test.alltest.domain.weixinDomain.AccessToken;
import com.test.alltest.util.GetCHNErrmsg;
import com.test.alltest.util.HttpRequestUtil;
import com.test.alltest.util.LogTime;
import com.test.alltest.util.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MeiYF
 * @time 2018/11/21 13:26
 **/
@Component
public class AutoGetAccessToken {

	private static final Logger logger= LoggerFactory.getLogger(AutoGetAccessToken.class);
	private ApplicationContext applicationContext = SpringUtils.getApplicationContext();
	private SysConfig sysConfig ;

	/**
	 * 每一小时获取一次access_token
	 */
	@Scheduled(cron = "0 0 0/1 * * ?")
	public void autoGetAccessToken(){
		if(sysConfig==null){
			sysConfig = applicationContext.getBean(SysConfig.class);
		}
		Map<String,Object> paramMap=new HashMap<>(3);
		paramMap.put("grant_type","client_credential");
		paramMap.put("appid",sysConfig.getWxAppID());
		paramMap.put("secret",sysConfig.getWxAppSecret());
		try {
			String result=HttpRequestUtil.httpGet("https://api.weixin.qq.com/cgi-bin/token",paramMap,"utf-8");
			AccessToken accessToken=new ObjectMapper().readValue(result, AccessToken.class);
			String errorCode=accessToken.getErrcode();
			if(org.springframework.util.StringUtils.isEmpty(errorCode)){
				//如果获取成功，就把获取到的access_token存入缓存
				CashClass.access_token=accessToken.getAccess_token();
				logger.info("【"+LogTime.getLogTime()+"】接收到的access_token是："+accessToken.getAccess_token());
			}else{
				//如果没有获取成功
				logger.info("【"+LogTime.getLogTime()+"】获取access_token失败,errcode：【"+accessToken.getErrcode()+"】,说明：【"+GetCHNErrmsg.getCHNErrmsg(accessToken.getErrcode())+"】,errmsg:【"+accessToken.getErrmsg()+"】");
			}
		} catch (Exception e) {
			logger.error("【"+LogTime.getLogTime()+"】获取access_token时Https访问失败："+e.getMessage());
		}
	}
}
