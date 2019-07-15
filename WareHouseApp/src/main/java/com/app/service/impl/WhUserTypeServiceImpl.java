package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	@Override
	@Transactional
	public Integer saveWhUserType(WhUserType s) {
		
		return dao.saveWhUserType(s);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType s) {
		
		dao.updateWhUserType(s);

	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer id) {
		
		dao.deleteWhUserType(id);

	}

	@Override
	@Transactional(readOnly=true)
	public WhUserType getOneWhUserType(Integer id) {
		
		return dao.getOneWhUserType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		
		return dao.getAllWhUserTypes();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getUserTypes() {
		return dao.getUserTypes();
	}
}
