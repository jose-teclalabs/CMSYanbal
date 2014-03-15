package com.pe.cms.yanbal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.BenefitDao;
import com.pe.cms.yanbal.model.BenefitDTO;
import com.pe.cms.yanbal.model.TipDTO;
import com.pe.cms.yanbal.pojo.Benefit;
import com.pe.cms.yanbal.pojo.Tip;

public class BenefitDaoImpl implements BenefitDao,Serializable {

	private static final long serialVersionUID = 1L;
	
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List getAllBenefits() {
		String sql = "SELECT DISTINCT * FROM benefit WHERE bene_status = 1 order by bene_id ";
		 SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		 query.addEntity(BenefitDTO.class);
		 List results = query.list();
		 return results;
	}

	@Override
	public void addBenefit(BenefitDTO bene) {
		System.out.println("ESTOY EN EL DAO " + bene.toString());
		getSessionFactory().getCurrentSession().save(bene);
		
	}

	@Override
	public Benefit buscarPorIdBenefit(BenefitDTO bene) {
		try{
		System.out.println("ESTOY EN EL DAO " +  bene.toString());
		String sql = "SELECT bene_id as beneId, bene_description as description FROM benefit WHERE bene_id = :id ";
		SQLQuery query =getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setParameter("id", bene.getBeneId());
		query.addScalar("beneId",StandardBasicTypes.INTEGER);
		query.addScalar("description",StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(Benefit.class));
		return (Benefit) query.uniqueResult();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO " + e);
			return null;
		}
	}

	@Override
	public void actualizarBenefit(BenefitDTO bene) {
		try{
			System.out.println("ESTOY EN EL DAO " +bene.toString());
		String sql = "UPDATE benefit SET bene_description = :description  WHERE bene_id = :beneId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("beneId", bene.getBeneId());
		query.setString("description", bene.getDescription());;
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + bene.toString());
		}catch(Exception e ){
			System.out.println(e);
		}
	}

	@Override
	public void eliminarBenefit(BenefitDTO bene) {
		try{
		System.out.println("ESTOY EN EL DAO " +bene.toString());
		String sql = "UPDATE benefit SET bene_status = 0  WHERE bene_id = :beneId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("beneId", bene.getBeneId());
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + bene.toString());
		}catch(Exception e ){
			System.out.println(e);
		}
		
	}

	@Transactional
	@Override
	public List getFilterBenefit() {
		try{
			String sql = "SELECT DISTINCT bene_id as beneId, bene_description as description FROM benefit WHERE bene_status = 1 order by bene_id ";
			SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			query.addScalar("beneId",StandardBasicTypes.INTEGER);
			query.addScalar("description",StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(Benefit.class));
			return query.list();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO TIP " + e);
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
