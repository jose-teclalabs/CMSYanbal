package com.pe.cms.yanbal.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.ProductDao;
import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.service.ProductService;

public class ProductServiceImpl implements ProductService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ProductDao productDao;
	
	@Transactional
	@Override
	public void addProduct(Product product) {
		try{
			ProductDTO producto =  new ProductDTO();
			producto.setDescription(product.getDescription());
			producto.setDetails(product.getDetails());
			producto.setType(product.getType());
			producto.setStatus(product.getStatus());
			producto.setProdDate(product.getProdDate());
			getProductDao().addProduct(producto);
		}catch(Exception e){
			System.out.println("eerrror " + e);
		}
		
	}
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public List getAllProducts() {
		return productDao.getFilterProduct();
	}
	
	@Transactional
	@Override
	public Product buscarPorIdProduct(Product product) {
		try{	
			Integer newProductId = product.getProdId();
			System.out.println("estoy en el service " + product.getProdId());
			return getProductDao().buscarPorIdProduct(new ProductDTO(newProductId));
		}catch(Exception e){
			System.out.println("eerrror " + e);
			return null;
		}
	}
	
	@Transactional
	@Override
	public Product capturarIdProduct(Product product) {
		try{	
			Integer newProductId = product.getProdId();
			System.out.println("estoy en el service " + product.getProdId());
			return getProductDao().capturarIdProduct(new ProductDTO(newProductId));
		}catch(Exception e){
			System.out.println("eerrror " + e);
			return null;
		}
	}
	@Transactional
	@Override
	public void actualizarProducto(Product product) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + product.toString());
			ProductDTO productContainer = new ProductDTO();
			productContainer.setProdId(product.getProdId());
			productContainer.setDescription(product.getDescription());
			productContainer.setDetails(product.getDetails());
			productContainer.setType(product.getType());
			productDao.actualizarProducto(productContainer);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	@Transactional
	@Override
	public void actualizarPhotoProducto(Product product) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + product.toString());
			ProductDTO productContainer = new ProductDTO();
			productContainer.setProdId(product.getProdId());
			productContainer.setPhoto(product.getPhoto());
			productDao.actualizarPhoto(productContainer);
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	@Transactional
	@Override
	public void eliminarProducto(Product product) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + product.toString());
			ProductDTO productContainer = new ProductDTO();
			productContainer.setProdId(product.getProdId());
			productDao.eliminarProducto(productContainer);
		}catch(Exception e){
			System.out.println(e);
		}		
	}
}
