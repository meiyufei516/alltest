package com.test.alltest.web.wchat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.alltest.config.CashClass;
import com.test.alltest.config.SysConfig;
import com.test.alltest.domain.weixinDomain.AccessToken;
import com.test.alltest.domain.weixinDomain.menuDomain.ReturnMess;
import com.test.alltest.util.AjaxReturnBean;
import com.test.alltest.util.GetCHNErrmsg;
import com.test.alltest.util.HttpRequestUtil;
import com.test.alltest.util.LogTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MeiYF
 * @time 2018/11/20 15:36
 **/
@Controller
public class MenuController {

	private static final Logger logger= LoggerFactory.getLogger(MenuController.class);

	/**
	 * 进入微信菜单管理系统页面
	 * @return
	 */
	@RequestMapping("/toWeiChatManag")
	public String toWeiChatManag(){
		return "/wchat/WChatMenuMana";
	}


	/**
	 * 创建微信自定义菜单
	 * 	   菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
	 * 如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，
	 * 如果菜单有更新，就会刷新客户端的菜单。
	 * 测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
	 * @param request
	 * @return
	 */
	@RequestMapping("/createMenue")
	@ResponseBody
	public AjaxReturnBean createMenue(HttpServletRequest request){
		//检查access_token是否存在，不存在就要去查询
		int returnCode=CheckAccessTokenController.checkAccessToken();
		if(returnCode==1){
			return AjaxReturnBean.createError("创建菜单失败！");
		}

		//获取页面传递的参数
		Map<String, String[]> parameterMap=request.getParameterMap();
		String menuNum=parameterMap.get("menuNum")[0];
		//封装需要生成菜单的参数
		Map<String ,Object> m2=new HashMap<>();
		List<Map> l=new ArrayList<>();
		if(menuNum.equals("1")){
			String menuName1=parameterMap.get("menuName1")[0];
			Map<String,String> m=new HashMap<>();
			m.put("name",menuName1);
			m.put("type","click");
			m.put("key","V1001_TODAY_MUSIC");
			l.add(m);
			m2.put("button",l);
		}else if(menuNum.equals("2")){
			List<String> menuNameList=new ArrayList<>();
			menuNameList.add(parameterMap.get("menuName1")[0]);
			menuNameList.add(parameterMap.get("menuName2")[0]);

			for (int i=0;i<menuNameList.size();i++){
				Map<String,String> m=new HashMap<>();
				m.put("name",menuNameList.get(i));
				m.put("type","click");
				m.put("key","V1001_TODAY_MUSIC");
				l.add(m);
			}
			m2.put("button",l);
		}else if(menuNum.equals("3")){
			List<String> menuNameList=new ArrayList<>();
			menuNameList.add(parameterMap.get("menuName1")[0]);
			menuNameList.add(parameterMap.get("menuName2")[0]);
			menuNameList.add(parameterMap.get("menuName3")[0]);
			for (int i=0;i<menuNameList.size();i++){
				Map<String,String> m=new HashMap<>();
				m.put("name",menuNameList.get(i));
				m.put("type","click");
				m.put("key","V1001_TODAY_MUSIC");
				l.add(m);
			}
			m2.put("button",l);
		}
		try {
			//map转json
			String jsonStr = new ObjectMapper().writeValueAsString(m2);
			logger.info("【"+LogTime.getLogTime()+"】生成的创建菜单json是：【"+jsonStr+"】");
			String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+CashClass.access_token;
			try {
				//发送https请求
				String result=HttpRequestUtil.httpPost(url,jsonStr);
				logger.info("【"+LogTime.getLogTime()+"】发送的创建菜单Https请求返回的json是：【"+result+"】");
				ReturnMess returnMess=new ObjectMapper().readValue(result, ReturnMess.class);
				if(returnMess.getErrcode().equals("0")){
					return AjaxReturnBean.createSuccess("创建菜单成功，请刷新微信公账号获取最新数据！");
				}else{
					logger.info("【"+LogTime.getLogTime()+"】创建菜单失败,errcode：【"+returnMess.getErrcode()+"】,说明：【"+GetCHNErrmsg.getCHNErrmsg(returnMess.getErrcode())+"】,errmsg:【"+returnMess.getErrmsg()+"】");
					return AjaxReturnBean.createError("创建菜单失败："+GetCHNErrmsg.getCHNErrmsg(returnMess.getErrcode()));
				}
			} catch (Exception e) {
				logger.error("【"+LogTime.getLogTime()+"】创建菜单时Https访问失败："+e.getMessage());
			}
		} catch (JsonProcessingException e) {
			logger.error("【"+LogTime.getLogTime()+"】生成的创建菜单json失败："+e.getMessage());
		}
		return AjaxReturnBean.createError("创建菜单失败！");
	}

