package com.pe.cms.yanbal.dao;

import java.util.List;

import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.model.TipDTO;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.Tip;

public interface TipDao {
	
	public List getAllTips();
	public void addTip (TipDTO tip);
	public Tip buscarPorIdTip(TipDTO tip);
	public void actualizarTip(TipDTO tip);
	public void eliminarTip(TipDTO tip);
	public List getFilterTips ();

}
