package com.pe.cms.yanbal.dao;

import java.util.List;

import com.pe.cms.yanbal.model.ProductApplicationDTO;
import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.pojo.ProductApplication;

public interface ProductApplicationDao {
	
	public List getAllProductApllications(ProductDTO pro);
	public void addProductApplication(ProductApplicationDTO productApplication);
	public ProductApplication buscarPorIdProductApplication(ProductApplicationDTO productApplication) ;
	public void eliminarProductoApplication(ProductApplicationDTO productApplication);
	public List getAllTipsAndApplications ();
	public void addProductoAndTip(ProductApplicationDTO productApplication);

}
