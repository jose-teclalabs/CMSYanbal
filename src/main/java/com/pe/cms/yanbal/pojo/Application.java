package com.pe.cms.yanbal.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.ListDataModel;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.primefaces.model.SelectableDataModel;

import com.pe.cms.yanbal.model.ProductDTO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Application implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "applId")
	private Integer applId;
	@XmlElement(name = "description")
	private String description;
	@XmlElement(name = "status")
	private Integer  status;
	@XmlElement(name = "appldDate")
	private Date applDate;
	
	public Application() {
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getApplId() {
		return applId;
	}

	public void setApplId(Integer applId) {
		this.applId = applId;
	}

	public Date getApplDate() {
		return applDate;
	}

	public void setApplDate(Date applDate) {
		this.applDate = applDate;
	}

	@Override
	public String toString() {
		return "Application [applId=" + applId + ", description=" + description
				+ ", status=" + status + ", applDate=" + applDate + "]";
	}
}
