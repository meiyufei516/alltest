package com.test.alltest.domain.weixinDomain.menuDomain.eventPushDomain;

/**
 * @author MeiYF
 * @time 2018/11/23 11:58
 **/
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="xml")
public class EvenPushList {
	private List<EventPushDomain> evenPushList;

	public List<EventPushDomain> getEvenPushList() {
		return evenPushList;
	}

	public void setEvenPushList(List<EventPushDomain> evenPushList) {
		this.evenPushList = evenPushList;
	}
}
