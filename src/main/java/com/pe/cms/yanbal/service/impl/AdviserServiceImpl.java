package com.pe.cms.yanbal.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.pe.cms.yanbal.dao.AdviserDao;
import com.pe.cms.yanbal.model.AdviserDTO;
import com.pe.cms.yanbal.service.AdviserService;

@Transactional(readOnly = true)
public class AdviserServiceImpl implements AdviserService {

 
	@Autowired
	AdviserDao adviserDao;
//
//	@Override
//	public AdviserDTO yanbalLogin(AdviserDTO adviser) {
//		try {
//			String codeReturn = adviser.getCode();
//			if (!adviser.equals(Constant.IS_EMPTY)) {
//				System.out.println("el codigo del adviser es " + codeReturn);
//				return adviserDao.getUserYambal(new AdviserDTO(codeReturn));
//			} else {
////				return new AdviserDTO(new Message(false,Constant.MISSING_VALUES_PARAMETERS));
//			}
//		} catch (Exception e) {
//			log.error("Error at Select Adviser");
////			return new AdviserDTO(new Message(false, Constant.DATABASE_ERROR));
//		}
//		return adviser;
//	}

	@Transactional
	@Override
	public void saveAdviser(AdviserDTO adviser) {
		try {
			System.out.println("ENTRANDO EN EL DAO " + adviser.getCode());
			AdviserDTO adviser1 = new AdviserDTO();
			adviser1.setCode(adviser.getCode());
			adviser1.setAdviDate(new Date());
			adviser1.setStatus(1);
			getAdviserDao().addAdviser(adviser);
		} catch (Exception e) {
			System.out.println("ERROR EN EL DAO " + e);
		}
	}

	public AdviserDao getAdviserDao() {
		return adviserDao;
	}

	public void setAdviserDao(AdviserDao adviserDao) {
		this.adviserDao = adviserDao;
	}

	@Override
	public List getAllAdviser() {
		return adviserDao.getAllAdviser();
	}
}
