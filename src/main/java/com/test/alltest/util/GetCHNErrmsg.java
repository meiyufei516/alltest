package com.test.alltest.util;

/**
 * @author MeiYF
 * @time 2018/11/21 13:37
 **/
public class GetCHNErrmsg {

	/**
	 * 获取传入代码对应的中文含义
	 * @param code
	 * @return
	 */
	public static String getCHNErrmsg(String code){
		if("-1".equals(code)){
			return "系统繁忙，此时请开发者稍候再试";
		}else if("0".equals(code)){
			return "请求成功";
		}else if("40001".equals(code)){
			return "获取 access_token 时 AppSecret 错误，或者 access_token 无效。请开发者认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口";
		}else if("40002".equals(code)){
			return "不合法的凭证类型";
		}else if("40003".equals(code)){
			return "不合法的 OpenID ，请开发者确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID";
		}else if("40004".equals(code)){
			return "不合法的媒体文件类型";
		}else if("40005".equals(code)){
			return "不合法的文件类型";
		}else if("40006".equals(code)){
			return "不合法的文件大小";
		}else if("40007".equals(code)){
			return "不合法的媒体文件 id";
		}else if("40008".equals(code)){
			return "不合法的图片文件大小";
		}else if("40010".equals(code)){
			return "不合法的语音文件大小";
		}else if("40011".equals(code)){
			return "不合法的视频文件大小";
		}else if("40012".equals(code)){
			return "不合法的缩略图文件大小";
		}else if("40013".equals(code)){
			return "不合法的 AppID ，请开发者检查 AppID 的正确性，避免异常字符，注意大小写";
		}else if("40014".equals(code)){
			return "不合法的 access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口";
		}else if("40015".equals(code)){
			return "不合法的菜单类型";
		}else if("40016".equals(code)){
			return "不合法的按钮个数";
		}else if("40017".equals(code)){
			return "不合法的按钮个数";
		}else if("40018".equals(code)){
			return "不合法的按钮名字长度";
		}else if("40019".equals(code)){
			return "不合法的按钮 KEY 长度";
		}else if("40020".equals(code)){
			return "不合法的按钮 URL 长度";
		}else if("40021".equals(code)){
			return "不合法的菜单版本号";
		}else if("40022".equals(code)){
			return "不合法的子菜单级数";
		}else if("40023".equals(code)){
			return "不合法的子菜单按钮个数";
		}else if("40024".equals(code)){
			return "不合法的子菜单按钮类型";
		}else if("40025".equals(code)){
			return "不合法的子菜单按钮名字长度";
		}else if("40026".equals(code)){
			return "不合法的子菜单按钮 KEY 长度";
		}else if("40027".equals(code)){
			return "不合法的子菜单按钮 URL 长";
		}else if("40028".equals(code)){
			return "不合法的自定义菜单使用用户";
		}else if("40029".equals(code)){
			return "不合法的 oauth_code";
		}else if("40030".equals(code)){
			return "不合法的 refresh_token";
		}else if("40031".equals(code)){
			return "不合法的 openid 列表";
		}else if("40032".equals(code)){
			return "不合法的 openid 列表长度";
		}else if("40033".equals(code)){
			return "不合法的请求字符，不能包含 \\uxxxx 格式的字符";
		}else if("40035".equals(code)){
			return "不合法的参数";
		}else if("40038".equals(code)){
			return "不合法的请求格式";
		}else if("40039".equals(code)){
			return "不合法的 URL 长度";
		}else if("40050".equals(code)){
			return "不合法的分组 id";
		}else if("40051".equals(code)){
			return "分组名字不合法";
		}else if("40060".equals(code)){
			return "删除单篇图文时，指定的 article_idx 不合法";
		}else if("40117".equals(code)){
			return "分组名字不合法";
		}else if("40118".equals(code)){
			return "media_id 大小不合法";
		}else if("40119".equals(code)){
			return "button 类型错误";
		}else if("40120".equals(code)){
			return "button 类型错误";
		}else if("40121".equals(code)){
			return "不合法的 media_id 类型";
		}else if("40132".equals(code)){
			return "微信号不合法";
		}else if("40137".equals(code)){
			return "不支持的图片格式";
		}else if("40155".equals(code)){
			return "请勿添加其他公众号的主页链接";
		}else if("41001".equals(code)){
			return "缺少 access_token 参数";
		}else if("41002".equals(code)){
			return "缺少 appid 参数";
		}else if("41003".equals(code)){
			return "缺少 refresh_token 参数";
		}else if("41004".equals(code)){
			return "缺少 secret 参数";
		}else if("41005".equals(code)){
			return "缺少多媒体文件数据";
		}else if("41006".equals(code)){
			return "缺少 media_id 参数";
		}else if("41007".equals(code)){
			return "缺少子菜单数据";
		}else if("41008".equals(code)){
			return "缺少 oauth code";
		}else if("41009".equals(code)){
			return "缺少 openid";
		}else if("42001".equals(code)){
			return "access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明";
		}else if("42002".equals(code)){
			return "refresh_token 超时";
		}else if("42003".equals(code)){
			return "oauth_code 超时";
		}else if("42007".equals(code)){
			return "用户修改微信密码， accesstoken 和 refreshtoken 失效，需要重新授权";
		}else if("43001".equals(code)){
			return "需要 GET 请求";
		}else if("43002".equals(code)){
			return "需要 POST 请求";
		}else if("43003".equals(code)){
			return "需要 HTTPS 请求";
		}else if("43004".equals(code)){
			return "需要接收者关注";
		}else if("43005".equals(code)){
			return "需要好友关系";
		}else if("43019".equals(code)){
			return "需要将接收者从黑名单中移除";
		}else if("44001".equals(code)){
			return "多媒体文件为空";
		}else if("44002".equals(code)){
			return "POST 的数据包为空";
		}else if("44003".equals(code)){
			return "图文消息内容为空";
		}else if("44004".equals(code)){
			return "文本消息内容为空";
		}else if("45001".equals(code)){
			return "多媒体文件大小超过限制";
		}else if("45002".equals(code)){
			return "消息内容超过限制";
		}else if("45003".equals(code)){
			return "标题字段超过限制";
		}else if("45004".equals(code)){
			return "描述字段超过限制";
		}else if("45005".equals(code)){
			return "链接字段超过限制";
		}else if("45006".equals(code)){
			return "图片链接字段超过限制";
		}else if("45007".equals(code)){
			return "语音播放时间超过限制";
		}else if("45008".equals(code)){
			return "图文消息超过限制";
		}else if("45009".equals(code)){
			return "接口调用超过限制";
		}else if("45010".equals(code)){
			return "创建菜单个数超过限制";
		}else if("45011".equals(code)){
			return "API 调用太频繁，请稍候再试";
		}else if("45015".equals(code)){
			return "回复时间超过限制";
		}else if("45016".equals(code)){
			return "系统分组，不允许修改";
		}else if("45017".equals(code)){
			return "分组名字过长";
		}else if("45018".equals(code)){
			return "分组数量超过上限";
		}else if("45047".equals(code)){
			return "客服接口下行条数超过上限";
		}else if("46001".equals(code)){
			return "不存在媒体数据";
		}else if("46002".equals(code)){
			return "不存在的菜单版本";
		}else if("46003".equals(code)){
			return "不存在的菜单数据";
		}else if("46004".equals(code)){
			return "不存在的用户";
		}else if("47001".equals(code)){
			return "解析 JSON/XML 内容错误";
		}else if("48001".equals(code)){
			return "api 功能未授权，请确认公众号已获得该接口，可以在公众平台官网 - 开发者中心页中查看接口权限";
		}else if("48002".equals(code)){
			return "粉丝拒收消息（粉丝在公众号选项中，关闭了 “ 接收消息 ” ）";
		}else if("48004".equals(code)){
			return "api 接口被封禁，请登录 mp.weixin.qq.com 查看详情";
		}else if("48005".equals(code)){
			return "api 禁止删除被自动回复和自定义菜单引用的素材";
		}else if("48006".equals(code)){
			return "api 禁止清零调用次数，因为清零次数达到上限";
		}else if("48008".equals(code)){
			return "没有该类型消息的发送权限";
		}else if("50001".equals(code)){
			return "用户未授权该 api";
		}else if("50002".equals(code)){
			return "用户受限，可能是违规后接口被封禁";
		}else if("50005".equals(code)){
			return "用户未关注公众号";
		}else if("61451".equals(code)){
			return "参数错误 (invalid parameter)";
		}else if("61452".equals(code)){
			return "无效客服账号 (invalid kf_account)";
		}else if("61453".equals(code)){
			return "客服帐号已存在 (kf_account exsited)";
		}else if("61454".equals(code)){
			return "客服帐号名长度超过限制 ( 仅允许 10 个英文字符，不包括 @ 及 @ 后的公众号的微信号 )(invalid kf_acount length)";
		}else if("61455".equals(code)){
			return "客服帐号名包含非法字符 ( 仅允许英文 + 数字 )(illegal character in kf_account)";
		}else if("61456".equals(code)){
			return "客服帐号个数超过限制 (10 个客服账号 )(kf_account count exceeded)";
		}else if("61457".equals(code)){
			return "无效头像文件类型 (invalid file type)";
		}else if("61450".equals(code)){
			return "系统错误 (system error)";
		}else if("61500".equals(code)){
			return "日期格式错误";
		}else if("65301".equals(code)){
			return "不存在此 menuid 对应的个性化菜单";
		}else if("65302".equals(code)){
			return "没有相应的用户";
		}else if("65303".equals(code)){
			return "没有默认菜单，不能创建个性化菜单";
		}else if("65304".equals(code)){
			return "MatchRule 信息为空";
		}else if("65305".equals(code)){
			return "个性化菜单数量受限";
		}else if("65306".equals(code)){
			return "不支持个性化菜单的帐号";
		}else if("65307".equals(code)){
			return "个性化菜单信息为空";
		}else if("65308".equals(code)){
			return "包含没有响应类型的 button";
		}else if("65309".equals(code)){
			return "个性化菜单开关处于关闭状态";
		}else if("65310".equals(code)){
			return "填写了省份或城市信息，国家信息不能为空";
		}else if("65311".equals(code)){
			return "填写了城市信息，省份信息不能为空";
		}else if("65312".equals(code)){
			return "不合法的国家信息";
		}else if("65313".equals(code)){
			return "不合法的省份信息";
		}else if("65314".equals(code)){
			return "不合法的城市信息";
		}else if("65316".equals(code)){
			return "该公众号的菜单设置了过多的域名外跳（最多跳转到 3 个域名的链接）";
		}else if("65317".equals(code)){
			return "不合法的 URL";
		}else if("9001001".equals(code)){
			return "POST 数据参数不合法";
		}else if("9001002".equals(code)){
			return "远端服务不可用";
		}else if("9001003".equals(code)){
			return "Ticket 不合法";
		}else if("9001004".equals(code)){
			return "获取摇周边用户信息失败";
		}else if("9001005".equals(code)){
			return "获取商户信息失败";
		}else if("9001006".equals(code)){
			return "获取 OpenID 失败";
		}else if("9001007".equals(code)){
			return "上传文件缺失";
		}else if("9001008".equals(code)){
			return "上传素材的文件类型不合法";
		}else if("9001009".equals(code)){
			return "上传素材的文件尺寸不合法";
		}else if("9001010".equals(code)){
			return "上传失败";
		}else if("9001020".equals(code)){
			return "帐号不合法";
		}else if("9001021".equals(code)){
			return "已有设备激活率低于 50% ，不能新增设备";
		}else if("9001022".equals(code)){
			return "设备申请数不合法，必须为大于 0 的数字";
		}else if("9001023".equals(code)){
			return "已存在审核中的设备 ID 申请";
		}else if("9001024".equals(code)){
			return "一次查询设备 ID 数量不能超过 50";
		}else if("9001025".equals(code)){
			return "设备 ID 不合法";
		}else if("9001026".equals(code)){
			return "页面 ID 不合法";
		}else if("9001027".equals(code)){
			return "页面参数不合法";
		}else if("9001028".equals(code)){
			return "一次删除页面 ID 数量不能超过 10";
		}else if("9001029".equals(code)){
			return "页面已应用在设备中，请先解除应用关系再删除";
		}else if("9001030".equals(code)){
			return "一次查询页面 ID 数量不能超过 50";
		}else if("9001031".equals(code)){
			return "时间区间不合法";
		}else if("9001032".equals(code)){
			return "保存设备与页面的绑定关系参数错误";
		}else if("9001033".equals(code)){
			return "门店 ID 不合法";
		}else if("9001034".equals(code)){
			return "设备备注信息过长";
		}else if("9001035".equals(code)){
			return "设备申请参数不合法";
		}else if("9001036".equals(code)){
			return "查询起始值 begin 不合法";
		}
		return "无";
	}
}
