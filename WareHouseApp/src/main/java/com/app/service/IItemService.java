package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {

	public Integer saveItem(Item ob);
	public void updateItem(Item ob);
	public void deleteItem(Integer id);
	
	public Item getOneItem(Integer id);
	public List<Item> getAllItems();

	public List<Object[]> getBaseCurrencies();
}
