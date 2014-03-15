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
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "prodId")
	private Integer prodId;
	@XmlElement(name = "description")
	private String description;
	@XmlElement(name = "status")
	private Integer  status;
	@XmlElement(name = "prodDate")
	private Date prodDate;
	@XmlElement(name = "details")
	private String  details;
	@XmlElement(name = "type")
	private String  type;
	@XmlElement(name = "photo")
	private String  photo;
	
	public Product() {
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
	
	public Date getProdDate() {
		return prodDate;
	}
	
	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getProdId() {
		return prodId;
	}
	
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", description=" + description
				+ ", status=" + status + ", prodDate=" + prodDate
				+ ", details=" + details + ", type=" + type + ", photo="
				+ photo + "]";
	}

}
