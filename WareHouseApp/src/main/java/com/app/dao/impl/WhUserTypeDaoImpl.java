package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	
	public Integer saveWhUserType(WhUserType s) {
		
		return (Integer)ht.save(s);
	}

	@Override
	
	public void updateWhUserType(WhUserType s) {
		
		ht.update(s);
	}

	@Override
	
	public void deleteWhUserType(Integer id) {
		
		ht.delete(new WhUserType(id));

	}

	@Override
	
	public WhUserType getOneWhUserType(Integer id) {
		
		return ht.get(WhUserType.class, id);
	}

	@Override
	
	public List<WhUserType> getAllWhUserTypes() {
		
		return ht.loadAll(WhUserType.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUserTypes() {
		return (List<Object[]>) ht.find("select userType, count(userType) from  "+WhUserType.class.getName()+"  group by userType");
	}
}
