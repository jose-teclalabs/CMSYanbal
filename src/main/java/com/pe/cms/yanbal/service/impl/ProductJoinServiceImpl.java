package com.pe.cms.yanbal.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.ApplicationDao;
import com.pe.cms.yanbal.dao.BenefitDao;
import com.pe.cms.yanbal.dao.ProductDao;
import com.pe.cms.yanbal.dao.ProductApplicationDao;
import com.pe.cms.yanbal.dao.TipDao;
import com.pe.cms.yanbal.model.ApplicationDTO;
import com.pe.cms.yanbal.model.BenefitDTO;
import com.pe.cms.yanbal.model.ProductApplicationDTO;
import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.model.TipDTO;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.ProductApplication;
import com.pe.cms.yanbal.service.ProductJoinService;

public class ProductJoinServiceImpl implements ProductJoinService,Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	ProductApplicationDao productApplicationDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	ApplicationDao applicationDao;
	@Autowired
	TipDao tipDao;
	@Autowired
	BenefitDao benefitDao;

	
	public ProductApplicationDao getProductApplicationDao() {
		return productApplicationDao;
	}

	public void setProductApplicationDao(ProductApplicationDao productApplicationDao) {
		this.productApplicationDao = productApplicationDao;
	}

	@Override
	public List getAllProductApplications(ProductDTO prod) {
		
		return getProductApplicationDao().getAllProductApllications(prod);
	}
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List getAllProducts() {
		return getProductDao().getFilterProduct();
	}

	@Override
	public List getAllApplicattions() {
		return getApplicationDao().getFilterAppplication();
	}

	public ApplicationDao getApplicationDao() {
		return applicationDao;
	}

	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}

	@Override
	public List getAllTips() {
		return getTipDao().getFilterTips();
	}

	public TipDao getTipDao() {
		return tipDao;
	}

	public void setTipDao(TipDao tipDao) {
		this.tipDao = tipDao;
	}

	@Transactional
	@Override
	public void addProductApplication(ProductApplication productApplication) {
		try{
			ProductApplicationDTO productoApp =  new ProductApplicationDTO();
			productoApp.setApplication(new ApplicationDTO(productApplication.getAppldId()));
			productoApp.setProduct(new ProductDTO(productApplication.getProdId()));
			productoApp.setBenefit(new BenefitDTO(productApplication.getBeneId()));
			productoApp.setTip(new TipDTO(productApplication.getTipId()));
			productoApp.setStatus(productApplication.getStatus());
			productoApp.setPrapDate(productApplication.getPrapDate());
			getProductApplicationDao().addProductApplication(productoApp);
		}catch(Exception e){
			System.out.println("eerrror " + e);
		}
	}
	
	@Transactional
	@Override
	public ProductApplication buscarPorIdProductApplication(ProductApplication productApplication) {
		try{	
			Integer newProductId = productApplication.getPrapId();
			System.out.println("estoy en el service " + productApplication.getPrapId());
			return getProductApplicationDao().buscarPorIdProductApplication(new ProductApplicationDTO(newProductId));
		}catch(Exception e){
			System.out.println("eerrror " + e);
			return null;
		}
	}
	
	@Transactional
	@Override
	public void eliminarProductoApplication(ProductApplication productApplication) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + productApplication.toString());
			ProductApplicationDTO productApplicationContainer = new ProductApplicationDTO();
			productApplicationContainer.setPrapId(productApplication.getPrapId());
			getProductApplicationDao().eliminarProductoApplication(productApplicationContainer);
		}catch(Exception e){
			System.out.println(e);
		}		
	}

	public BenefitDao getBenefitDao() {
		return benefitDao;
	}

	public void setBenefitDao(BenefitDao benefitDao) {
		this.benefitDao = benefitDao;
	}

	@Override
	public List getAllBenefits() {
		return getBenefitDao().getFilterBenefit();
	}

	@Transactional
	@Override
	public void addProductoAndTip(ProductApplication productApplication) {
		try{
			ProductApplicationDTO productoApp =  new ProductApplicationDTO();
			productoApp.setProduct(new ProductDTO(productApplication.getProdId()));
			productoApp.setTip(new TipDTO(productApplication.getTipId()));
			productoApp.setStatus(productApplication.getStatus());
			productoApp.setPrapDate(productApplication.getPrapDate());
			getProductApplicationDao().addProductoAndTip(productoApp);
		}catch(Exception e){
			System.out.println("eerrror " + e);
		}	
	}
}
