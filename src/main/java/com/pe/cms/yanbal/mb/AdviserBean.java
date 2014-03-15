package com.pe.cms.yanbal.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.dao.DataAccessException;
import com.pe.cms.yanbal.model.AdviserDTO;
import com.pe.cms.yanbal.service.AdviserService;

@ManagedBean
@RequestScoped
public class AdviserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@ManagedProperty(value = "#{AdviserService}")
	AdviserService adviserService;
	private int id;
	private String code;
	private String surname;
		
	private List<AdviserDTO> advList;
	
	public AdviserBean() {
		
	}

//	public String loginYanbal(AdviserDTO  adviser) {
//
//		try {
//			System.out.println("el codigo que viene es el siguiente" + getCode());
//			adviser.setCode(getCode());
//			System.out.println("el adviser viene con la siguiente info " + adviser.toString());
//			getAdviserervice().yanbalLogin(adviser);
//			return SUCCESS;
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//
//		return ERROR;
//
//	}
	
	public String guardarAdviser(){
		try{
			System.out.println("el codigo es " + code);
			AdviserDTO adviser = new AdviserDTO();
			adviser.setCode(getCode());
			adviser.setAdviDate(new Date());
			adviser.setStatus(1);
			System.out.println(adviser.toString());
			getAdviserService().saveAdviser(adviser);
			// Call the business object to register the user	         
	        // Set the message here
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success", "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        return SUCCESS;
		}catch(DataAccessException e){
			System.out.println("ERROR EN EL CONTROLLER    " + e);
			e.printStackTrace();
		}
		return ERROR;
	}

	public AdviserService getAdviserService() {
		return adviserService;
	}

	public List<AdviserDTO> getAdvList() {
		 advList = new ArrayList();
		 advList.addAll(getAdviserService().getAllAdviser());
		 return advList;
	}

	public void setAdvList(List<AdviserDTO> advList) {
		this.advList = advList;
	}

	public void setAdviserService(AdviserService adviserService) {
		this.adviserService = adviserService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
