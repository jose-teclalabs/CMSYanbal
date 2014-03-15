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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pe.cms.yanbal.util.Constant;

@Entity
@Table(name = "product_application", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
public class ProductApplicationDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "prap_id")
	private Integer prapId;
	@Column(name = "prap_status")
	private Integer  status;
	@Column(name = "prap_date")
	private Date prapDate;
	
	@ManyToOne(targetEntity = ProductDTO.class)
	@JoinColumn(name = "prod_id")
	private ProductDTO product;

	@ManyToOne(targetEntity = ApplicationDTO.class)
	@JoinColumn(name = "appl_id")
	private ApplicationDTO application;
	
	@ManyToOne(targetEntity = BenefitDTO.class)
	@JoinColumn(name = "bene_id")
	private BenefitDTO benefit;
	
	@ManyToOne(targetEntity = TipDTO.class)
	@JoinColumn(name = "tip_id")
	private TipDTO tip;
	
	public ProductApplicationDTO() {
		this.product =  new ProductDTO();
		this.application = new ApplicationDTO();
		this.tip = new TipDTO();
		this.benefit = new BenefitDTO();
	}

	public ProductApplicationDTO(Integer newProductId) {
		this.prapId = newProductId;
	}

	public Integer getPrapId() {
		return prapId;
	}

	public void setPrapId(Integer prapId) {
		this.prapId = prapId;
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

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public ApplicationDTO getApplication() {
		return application;
	}

	public void setApplication(ApplicationDTO application) {
		this.application = application;
	}

	public BenefitDTO getBenefit() {
		return benefit;
	}

	public void setBenefit(BenefitDTO benefit) {
		this.benefit = benefit;
	}

	public TipDTO getTip() {
		return tip;
	}

	public void setTip(TipDTO tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "ProductApplicationDTO [prapId=" + prapId + ", status=" + status
				+ ", prapDate=" + prapDate + ", product=" + product
				+ ", application=" + application + ", benefit=" + benefit
				+ ", tip=" + tip + "]";
	}
	
	
}
