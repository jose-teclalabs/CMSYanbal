package com.pe.cms.yanbal.dao;

import com.pe.cms.yanbal.model.AdministratorDTO;
import com.pe.cms.yanbal.pojo.Administrator;

public interface AdministratorDao {

	public Administrator loginAdministrator(String username, String  clave);


}
