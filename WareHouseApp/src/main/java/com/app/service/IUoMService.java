package com.app.service;

import java.util.List;

import com.app.model.UoM;

public interface IUoMService {

	public Integer saveUoM(UoM s);
	public void updateUoM(UoM s);
	public void deleteUoM(Integer id);
	public UoM getOneUoM(Integer id);
	public List<UoM> getAllUoMs();
	
	public List<Object []> getUoMTypes();

}
