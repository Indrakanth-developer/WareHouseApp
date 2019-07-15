package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUoMDao;
import com.app.model.UoM;

@Repository
public class UoMDaoImpl implements IUoMDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUoM(UoM s) {
		
		return (Integer)ht.save(s);
	}

	@Override
	public void updateUoM(UoM s) {
		
		ht.update(s);
	}

	@Override
	public void deleteUoM(Integer id) {
		
		ht.delete(new UoM(id));
		
	}

	@Override
	public UoM getOneUoM(Integer id) {
		
		return ht.get(UoM.class, id);
	}

	@Override
	public List<UoM> getAllUoMs() {
		
		return ht.loadAll(UoM.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUoMTypes() {

		
		return (List<Object[]>) ht.find("select uomType, count(uomType) from  "+UoM.class.getName()+"  group by uomType");
	}
}
