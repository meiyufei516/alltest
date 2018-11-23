package com.test.alltest.web.WChat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.alltest.config.CashClass;
import com.test.alltest.config.SysConfig;
import com.test.alltest.domain.weixinDomain.AccessToken;
import com.test.alltest.domain.weixinDomain.menuDomain.ReturnMess;
import com.test.alltest.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
	@Autowired
	private SysConfig sysConfig;

	/**
	 * 进入微信菜单管理系统页面
	 * @return
	 */
	@RequestMapping("/toWeiChatManag")
	public String toWeiChatManag(){
		return "/WChat/WChatMenuMana";
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
		int returnCode=CheckAccessToken.checkAccessToken();
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
		int returnCode=CheckAccessToken.checkAccessToken();
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
		int returnCode=CheckAccessToken.checkAccessToken();
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


	public void messPush(){

	}
	/**
	 * 微信的接口配置的URL地址
	 * @param request
	 * @return
	 */
	@RequestMapping("/*")
	@ResponseBody
	public void wChatContoller(HttpServletRequest request, HttpServletResponse response) throws AesException, IOException {
		boolean flage=request.getMethod().toLowerCase().equals("get");
		if (flage){
			//get请求，验证token
			this.checkToken(request,response);
		}else{
			//post请求，消息
			this.accessMess(request,response);
		}
	}

	/**
	 * 接受消息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void accessMess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try{
			//xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			//发送方帐号(open_id)
			String fromUserName = requestMap.get("FromUserName");
			//公众帐号
			String toUserName = requestMap.get("ToUserName");
			//消息类型
			String msgType = requestMap.get("MsgType");
			//消息创建时间
			String createTime = requestMap.get("CreateTime");
			//地理位置纬度
			String location_X = requestMap.get("Location_X");
			//地理位置经度
			String location_Y = requestMap.get("Location_Y");
			//微信服务器post过来的内容
			String weixinContent = requestMap.get("Content");
			System.out.println("公众号用户发送过来的文本消息内容："+weixinContent);
			String respMessage = "<xml>"
					+"<ToUserName><![CDATA["+fromUserName+"]]></ToUserName>"
					+"<FromUserName><![CDATA["+toUserName+"]]></FromUserName>"
					+"<CreateTime>12345678</CreateTime>"
					+"<MsgType><![CDATA[text]]></MsgType>"
					+"<Content><![CDATA[你妹的]]></Content>"
					+"</xml>";
			// 响应回复消息
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 验证token
	 * @param request
	 * @param response
	 * @return
	 * @throws AesException
	 */
	public String checkToken(HttpServletRequest request, HttpServletResponse response) throws AesException {
		Map<String, String[]> paremeterMap=request.getParameterMap();
		//校验地址
		String signature=paremeterMap.get("signature")[0];
		String timestamp=paremeterMap.get("timestamp")[0];
		String nonce=paremeterMap.get("nonce")[0];
		String echostr= paremeterMap.get("echostr")[0];
		String newSignature = SHA1.getSHA2(sysConfig.getWxToken(),timestamp, nonce);
		if (!signature.equals(newSignature)) {
			logger.info("【"+LogTime.getLogTime()+"】signature验证失败！url校验不成功："+AesException.ValidateSignatureError);
			throw new AesException(AesException.ValidateSignatureError);
		}
		try {
			response.getWriter().write(echostr);
			logger.info("【"+LogTime.getLogTime()+"】成功返回 echostr：" + echostr);
		} catch (IOException e) {
			logger.info("【"+LogTime.getLogTime()+"】返回失败："+e.getMessage());
			return null;
		}
		return echostr;
	}

	/**
	  * java对象转换为xml文件
	  *@param load    java对象.Class
	  * @return    xml文件的String
	  * @throws JAXBException
	  */
     public static String beanToXml(Object obj,Class<?> load) throws JAXBException {
		 JAXBContext context = JAXBContext.newInstance(load);
		 Marshaller marshaller = context.createMarshaller();
		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
		 StringWriter writer = new StringWriter();
		 marshaller.marshal(obj,writer);
		 return writer.toString();
		 }
}