	/**
	 * 查询自定义菜单
	 * @return
	 */
	@RequestMapping("/quaryMenu")
	@ResponseBody
	public AjaxReturnBean quaryMenu(){
		//检查access_token是否存在，不存在就要去查询
		int returnCode=CheckAccessTokenController.checkAccessToken();
		if(returnCode==1){
			return AjaxReturnBean.createError("查询菜单失败！");
		}

		//封装查询菜单的参数
		Map<String,Object> paramMap=new HashMap<>(1);
		paramMap.put("access_token",CashClass.access_token);

		try {
			//发送Https请求
			String result=HttpRequestUtil.httpGet("https://api.weixin.qq.com/cgi-bin/menu/get",paramMap,"utf-8");
			if(result.contains("errcode")){
				ReturnMess returnMess=new ObjectMapper().readValue(result, ReturnMess.class);
				logger.info("【"+LogTime.getLogTime()+"】查询菜单失败,errcode：【"+returnMess.getErrcode()+"】,说明：【"+GetCHNErrmsg.getCHNErrmsg(returnMess.getErrcode())+"】,errmsg:【"+returnMess.getErrmsg()+"】");
				return AjaxReturnBean.createError("查询菜单失败："+GetCHNErrmsg.getCHNErrmsg(returnMess.getErrcode()));
			}else{
				//查询
				logger.info("【"+LogTime.getLogTime()+"】查询菜单成功："+result);
				return AjaxReturnBean.createSuccess("查询菜单成功："+result);
			}
		} catch (Exception e) {
			logger.error("【"+LogTime.getLogTime()+"】查询菜单时Https访问失败："+e.getMessage());
		}
		return AjaxReturnBean.createError("查询菜单失败！");
	}

	/**
	 * 删除自定义菜单
	 * @return
	 */
	@RequestMapping("/deleteMenu")
	@ResponseBody
	public AjaxReturnBean deleteMenu(){
		//检查access_token是否存在，不存在就要去查询
		int returnCode=CheckAccessTokenController.checkAccessToken();
		if(returnCode==1){
			return AjaxReturnBean.createError("删除菜单失败！");
		}

		//封装删除菜单的参数
		Map<String,Object> paramMap=new HashMap<>(1);
		paramMap.put("access_token",CashClass.access_token);

		try {
			//发送Https请求
			String result=HttpRequestUtil.httpGet("https://api.weixin.qq.com/cgi-bin/menu/delete",paramMap,"utf-8");
			AccessToken accessToken=new ObjectMapper().readValue(result, AccessToken.class);
			String errorCode=accessToken.getErrcode();
			if(errorCode.equals("0")){
				//删除成功
				logger.info("【"+LogTime.getLogTime()+"】删除菜单成功。");
				return AjaxReturnBean.createError("删除菜单成功，请刷新微信公账号获取最新数据！");
			}else{
				logger.info("【"+LogTime.getLogTime()+"】删除菜单失败,errcode：【"+accessToken.getErrcode()+"】,说明：【"+GetCHNErrmsg.getCHNErrmsg(accessToken.getErrcode())+"】,errmsg:【"+accessToken.getErrmsg()+"】");
				return AjaxReturnBean.createError("删除菜单失败："+GetCHNErrmsg.getCHNErrmsg(accessToken.getErrcode()));
			}
		} catch (Exception e) {
			logger.error("【"+LogTime.getLogTime()+"】删除菜单时Https访问失败："+e.getMessage());
		}
		return AjaxReturnBean.createError("删除菜单失败！");
	}
}
