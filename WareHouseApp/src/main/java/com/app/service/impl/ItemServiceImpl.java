package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Override
	@Transactional
	public Integer saveItem(Item ob) {
		return dao.saveItem(ob);
	}

	@Override
	@Transactional
	public void updateItem(Item ob) {
		dao.updateItem(ob);
	}

	@Override
	@Transactional
	public void deleteItem(Integer id) {
		dao.deleteItem(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Item getOneItem(Integer id) {
		return dao.getOneItem(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getBaseCurrencies() {
		return dao.getBaseCurrencies();
	}
}
