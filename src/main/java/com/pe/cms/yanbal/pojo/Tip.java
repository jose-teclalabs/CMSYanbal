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
public class Tip implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "tipId")
	private Integer tipId;
	@XmlElement(name = "description")
	private String description;
	@XmlElement(name = "status")
	private Integer  status;
	@XmlElement(name = "tipdDate")
	private Date tipDate;
	
	public Tip() {
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
	
	public Integer getTipId() {
		return tipId;
	}

	public void setTipId(Integer tipId) {
		this.tipId = tipId;
	}

	public Date getTipDate() {
		return tipDate;
	}

	public void setTipDate(Date tipDate) {
		this.tipDate = tipDate;
	}

	@Override
	public String toString() {
		return "Tip [tipId=" + tipId + ", description=" + description
				+ ", status=" + status + ", tipDate=" + tipDate + "]";
	}
}
