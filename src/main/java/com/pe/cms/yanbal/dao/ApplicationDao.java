package com.pe.cms.yanbal.dao;

import java.util.List;

import com.pe.cms.yanbal.model.ApplicationDTO;
import com.pe.cms.yanbal.pojo.Application;

public interface ApplicationDao {
	
	public List getAllApplication();
	public void addApplication (ApplicationDTO appl);
	public Application buscarPorIdApplication(ApplicationDTO appl);
	public void actualizarApplication(ApplicationDTO appl);
	public void eliminarApplication(ApplicationDTO appl);
	public List getFilterAppplication();

}
