package com.pe.cms.yanbal.dao;

import java.util.List;

import com.pe.cms.yanbal.model.AdviserDTO;

public interface AdviserDao {
	
	public AdviserDTO getUserYambal(AdviserDTO adviser);
	public List getAllAdviser();
	 public void addAdviser(AdviserDTO adviser);

	

}
