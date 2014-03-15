package com.pe.cms.yanbal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.ApplicationDao;
import com.pe.cms.yanbal.model.ApplicationDTO;
import com.pe.cms.yanbal.pojo.Application;
import com.pe.cms.yanbal.pojo.Product;

public class ApplicationDaoImpl implements ApplicationDao,Serializable {


	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List getAllApplication() {
		String sql = "SELECT distinct * FROM application WHERE appl_status = 1 order by appl_id ";
		 SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		 query.addEntity(ApplicationDTO.class);
		 List results = query.list();
		 return results;
	}

	@Override
	public void addApplication(ApplicationDTO appl) {
		System.out.println("ESTOY EN EL DAO " + appl.toString());
		getSessionFactory().getCurrentSession().save(appl);
		
	}

	@Override
	public Application buscarPorIdApplication(ApplicationDTO appl) {
		try{
		System.out.println("ESTOY EN EL DAO " +  appl.toString());
		String sql = "SELECT appl_id as applId, appl_description as description FROM application WHERE appl_id = :id ";
		SQLQuery query =getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setParameter("id", appl.getApplId());
		query.addScalar("applId",StandardBasicTypes.INTEGER);
		query.addScalar("description",StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(Application.class));
		return (Application) query.uniqueResult();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO " + e);
			return null;
		}
	}

	@Override
	public void actualizarApplication(ApplicationDTO appl) {
		try{
		System.out.println("ESTOY EN EL DAO " +appl.toString());
		String sql = "UPDATE application SET appl_description = :description  WHERE appl_id = :applId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("applId", appl.getApplId());
		query.setString("description", appl.getDescription());;
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + appl.toString());
		}catch(Exception e ){
			System.out.println(e);
		}	
	}

	@Override
	public void eliminarApplication(ApplicationDTO appl) {
		try{
			System.out.println("ESTOY EN EL DAO " +appl.toString());
		String sql = "UPDATE application SET appl_status = 0  WHERE appl_id = :applId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("applId", appl.getApplId());
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + appl.toString());
		}catch(Exception e ){
			System.out.println(e);
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public List getFilterAppplication() {
		try{
			String sql = "SELECT DISTINCT appl_id as applId, appl_description as description FROM application WHERE appl_status = 1 order by appl_id ";
			SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			query.addScalar("applId",StandardBasicTypes.INTEGER);
			query.addScalar("description",StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(Application.class));
			return query.list();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO " + e);
			return null;
		}
	}	
}
