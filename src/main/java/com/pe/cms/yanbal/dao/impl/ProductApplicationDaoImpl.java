package com.pe.cms.yanbal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.ProductApplicationDao;
import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.model.ProductApplicationDTO;
import com.pe.cms.yanbal.pojo.Application;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.ProductApplication;
import com.pe.cms.yanbal.pojo.ApplicationProduct;

public class ProductApplicationDaoImpl implements ProductApplicationDao,Serializable {

	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public List getAllProductApllications(ProductDTO pro) {
		 String sql = "SELECT distinct * FROM product_application WHERE prod_id = :id and prap_status = 1 order by prap_id ";
		 SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		 query.setParameter("id", pro.getProdId());
		 query.addEntity(ProductApplicationDTO.class);
		 List results = query.list();
		 return results;
	}
	
	@Override
	public ProductApplication buscarPorIdProductApplication(ProductApplicationDTO productApplication) {
		try{
		System.out.println("ESTOY EN EL DAO " +  productApplication.toString());
		String sql = "SELECT prap_id as prapId FROM product_application WHERE prap_id = :id ";
		SQLQuery query =getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setParameter("id", productApplication.getPrapId());
		query.addScalar("prapId",StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(ProductApplication.class));
		return (ProductApplication) query.uniqueResult();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO " + e);
			return null;
		}
	}
	
	@Override
	public void addProductApplication(ProductApplicationDTO productApplication) {
		System.out.println("ESTOY EN EL DAO " + productApplication.toString());
		getSessionFactory().getCurrentSession().save(productApplication);
	}
	
	@Override
	public void eliminarProductoApplication(ProductApplicationDTO productApplication) {
		try{
		System.out.println("ESTOY EN EL DAO " + productApplication.toString());
		String sql = "UPDATE product_application SET prap_status = 0 WHERE prap_id = :id";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("id", productApplication.getPrapId());
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + productApplication.toString());
		}catch(Exception e ){
			System.out.println(e);
		}		
	}

	@Transactional
	@Override
	public List getAllTipsAndApplications() {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT pro.prod_description as producto, ap.appl_description as aplicacion, ti.tip_description as tip ");
		sql.append("FROM product_application prap,application ap, tip ti, product pro , product_tip poti ");
		sql.append("WHERE prap.prod_id = 3 and poti.prod_id =3 AND prap.prod_id = pro.prod_id and poti.prod_id = pro.prod_id ");
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql.toString());
		 query.addScalar("producto",StandardBasicTypes.STRING);
		 query.addScalar("beneficios",StandardBasicTypes.STRING);
		 query.addScalar("aplicacion",StandardBasicTypes.STRING);
		 query.addScalar("tip",StandardBasicTypes.STRING);
		 query.setResultTransformer(Transformers.aliasToBean(ApplicationProduct.class));
		 return (List) query.list();
	}

	@Override
	public void addProductoAndTip(ProductApplicationDTO productApplication) {
		try{
			System.out.println("ESTOY EN EL DAO " + productApplication.toString());
			String sql = "INSERT INTO product_application (prod_id, tip_id,prap_status,prap_status) VALUES (:prodId,:tipId,:prapStatus,:prapDate) ";
			SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			query.setParameter("prodId", productApplication.getProduct().getProdId());
			query.setParameter("tipId", productApplication.getTip().getTipId());
			query.setParameter("prapStatus", productApplication.getStatus());
			query.setParameter("prapDate", productApplication.getPrapDate());
			query.executeUpdate();
			System.out.println("EL DAO DEVUELVE " + productApplication.toString());
			}catch(Exception e ){
				System.out.println(e);
			}
	}

}
