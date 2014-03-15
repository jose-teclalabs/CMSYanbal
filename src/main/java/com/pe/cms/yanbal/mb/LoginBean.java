package com.pe.cms.yanbal.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;
import com.pe.cms.yanbal.model.AdministratorDTO;
import com.pe.cms.yanbal.pojo.Administrator;
import com.pe.cms.yanbal.service.AdministratorService;

@ManagedBean
@RequestScoped
public class LoginBean {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@ManagedProperty(value = "#{AdministratorService}")
	AdministratorService administratorService;
	
	private String username;
	private String clave;
	
	
	 public void login(ActionEvent actionEvent) {  
		 try{		 
			 	RequestContext context = RequestContext.getCurrentInstance();  
		        FacesMessage msg = null;  
		        boolean loggedIn = false;  
		        AdministratorDTO admin =  new AdministratorDTO();
		        admin.setUsername(username);
		        admin.setClave(clave);	
		        System.out.println( " " +getUsername()+ "" +getClave());
		       Administrator adminVerify =  administratorService.loginYanbal(getUsername(),getClave());  
		       if(adminVerify == null){
//		    	   System.out.println(adminVerify.toString());
		    	   loggedIn = false;  
		            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
		            FacesContext.getCurrentInstance().addMessage(null, msg);  
			        context.addCallbackParam("loggedIn", loggedIn); 
		       }else{
		    	   
			       loggedIn = true;  
		           msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", adminVerify.getUsername());         
		//	        if(username != null  && username.equals("admin") && clave != null  && clave.equals("admin")) {  
		//	            loggedIn = true;  
		//	            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);  
		//	        } else {  
		//	            loggedIn = false;  
		//	            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
		//	        }          
			        FacesContext.getCurrentInstance().addMessage(null, msg);  
			        context.addCallbackParam("loggedIn", loggedIn); 
		    	   
		       }
		    
		 }catch(DataAccessException e){
				System.out.println("ERROR EN EL CONTROLLER    " + e);
				e.printStackTrace();
			}
	    }


	public AdministratorService getAdministratorService() {
		return administratorService;
	}


	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
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
}
