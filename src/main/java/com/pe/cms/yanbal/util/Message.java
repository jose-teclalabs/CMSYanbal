package com.pe.cms.yanbal.util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Message {

	private boolean success;
	private String description;
	
	@XmlElement(name="data")
    private List<?> data;

	public Message(boolean success, String description) {
	    this.success = success;
		this.setDescription(description);
	} 
	
	public Message() {
	}
	
	public Message(boolean success, List<?> data,
			String description) {
		this.success = success;
		this.data = data;
		this.description = description;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("");
		sb.append("[");
		sb.append(this.success);
		sb.append("]-");
		sb.append(this.description);
		sb.append(".");
		return sb.toString();
	}
}
