package com.pe.cms.yanbal.service;

import java.util.List;

import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.Tip;

public interface TipService {
	
	public List getAllTips() ;
	public void addTip (Tip tip);
	public Tip buscarPorIdTip(Tip tip);
	public void actualizarTip(Tip tip);
	public void eliminarTip(Tip tip);
}
