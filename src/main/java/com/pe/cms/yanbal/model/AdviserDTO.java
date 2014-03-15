package com.pe.cms.yanbal.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.pe.cms.yanbal.util.*;

@Entity
@Table(name = "adviser", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA) 
public class AdviserDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "advi_id")
	private Integer adviserId;
	@Column(name = "advi_code")
	private String code;
	@Column(name = "advi_status")
	private Integer status;
	@Column(name = "advi_name")
	private String name;
	@Column(name = "advi_date")
	private Date adviDate;

	public AdviserDTO() {
		
	}
	
	public AdviserDTO(Integer id) {
		this.adviserId = id;
	}

	
	public AdviserDTO(String code) {
		this.code = code;
	}

	public Integer getAdviserId() {
		return adviserId;
	}

	public void setAdviserId(Integer adviserId) {
		this.adviserId = adviserId;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getAdviDate() {
		return adviDate;
	}
	public void setAdviDate(Date adviDate) {
		this.adviDate = adviDate;
	}

	@Override
	public String toString() {
		return "AdviserDTO [adviserId=" + adviserId + ", code=" + code
				+ ", status=" + status + ", name=" + name + ", adviDate="
				+ adviDate + "]";
	}	
}
