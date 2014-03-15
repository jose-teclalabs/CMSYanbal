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
public class ProductApplication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "prapId")
	private Integer prapId;
	
	@XmlElement(name = "applId")
	private Integer appldId;
	@XmlElement(name = "prodId")
	private Integer prodId;
	@XmlElement(name = "tipId")
	private Integer tipId;
	@XmlElement(name = "beneId")
	private Integer beneId;
	@XmlElement(name = "status")
	private Integer  status;
	@XmlElement(name = "prapDate")
	private Date prapDate;
	
	public ProductApplication() {
		
	}	
	
	public Integer getPrapId() {
		return prapId;
	}

	public void setPrapId(Integer prapId) {
		this.prapId = prapId;
	}

	public Integer getAppldId() {
		return appldId;
	}
	public void setAppldId(Integer appldId) {
		this.appldId = appldId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPrapDate() {
		return prapDate;
	}

	public void setPrapDate(Date prapDate) {
		this.prapDate = prapDate;
	}

	public Integer getTipId() {
		return tipId;
	}

	public void setTipId(Integer tipId) {
		this.tipId = tipId;
	}

	public Integer getBeneId() {
		return beneId;
	}

	public void setBeneId(Integer beneId) {
		this.beneId = beneId;
	}

	@Override
	public String toString() {
		return "ProductApplication [prapId=" + prapId + ", appldId=" + appldId
				+ ", prodId=" + prodId + ", status=" + status + ", prapDate="
				+ prapDate + "]";
	}
}
