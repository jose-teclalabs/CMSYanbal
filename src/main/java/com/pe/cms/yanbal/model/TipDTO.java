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

import com.pe.cms.yanbal.util.Constant;

@Entity
@Table(name = "tip", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
public class TipDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "tip_id")
	private Integer tipId;
	@Column(name = "tip_description")
	private String description;
	@Column(name = "tip_status")
	private Integer  status;
	@Column(name = "tip_date")
	private Date tipDate;
	
	@OneToMany(targetEntity = ProductApplicationDTO.class, mappedBy = "tip", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ProductApplicationDTO> productApplicationList = new ArrayList<ProductApplicationDTO>(0);
	
	
	public TipDTO() {
	}
	
	public TipDTO(Integer tipId) {
		this.tipId = tipId;
	}
	
	public Integer getTipId() {
		return tipId;
	}

	public void setTipId(Integer tipId) {
		this.tipId = tipId;
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
	public Date getTipDate() {
		return tipDate;
	}
	public void setTipDate(Date tipDate) {
		this.tipDate = tipDate;
	}

	public List<ProductApplicationDTO> getProductApplicationList() {
		return productApplicationList;
	}

	public void setProductApplicationList(
			List<ProductApplicationDTO> productApplicationList) {
		this.productApplicationList = productApplicationList;
	}
 
	@Override
	public String toString() {
		return "TipDTO [tipId=" + tipId + ", description=" + description
				+ ", status=" + status + ", tipDate=" + tipDate
				+ ", productApplicationList=" + productApplicationList + "]";
	} 
}
