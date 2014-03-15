package com.pe.cms.yanbal.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.ApplicationDao;
import com.pe.cms.yanbal.model.ApplicationDTO;
import com.pe.cms.yanbal.pojo.Application;
import com.pe.cms.yanbal.service.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ApplicationDao applicationDao;

	@Override
	public List getAllApplication() {
		return getApplicationDao().getAllApplication();
	}

	@Transactional
	@Override
	public void addApplication(Application appl) {
		try{
			System.out.println("ESTOY EN EL SERVICE " + appl.toString());
			ApplicationDTO applreturn =  new ApplicationDTO();
			applreturn.setDescription(appl.getDescription());
			applreturn.setStatus(appl.getStatus());
			applreturn.setApplDate(appl.getApplDate());
			getApplicationDao().addApplication(applreturn);
		}catch(Exception e){
			System.out.println("eerrror " + e);
		}			
	}
	
	@Transactional
	@Override
	public Application buscarPorIdApplication(Application appl) {
		try{	
			Integer newProductId = appl.getApplId();
			System.out.println("estoy en el service " + appl.getApplId());
			return getApplicationDao().buscarPorIdApplication(new ApplicationDTO(newProductId));
		}catch(Exception e){
			System.out.println("eerrror " + e);
			return null;
		}
	}
	
	@Transactional
	@Override
	public void actualizarApplication(Application appl) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + appl.toString());
			ApplicationDTO tipContainer = new ApplicationDTO();
			tipContainer.setApplId(appl.getApplId());
			tipContainer.setDescription(appl.getDescription());
			getApplicationDao().actualizarApplication(tipContainer);
		}catch(Exception e){
			System.out.println(e);
		}	
	}

	@Transactional
	@Override
	public void eliminarApplication(Application appl) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + appl.toString());
			ApplicationDTO tipContainer = new ApplicationDTO();
			tipContainer.setApplId(appl.getApplId());
			getApplicationDao().eliminarApplication(tipContainer);
		}catch(Exception e){
			System.out.println(e);
		}			
	}

	public ApplicationDao getApplicationDao() {
		return applicationDao;
	}

	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}
}
