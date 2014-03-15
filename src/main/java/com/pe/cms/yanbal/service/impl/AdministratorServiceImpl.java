package com.pe.cms.yanbal.service.impl;

import com.pe.cms.yanbal.dao.AdministratorDao;
import com.pe.cms.yanbal.pojo.Administrator;
import com.pe.cms.yanbal.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {

	AdministratorDao administratorDao;

	@Override
	public Administrator loginYanbal(String username , String clave) {
		try{			
			System.out.println(" ESTOY EN EL SERVICE " + username + clave );
		
			return  getAdministratorDao().loginAdministrator(username, clave);		
		}			
		catch(Exception e){
			return null;
		}
	}

	public AdministratorDao getAdministratorDao() {
		return administratorDao;
	}

	public void setAdministratorDao(AdministratorDao administratorDao) {
		this.administratorDao = administratorDao;
	}	
}
