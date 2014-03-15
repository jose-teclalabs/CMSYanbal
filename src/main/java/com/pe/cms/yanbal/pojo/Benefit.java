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
public class Benefit implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "beneId")
	private Integer beneId;
	@XmlElement(name = "description")
	private String description;
	@XmlElement(name = "status")
	private Integer status;
	@XmlElement(name = "beneDate")
	private Date beneDate;

	public Benefit() {
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

	public Integer getBeneId() {
		return beneId;
	}

	public void setBeneId(Integer beneId) {
		this.beneId = beneId;
	}

	public Date getBeneDate() {
		return beneDate;
	}

	public void setBeneDate(Date beneDate) {
		this.beneDate = beneDate;
	}

	@Override
	public String toString() {
		return "Benefit [beneId=" + beneId + ", description=" + description
				+ ", status=" + status + ", beneDate=" + beneDate + "]";
	}

}
