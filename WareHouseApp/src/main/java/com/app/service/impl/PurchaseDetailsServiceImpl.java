package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.IPurchaseDetailsDao;
import com.app.model.PurchaseDetails;
import com.app.service.IPurchaseDetailsService;

@Service
public class PurchaseDetailsServiceImpl implements IPurchaseDetailsService {

	@Autowired
	private IPurchaseDetailsDao dao;
	@Override
	@Transactional
	public Integer savePurchaseDetails(PurchaseDetails purchaseDetails) {
		
		return dao.savePurchaseDetails(purchaseDetails);
	}

	@Override
	@Transactional
	public void updatePurchaseDetails(PurchaseDetails purchaseDetails) {
		
		dao.updatePurchaseDetails(purchaseDetails);

	}

	@Override
	@Transactional
	public void deletePurchaseDetails(Integer id) {
		
		dao.deletePurchaseDetails(id);

	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseDetails getOnePurchaseDetails(Integer id) {
		
		return dao.getOnePurchaseDetails(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseDetails> getAllPurchaseDetailss() {
		
		return dao.getAllPurchaseDetailss();
	}

}
