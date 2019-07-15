package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUoMDao;
import com.app.model.UoM;
import com.app.service.IUoMService;
@Service
public class UoMServiceImpl implements IUoMService {

	@Autowired
	private IUoMDao dao;
	@Override
	@Transactional
	public Integer saveUoM(UoM s) {
		
		return dao.saveUoM(s);
	}

	@Override
	@Transactional
	public void updateUoM(UoM s) {
		dao.updateUoM(s);

	}

	@Override
	@Transactional
	public void deleteUoM(Integer id) {
		dao.deleteUoM(id);

	}

	@Override
	@Transactional(readOnly=true)
	public UoM getOneUoM(Integer id) {
		
		return dao.getOneUoM(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<UoM> getAllUoMs() {
		
		return dao.getAllUoMs();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getUoMTypes() {
		return dao.getUoMTypes();
	}
}
