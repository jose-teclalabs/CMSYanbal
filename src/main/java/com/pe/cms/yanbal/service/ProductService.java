package com.pe.cms.yanbal.service;

import java.util.List;

import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.pojo.Product;

public interface ProductService {
	public void addProduct (Product product);
	public List getAllProducts() ;
	public Product buscarPorIdProduct(Product product);
	public void actualizarProducto(Product product);
	public void actualizarPhotoProducto(Product product);
	public void eliminarProducto(Product product);
	public Product capturarIdProduct(Product product);
	
	

}
