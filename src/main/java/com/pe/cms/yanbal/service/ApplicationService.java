package com.pe.cms.yanbal.service;

import java.util.List;

import com.pe.cms.yanbal.pojo.Application;
public interface ApplicationService {
	
	public List getAllApplication() ;
	public void addApplication (Application appl);
	public Application buscarPorIdApplication(Application appl);
	public void actualizarApplication(Application appl);
	public void eliminarApplication(Application appl);

}
