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
@Table(name = "benefit", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
public class BenefitDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "bene_id")
	private Integer beneId;
	@Column(name = "bene_description")
	private String description;
	@Column(name = "bene_status")
	private Integer  status;
	@Column(name = "bene_date")
	private Date beneDate;
	
	@OneToMany(targetEntity = ProductApplicationDTO.class, mappedBy = "benefit", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ProductApplicationDTO> productApplicationList = new ArrayList<ProductApplicationDTO>(0);

	public BenefitDTO(){
		
	}
	
	public BenefitDTO(Integer id) {
		this.beneId  = id ;
	}

	public Integer getBeneId() {
		return beneId;
	}

	public void setBeneId(Integer beneId) {
		this.beneId = beneId;
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

	public Date getBeneDate() {
		return beneDate;
	}

	public void setBeneDate(Date beneDate) {
		this.beneDate = beneDate;
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
		return "BenefitDTO [beneId=" + beneId + ", description=" + description
				+ ", status=" + status + ", beneDate=" + beneDate
				+ ", productApplicationList=" + productApplicationList + "]";
	}
}
