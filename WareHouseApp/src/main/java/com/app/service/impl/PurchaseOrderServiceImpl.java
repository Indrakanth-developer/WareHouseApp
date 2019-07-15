package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;
	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		
		return dao.savePurchaseOrder(purchaseOrder);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		
		dao.updatePurchaseOrder(purchaseOrder);

	}

	@Override
	@Transactional
	public void deletePurchaseOrder(Integer id) {
		
		dao.deletePurchaseOrder(id);

	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		
		return dao.getOnePurchaseOrder(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		
		return dao.getAllPurchaseOrders();
	}

}
