package com.pe.cms.yanbal.service;

import java.util.List;

import com.pe.cms.yanbal.pojo.Benefit;
import com.pe.cms.yanbal.pojo.Tip;

public interface BenefitService {
	public List getAllBenefits() ;
	public void addBenefit (Benefit benefit);
	public Benefit buscarPorIdBenefit(Benefit benefit);
	public void actualizarBenefit(Benefit benefit);
	public void eliminarBenefit(Benefit benefit);
}
