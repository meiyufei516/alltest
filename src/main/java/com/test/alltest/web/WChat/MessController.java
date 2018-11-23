package com.test.alltest.web.wchat;

import com.test.alltest.config.SysConfig;
import com.test.alltest.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author MeiYF
 * @time 2018/11/23 16:29
 **/
public class MessController {

	private static final Logger logger= LoggerFactory.getLogger(MessController.class);
	@Autowired
	private SysConfig sysConfig;
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
			//开发者微信号
			String toUserName = requestMap.get("ToUserName");
			//发送方帐号(open_id)
			String fromUserName = requestMap.get("FromUserName");
			//消息创建时间
			String createTime = requestMap.get("CreateTime");
			//消息id，64位整型
			String msgId = requestMap.get("MsgId");
			StringBuilder sb=new StringBuilder();
			sb.append("<xml>"
					+"<ToUserName><![CDATA["+fromUserName+"]]></ToUserName>"
					+"<FromUserName><![CDATA["+toUserName+"]]></FromUserName>"
					+"<CreateTime><![CDATA["+System.currentTimeMillis()+"]]></CreateTime>");
			//消息类型
			String msgType = requestMap.get("MsgType");
			if(StaticContent.MSGTYPE_TEXT.equals(msgType)){
				//文本信息
				//微信服务器post过来的内容
				String weixinContent = requestMap.get("Content");
				logger.info("【"+LogTime.getLogTime()+"】用户发送过来的文本消息内容是【"+weixinContent+"】");
				if(StaticContent.MSGTYPE_IMAGE_TEXT.equals(weixinContent)){
					//图文信息
					sb.append("<MsgType><![CDATA[news]]></MsgType>"
							+"<ArticleCount>2</ArticleCount>"
							+"<Articles>"
							+"<item>"
							+"<Title><![CDATA[我是图片1的标题]]></Title> "
							+"<Description><![CDATA[图片1内容]]></Description>"
							+"<PicUrl><![CDATA[http://img03.tooopen.com/uploadfile/downs/images/20110714/sy_20110714135215645030.jpg]]></PicUrl>"//项目图片地址
							+"<Url><![CDATA[https://baijiahao.baidu.com/s?id=1617911349814046774&wfr=spider&for=pc]]></Url>"//自己工程项目地址 例如：http://ip/项目名/queryList.do?openid=toUserName
							+"</item>"
							+"<item>"
							+"<Title><![CDATA[我是图片2的标题]]></Title>"
							+"<Description><![CDATA[图片2内容]]></Description>"
							+"<PicUrl><![CDATA[http://5b0988e595225.cdn.sohucs.com/images/20170906/58cdb24be3624488ad3e8d3d00b4585f.jpeg]]></PicUrl>"
							+"<Url><![CDATA[https://news.online.sh.cn/news/gb/content/2018-11/23/content_9121824.htm]]></Url>"
							+"</item>"
							+"</Articles>"
							+"</xml>");
				}else{
					sb.append("<MsgType><![CDATA[text]]></MsgType>"
							+"<Content><![CDATA[欢迎您访问我的测试号！您发送的是："+weixinContent+"]]></Content>"
							+"</xml>");
				}
			}else if(StaticContent.MSGTYPE_IMAGE.equals(msgType)){
				//图片信息
				//图片链接（由系统生成）
				String picUrl = requestMap.get("PicUrl");
				//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
				String mediaId = requestMap.get("MediaId");
				logger.info("【"+LogTime.getLogTime()+"】用户发送过来的图片消息的图片链接【"+picUrl+"】，图片消息媒体id【"+mediaId+"】");
				sb.append("<MsgType><![CDATA[text]]></MsgType>"
						+"<Content><![CDATA[欢迎您访问我的测试号！您发的图片是："+picUrl+"]]></Content>"
						+"</xml>");
			}else if(StaticContent.MSGTYPE_VOICE.equals(msgType)){
				//语音信息

			}else if(StaticContent.MSGTYPE_VIDEO.equals(msgType)){
				//视频信息

			}else if(StaticContent.MSGTYPE_SHORTVIDEO.equals(msgType)){
				//小视频信息

			}else if(StaticContent.MSGTYPE_LINK.equals(msgType)){
				//链接信息
				//消息标题
				String title = requestMap.get("Title");
				//消息描述
				String description = requestMap.get("Description");
				//消息链接
				String url = requestMap.get("Url");
				logger.info("【"+LogTime.getLogTime()+"】用户发送过来的地理位置消息的消息标题【"+title+"】，消息描述【"+description+"】，消息链接【"+url+"】");
				sb.append("<MsgType><![CDATA[text]]></MsgType>"
						+"<Content><![CDATA[欢迎您访问我的测试号！收到您消息链接："+url+"]]></Content>"
						+"</xml>");
			}else if(StaticContent.MSGTYPE_LOCATION.equals(msgType)){
				//地理位置信息
				//地理位置维度
				String location_X = requestMap.get("Location_X");
				//地理位置经度
				String location_Y = requestMap.get("Location_Y");
				//地图缩放大小
				String scale = requestMap.get("Scale");
				//地理位置信息
				String label = requestMap.get("Label");
				logger.info("【"+LogTime.getLogTime()+"】用户发送过来的地理位置消息的地理位置维度【"+location_X+"】，地理位置经度【"+location_Y+"】，地图缩放大小【"+scale+"】，地理位置信息【"+label+"】");
				sb.append("<MsgType><![CDATA[text]]></MsgType>"
						+"<Content><![CDATA[欢迎您访问我的测试号！收到您的地理位置："+label+"]]></Content>"
						+"</xml>");
			}
			// 响应回复消息
			PrintWriter out = response.getWriter();
			out.print(sb);
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
}
