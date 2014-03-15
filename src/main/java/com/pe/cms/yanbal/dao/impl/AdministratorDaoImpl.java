package com.pe.cms.yanbal.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import com.pe.cms.yanbal.dao.AdministratorDao;
import com.pe.cms.yanbal.model.AdministratorDTO;
import com.pe.cms.yanbal.pojo.Administrator;

public class AdministratorDaoImpl implements AdministratorDao{

	private SessionFactory sessionFactory;
		
	@Override
	public Administrator loginAdministrator(String username, String  clave) {
		Administrator adminVerify =  null;
		try{
			System.out.println("ESTOY EN EL DAO " +  username + clave );
			String sql = "select admi_username as username  from administrator where admi_username = :userName and admi_password = :passWord  and admi_status = 1 LIMIT 1";
			SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			query.setParameter("userName", username);
			query.setParameter("passWord", clave);
			query.addScalar("username",StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(Administrator.class)); 
			adminVerify =  (Administrator) query.uniqueResult();
			if(adminVerify != null){
				return adminVerify;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
			
	}



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
}
