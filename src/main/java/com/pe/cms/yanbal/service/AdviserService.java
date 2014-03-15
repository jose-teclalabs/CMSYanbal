package com.pe.cms.yanbal.service;

import java.util.List;

import com.pe.cms.yanbal.model.AdviserDTO;

public interface AdviserService {
//	public AdviserDTO yanbalLogin (AdviserDTO adviser);
	public void saveAdviser(AdviserDTO adviser);
	 public List getAllAdviser();

}
