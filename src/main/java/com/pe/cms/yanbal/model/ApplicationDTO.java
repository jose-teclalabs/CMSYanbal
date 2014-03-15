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
@Table(name = "application", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
public class ApplicationDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "appl_id")
	private Integer applId;
	@Column(name = "appl_description")
	private String description;
	@Column(name = "appl_status")
	private Integer  status;
	@Column(name = "appl_date")
	private Date applDate;
	
	@OneToMany(targetEntity = ProductApplicationDTO.class, mappedBy = "application", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ProductApplicationDTO> productApplicationList = new ArrayList<ProductApplicationDTO>(0);
	
	public ApplicationDTO() {
		
	}
	public ApplicationDTO(Integer id) {
		this.applId = id;
	}
	public Integer getApplId() {
		return applId;
	}
	public void setApplId(Integer applId) {
		this.applId = applId;
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
	public Date getApplDate() {
		return applDate;
	}
	public void setApplDate(Date applDate) {
		this.applDate = applDate;
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
		return "ApplicationDTO [applId=" + applId + ", description="
				+ description + ", status=" + status + ", applDate=" + applDate
				+ "]";
	}
}
