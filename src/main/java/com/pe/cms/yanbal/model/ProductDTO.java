package com.pe.cms.yanbal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pe.cms.yanbal.util.*;

@Entity
@Table(name = "product", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "prod_id")
	private Integer prodId;
	@Column(name = "prod_description")
	private String description;
	@Column(name = "prod_details")
	private String  details;
	@Column(name = "prod_type")
	private String  type;
	@Column(name = "prod_photo")
	private String  photo;
	@Column(name = "prod_status")
	private Integer  status;
	@Column(name = "prod_date")
	private Date prodDate;
	@OneToMany(targetEntity = ProductApplicationDTO.class, mappedBy = "product", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ProductApplicationDTO> productJoinList = new ArrayList<ProductApplicationDTO>(0);
	
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Integer prodId) {
		this.prodId = prodId;
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
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
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
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public List<ProductApplicationDTO> getProductJoinList() {
		return productJoinList;
	}
	public void setProductJoinList(List<ProductApplicationDTO> productJoinList) {
		this.productJoinList = productJoinList;
	}
	@Override
	public String toString() {
		return "ProductDTO [prodId=" + prodId + ", description=" + description
				+ ", details=" + details + ", type=" + type + ", photo="
				+ photo + ", status=" + status + ", prodDate=" + prodDate + "]";
	}	
}
