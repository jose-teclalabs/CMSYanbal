package com.pe.cms.yanbal.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.TipDao;
import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.model.TipDTO;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.Tip;
import com.pe.cms.yanbal.service.TipService;

public class TipServiceImpl implements TipService, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	TipDao tipDao;
		
	@Override
	public List getAllTips() {
		return getTipDao().getAllTips();
	}

	public TipDao getTipDao() {
		return tipDao;
	}

	public void setTipDao(TipDao tipDao) {
		this.tipDao = tipDao;
	}

	@Transactional
	@Override
	public void addTip(Tip tip) {
		try{
			System.out.println("ESTOY EN EL SERVICE " + tip.toString());
			TipDTO tipreturn =  new TipDTO();
			tipreturn.setDescription(tip.getDescription());
			tipreturn.setStatus(tip.getStatus());
			tipreturn.setTipDate(tip.getTipDate());
			getTipDao().addTip(tipreturn);
		}catch(Exception e){
			System.out.println("eerrror " + e);
		}		
	}
	
	@Transactional
	@Override
	public Tip buscarPorIdTip(Tip tip) {
		try{	
			Integer newProductId = tip.getTipId();
			System.out.println("estoy en el service " + tip.getTipId());
			return getTipDao().buscarPorIdTip(new TipDTO(newProductId));
		}catch(Exception e){
			System.out.println("eerrror " + e);
			return null;
		}
	}

	@Transactional
	@Override
	public void actualizarTip(Tip tip) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + tip.toString());
			TipDTO tipContainer = new TipDTO();
			tipContainer.setTipId(tip.getTipId());
			tipContainer.setDescription(tip.getDescription());
			getTipDao().actualizarTip(tipContainer);
		}catch(Exception e){
			System.out.println(e);
		}		
	}
	@Transactional
	@Override
	public void eliminarTip(Tip tip) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + tip.toString());
			TipDTO tipContainer = new TipDTO();
			tipContainer.setTipId(tip.getTipId());
			getTipDao().eliminarTip(tipContainer);
		}catch(Exception e){
			System.out.println(e);
		}		
	}
}
