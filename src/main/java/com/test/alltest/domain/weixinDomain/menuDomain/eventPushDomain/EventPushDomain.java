package com.test.alltest.domain.weixinDomain.menuDomain.eventPushDomain;

import javax.xml.bind.annotation.XmlAttribute;

public class EventPushDomain {
    private String toUserName;  //开发者 微信号
    private String fromUserName;//发送方帐号（一个OpenID）
    private Long createTime;  //消息创建时间 （整型）
    private String msgType;     //消息类型，event
    private String event;       //事件类型，CLICK
    private String eventKey;    //事件KEY值，与自定义菜单接口中KEY值对应

    @XmlAttribute(name="ToUserName")
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    @XmlAttribute(name="FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
    @XmlAttribute(name="CreateTime")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @XmlAttribute(name="MsgType")
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    @XmlAttribute(name="Event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
    @XmlAttribute(name="EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
