package com.pe.cms.yanbal.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pe.cms.yanbal.dao.BenefitDao;
import com.pe.cms.yanbal.model.BenefitDTO;
import com.pe.cms.yanbal.pojo.Benefit;
import com.pe.cms.yanbal.service.BenefitService;

public class BenefitServiceImpl implements BenefitService,Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	BenefitDao benefitDao;	
	
	@Override
	public List getAllBenefits() {
		return getBenefitDao().getFilterBenefit();
	}
	
	@Transactional
	@Override
	public void addBenefit(Benefit benefit) {
		try{
			System.out.println("ESTOY EN EL SERVICE " + benefit.toString());
			BenefitDTO benefitReturn =  new BenefitDTO();
			benefitReturn.setDescription(benefit.getDescription());
			benefitReturn.setStatus(benefit.getStatus());
			benefitReturn.setBeneDate(benefit.getBeneDate());
			getBenefitDao().addBenefit(benefitReturn);
		}catch(Exception e){
			System.out.println("eerrror " + e);
		}
		
	}
	
	@Transactional
	@Override
	public Benefit buscarPorIdBenefit(Benefit benefit) {
		try{	
			Integer newBenefittId = benefit.getBeneId();
			System.out.println("estoy en el service " + benefit.getBeneId());
			return getBenefitDao().buscarPorIdBenefit(new BenefitDTO(newBenefittId));
		}catch(Exception e){
			System.out.println("eerrror " + e);
			return null;
		}
	}
	
	@Transactional
	@Override
	public void actualizarBenefit(Benefit benefit) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + benefit.toString());
			BenefitDTO benefitContainer = new BenefitDTO();
			benefitContainer.setBeneId(benefit.getBeneId());
			benefitContainer.setDescription(benefit.getDescription());
			getBenefitDao().actualizarBenefit(benefitContainer);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Transactional
	@Override
	public void eliminarBenefit(Benefit benefit) {
		try{
			System.out.println("ESTOY EN EL SERVICIO " + benefit.toString());
			BenefitDTO benefitContainer = new BenefitDTO();
			benefitContainer.setBeneId(benefit.getBeneId());
			getBenefitDao().eliminarBenefit(benefitContainer);
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
}
