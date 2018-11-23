package com.test.alltest.domain.weixinDomain.messageDomain;

public class TextMessage {
    private String toUserName;  //开发者 微信号
    private String fromUserName;//发送方帐号（一个OpenID）
    private Long createTime;    //消息创建时间 （整型）
    private String msgType;     //消息类型，text
    private String content;     //文本消息内容
    private String msgId;       //消息id，64位整型

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
