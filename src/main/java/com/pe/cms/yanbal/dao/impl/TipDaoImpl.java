package com.pe.cms.yanbal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.TipDao;
import com.pe.cms.yanbal.model.TipDTO;
import com.pe.cms.yanbal.pojo.Application;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.Tip;

public class TipDaoImpl implements TipDao, Serializable {

	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List getAllTips() {
		String sql = "SELECT DISTINCT * FROM tip WHERE tip_status = 1 order by tip_id ";
		 SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		 query.addEntity(TipDTO.class);
		 List results = query.list();
		 return results;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTip(TipDTO tip) {
		System.out.println("ESTOY EN EL DAO " + tip.toString());
		getSessionFactory().getCurrentSession().save(tip);
		
	}

	@Override
	public Tip buscarPorIdTip(TipDTO tip) {
		try{
			System.out.println("ESTOY EN EL DAO " +  tip.toString());
			String sql = "SELECT tip_id as tipId, tip_description as description FROM tip WHERE tip_id = :id ";
			SQLQuery query =getSessionFactory().getCurrentSession().createSQLQuery(sql);
			query.setParameter("id", tip.getTipId());
			query.addScalar("tipId",StandardBasicTypes.INTEGER);
			query.addScalar("description",StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(Tip.class));
			return (Tip) query.uniqueResult();
			}catch (Exception e){
				System.out.println("EROR EN EL DAO " + e);
				return null;
			}
	}

	@Override
	public void actualizarTip(TipDTO tip) {
		try{
			System.out.println("ESTOY EN EL DAO " +tip.toString());
		String sql = "UPDATE tip SET tip_description = :description  WHERE tip_id = :tipId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("tipId", tip.getTipId());
		query.setString("description", tip.getDescription());;
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + tip.toString());
		}catch(Exception e ){
			System.out.println(e);
		}
		
	}

	@Override
	public void eliminarTip(TipDTO tip) {
		try{
			System.out.println("ESTOY EN EL DAO " +tip.toString());
		String sql = "UPDATE tip SET tip_status = 0  WHERE tip_id = :tipId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("tipId", tip.getTipId());
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + tip.toString());
		}catch(Exception e ){
			System.out.println(e);
		}
		
	}
	@Transactional
	@Override
	public List getFilterTips() {
		try{
			String sql = "SELECT DISTINCT tip_id as tipId, tip_description as description FROM tip WHERE tip_status = 1 order by tip_id ";
			SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			query.addScalar("tipId",StandardBasicTypes.INTEGER);
			query.addScalar("description",StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(Tip.class));
			return query.list();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO TIP " + e);
			return null;
		}
	}	
}
