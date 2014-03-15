package com.pe.cms.yanbal.dao;

import java.util.List;

import com.pe.cms.yanbal.model.BenefitDTO;
import com.pe.cms.yanbal.model.TipDTO;
import com.pe.cms.yanbal.pojo.Benefit;
import com.pe.cms.yanbal.pojo.Tip;

public interface BenefitDao {
	
	public List getAllBenefits();
	public void addBenefit (BenefitDTO bene);
	public Benefit buscarPorIdBenefit(BenefitDTO bene);
	public void actualizarBenefit(BenefitDTO bene);
	public void eliminarBenefit(BenefitDTO bene);
	public List getFilterBenefit ();

}
