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

import org.springframework.dao.DataAccessException;

import com.pe.cms.yanbal.model.ApplicationDTO;
import com.pe.cms.yanbal.pojo.Application;
import com.pe.cms.yanbal.service.ApplicationService;

@ManagedBean
@ViewScoped
public class ApplicationBean implements Serializable {

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ApplicationService}")
	ApplicationService applicationService;
	
	private Application applicationContainer = new Application();
	private String description;
	private Integer status = 1;;
	private Date tipDate = new Date();
	private List<ApplicationDTO> applications;
	
	
	public ApplicationBean() {
		
	}
	
	public void prepararActualizar(Integer id){
		try {
			System.out.println("ESTOY EN EL MB " + id);
			Application applicationReturn =  new Application();
			applicationReturn.setApplId(id);
			applicationContainer = applicationService.buscarPorIdApplication(applicationReturn);
			applicationContainer.setApplId(applicationContainer.getApplId());
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void actualizarApplication(){
		try{
			Application applicationReturn = new Application();
			applicationReturn.setApplId(applicationContainer.getApplId());
			applicationReturn.setDescription(applicationContainer.getDescription());
			System.out.println("ERROR MB SU " + applicationContainer.toString());
			applicationService.actualizarApplication(applicationReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + applicationContainer.getApplId()   + "  " +applicationContainer.getDescription() , "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        applicationContainer = new Application();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void eliminarApplication(){
		try{
			Application applicationReturn = new Application();
			applicationReturn.setApplId(applicationContainer.getApplId());
			applicationService.eliminarApplication(applicationReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + applicationContainer.getApplId()   + "  " +applicationContainer.getDescription() , "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        applicationContainer = new Application();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public String guardarApplication(){
		try{
			Application application = new Application();
			application.setDescription(getDescription());
			application.setStatus(getStatus());
			application.setApplDate(getTipDate());
			getApplicationService().addApplication(application);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success", "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);	         
	        return SUCCESS;
		}catch(DataAccessException e){
			System.out.println("ERROR EN EL CONTROLLER    " + e);
			e.printStackTrace();
		}
		return ERROR;
	}
	
	
	
	public ApplicationService getApplicationService() {
		return applicationService;
	}
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	public Application getApplicationContainer() {
		return applicationContainer;
	}
	public void setApplicationContainer(Application applicationContainer) {
		this.applicationContainer = applicationContainer;
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
	public List<ApplicationDTO> getApplications() {
		applications = new ArrayList();
		applications.addAll(getApplicationService().getAllApplication());
		return applications;
	}
	public void setApplications(List<ApplicationDTO> applications) {
		this.applications = applications;
	}
}
