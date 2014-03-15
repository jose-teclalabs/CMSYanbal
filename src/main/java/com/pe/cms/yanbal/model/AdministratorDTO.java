package com.pe.cms.yanbal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.pe.cms.yanbal.util.*;

@Entity
@Table(name = "administrator", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class AdministratorDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "admi_id")
	private Integer adminId;
	@Column(name = "admi_username")
	private String username;
	@Column(name = "admi_password")
	private String clave;
	@Column(name = "admi_status")
	private Integer status;
	@Column(name = "admi_date")
	private Date admiDate;

	public AdministratorDTO() {
		
	}

	public AdministratorDTO(String username2, String clave2) {
		this.username = username2;
		this.clave = clave2;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getAdmiDate() {
		return admiDate;
	}

	public void setAdmiDate(Date admiDate) {
		this.admiDate = admiDate;
	}

	@Override
	public String toString() {
		return "AdministratorDTO [adminId=" + adminId + ", username="
				+ username + ", clave=" + clave + ", status=" + status
				+ ", admiDate=" + admiDate + "]";
	}
}
