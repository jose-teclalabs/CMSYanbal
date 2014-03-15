package com.pe.cms.yanbal.dao;

import java.util.List;

import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.pojo.Product;

public interface ProductDao {
	
	public void addProduct (ProductDTO product);
	public List getAllProducts();
	public Product buscarPorIdProduct(ProductDTO product);
	public void actualizarProducto(ProductDTO product);
	public void actualizarPhoto(ProductDTO product);
	public void eliminarProducto(ProductDTO product);
	public Product capturarIdProduct(ProductDTO product);
	public List getFilterProduct ();
}
