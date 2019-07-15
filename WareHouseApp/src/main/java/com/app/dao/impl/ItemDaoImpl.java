package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveItem(Item ob) {
		return (Integer)ht.save(ob);
	}

	@Override
	public void updateItem(Item ob) {
		ht.update(ob);
	}

	@Override
	public void deleteItem(Integer id) {
		ht.delete(new Item(id));
	}

	@Override
	public Item getOneItem(Integer id) {
		return ht.get(Item.class, id);
	}

	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getBaseCurrencies() {
		// TODO Auto-generated method stub
		return (List<Object[]>) ht.find("select baseCurrency,count(baseCurrency) from  "+Item.class.getName()+" group by baseCurrency");
	}
}
