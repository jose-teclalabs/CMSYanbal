package com.pe.cms.yanbal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.ProductDao;
import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.pojo.Product;

public class ProductDaoImpl implements ProductDao, Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(ProductDaoImpl.class);

	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(ProductDTO product) {
		getSessionFactory().getCurrentSession().save(product);		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	 public List getAllProducts() {
//		 return getSessionFactory().getCurrentSession().createQuery("from ProductDTO order by prodDate asc").list();
		 String sql = "SELECT distinct * FROM product WHERE prod_status = 1 order by prod_id ";
		 SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		 query.addEntity(ProductDTO.class);
		 List results = query.list();
		 return results;
	}
	
	@Override
	public Product buscarPorIdProduct(ProductDTO product) {
		try{
		System.out.println("ESTOY EN EL DAO " +  product.toString());
		String sql = "SELECT prod_id as prodId, prod_description as description, prod_details as details, prod_type as type, prod_photo as photo FROM product WHERE prod_id = :id ";
		SQLQuery query =getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setParameter("id", product.getProdId());
		query.addScalar("prodId",StandardBasicTypes.INTEGER);
		query.addScalar("description",StandardBasicTypes.STRING);
		query.addScalar("details",StandardBasicTypes.STRING);
		query.addScalar("type",StandardBasicTypes.STRING);
		query.addScalar("photo",StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(Product.class));
		return (Product) query.uniqueResult();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO " + e);
			return null;
		}
	}
	
	@Override
	public Product capturarIdProduct(ProductDTO product) {
		try{
		System.out.println("ESTOY EN EL DAO " +  product.toString());
		String sql = "SELECT prod_id as prodId FROM product WHERE prod_id = :id ";
		SQLQuery query =getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setParameter("id", product.getProdId());
		query.addScalar("prodId",StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Product.class));
		return (Product) query.uniqueResult();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO " + e);
			return null;
		}
	}

	@Override
	public void actualizarProducto(ProductDTO product) {
		try{
			System.out.println("ESTOY EN EL DAO " + product.toString());
		String sql = "UPDATE product SET prod_description = :description, prod_details = :details, prod_type = :type  WHERE prod_id = :prodId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("prodId", product.getProdId());
		query.setString("description", product.getDescription());
		query.setString("details", product.getDetails());
		query.setString("type", product.getType());
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + product.toString());
		}catch(Exception e ){
			System.out.println(e);
		}
	}

	@Override
	public void actualizarPhoto(ProductDTO product) {
		try{
			System.out.println("ESTOY EN EL DAO " + product.toString());
		String sql = "UPDATE product SET prod_photo = :photo WHERE prod_id = :prodId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("prodId", product.getProdId());
		query.setString("photo", product.getPhoto());
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + product.toString());
		}catch(Exception e ){
			System.out.println(e);
		}		
	}

	@Override
	public void eliminarProducto(ProductDTO product) {
		try{
		System.out.println("ESTOY EN EL DAO " + product.toString());
		String sql = "UPDATE product SET prod_status = 0 WHERE prod_id = :prodId";
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setInteger("prodId", product.getProdId());
		query.executeUpdate();
		System.out.println("EL DAO DEVUELVE " + product.toString());
		}catch(Exception e ){
			System.out.println(e);
		}		
	}

	@Transactional
	@Override
	public List getFilterProduct() {		
		try{
			String sql = "SELECT DISTINCT prod_id as prodId, prod_description as description FROM product WHERE prod_status = 1 order by prod_id ";
			SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			query.addScalar("prodId",StandardBasicTypes.INTEGER);
			query.addScalar("description",StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(Product.class));
			return query.list();
		}catch (Exception e){
			System.out.println("EROR EN EL DAO " + e);
			return null;
		}
	}
}
