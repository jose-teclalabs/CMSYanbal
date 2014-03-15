package com.pe.cms.yanbal.service;

import java.util.List;

import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.ProductApplication;


public interface ProductJoinService {
	public List getAllProductApplications(ProductDTO prod);
	public List getAllProducts();
	public List getAllApplicattions();
	public List getAllTips();
	public List getAllBenefits();
	public void addProductApplication(ProductApplication productApplication);
	public ProductApplication buscarPorIdProductApplication(ProductApplication productApplication);
	public void eliminarProductoApplication(ProductApplication productApplication);
	public void addProductoAndTip(ProductApplication productApplication);
}
