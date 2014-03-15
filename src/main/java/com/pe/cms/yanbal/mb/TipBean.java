package com.pe.cms.yanbal.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.model.TipDTO;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.Tip;
import com.pe.cms.yanbal.service.ProductService;
import com.pe.cms.yanbal.service.TipService;

@ManagedBean
@SessionScoped
public class TipBean {
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
//	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{TipService}")
	TipService tipService;
	private Tip tipContainer = new Tip();
	private String description;
	private Integer status = 1;;
	private Date tipDate = new Date();
	
	private List<TipDTO> tips;

	public TipBean (){
		limpiar();
	}
	
	
	public TipService getTipService() {
		return tipService;
	}
	
	public void limpiar(){
		tipContainer = new Tip();
		description = null;
	}

	public void setTipService(TipService tipService) {
		this.tipService = tipService;
	}

	public List<TipDTO> getTips() {
		tips = new ArrayList();
		tips.addAll(getTipService().getAllTips());
		return tips;
	}

	public void setTips(List<TipDTO> tips) {
		this.tips = tips;
	}
	
	public void prepararActualizar(Integer id){
		try {
			System.out.println("ESTOY EN EL MB " + id);
			Tip tipReturn =  new Tip();
			tipReturn.setTipId(id);
			tipContainer = tipService.buscarPorIdTip(tipReturn);
			tipContainer.setTipId(tipReturn.getTipId());
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void actualizarTip(){
		try{
			Tip tipReturn = new Tip();
			tipReturn.setTipId(tipContainer.getTipId());
			tipReturn.setDescription(tipContainer.getDescription());
			System.out.println("ERROR MB SU " + tipContainer.toString());
			tipService.actualizarTip(tipReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + tipContainer.getTipId()   + "  " +tipContainer.getDescription() , "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        tipContainer = new Tip();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void eliminarTip(){
		try{
			Tip tipReturn = new Tip();
			tipReturn.setTipId(tipContainer.getTipId());
			System.out.println("ERROR MB SU " + tipContainer.toString());
			tipService.eliminarTip(tipReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + tipContainer.getTipId()   + "  " +tipContainer.getDescription() , "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        tipContainer = new Tip();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public String guardarTip(){
		try{
			Tip tip = new Tip();
			tip.setDescription(getDescription());
			tip.setStatus(getStatus());
			tip.setTipDate(getTipDate());
			getTipService().addTip(tip);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success", "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);	         
	        return SUCCESS;
		}catch(DataAccessException e){
			System.out.println("ERROR EN EL CONTROLLER    " + e);
			e.printStackTrace();
		}
		return ERROR;
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

	public Tip getTipContainer() {
		return tipContainer;
	}

	public void setTipContainer(Tip tipContainer) {
		this.tipContainer = tipContainer;
	}
}
