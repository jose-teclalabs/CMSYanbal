package com.pe.cms.yanbal.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.mapping.Array;
import org.springframework.dao.DataAccessException;

import com.pe.cms.yanbal.model.ApplicationDTO;
import com.pe.cms.yanbal.pojo.Application;
import com.pe.cms.yanbal.pojo.Benefit;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.service.ApplicationService;
import com.pe.cms.yanbal.service.BenefitService;


@ManagedBean
@ViewScoped
public class BenefitBean implements Serializable {
	
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{BenefitService}")
	BenefitService benefitService;
	
	private Benefit benefitContainer = new Benefit();
	private String description;
	private Integer status = 1;;
	private Date beneDate = new Date();
	private List<Benefit> benefits;
	
	public BenefitBean(){
		benefitContainer = new Benefit();
	}
	
	public void limpiar(){
		benefitContainer = null;
		benefits = null;
	}
	
	public void prepararActualizar(Integer id){
		try {
			System.out.println("ESTOY EN EL MB " + id);
			Benefit benefitReturn =  new Benefit();
			benefitReturn.setBeneId(id);
			benefitContainer = getBenefitService().buscarPorIdBenefit(benefitReturn);
			benefitContainer.setBeneId(benefitReturn.getBeneId());
			limpiar();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void actualizarBenefit(){
		try{
			Benefit benefitReturn = new Benefit();
			benefitReturn.setBeneId(benefitContainer.getBeneId());
			benefitReturn.setDescription(benefitContainer.getDescription());
			System.out.println("ERROR MB SU " + benefitContainer.toString());
			getBenefitService().actualizarBenefit(benefitReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + benefitContainer.getBeneId()   + "  " +benefitContainer.getDescription() , "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        limpiar();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void eliminarBenefit(){
		try{
			Benefit benefitReturn = new Benefit();
			benefitReturn.setBeneId(benefitContainer.getBeneId());
			benefitService.eliminarBenefit(benefitReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + benefitContainer.getBeneId()   + "  " +benefitContainer.getDescription() , "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        limpiar();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public String guardarBenefit(){
		try{
			Benefit benefit = new Benefit();
			benefit.setDescription(getDescription());
			benefit.setStatus(getStatus());
			benefit.setBeneDate(getBeneDate());
			getBenefitService().addBenefit(benefit);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success", "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        limpiar();
	        return SUCCESS;
		}catch(DataAccessException e){
			System.out.println("ERROR EN EL CONTROLLER    " + e);
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public BenefitService getBenefitService() {
		return benefitService;
	}
	public void setBenefitService(BenefitService benefitService) {
		this.benefitService = benefitService;
	}
	public Benefit getBenefitContainer() {
		return benefitContainer;
	}
	public void setBenefitContainer(Benefit benefitContainer) {
		this.benefitContainer = benefitContainer;
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
	public List<Benefit> getBenefits() {
		benefits = getBenefitService().getAllBenefits();
		return benefits;
	}
	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}
}
