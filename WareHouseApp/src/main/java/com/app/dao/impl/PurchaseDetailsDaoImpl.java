package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDetailsDao;
import com.app.model.PurchaseDetails;

@Repository
public class PurchaseDetailsDaoImpl implements IPurchaseDetailsDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	
	public Integer savePurchaseDetails(PurchaseDetails purchaseDetails) {
		
		return (Integer)ht.save(purchaseDetails);
	}

	@Override
	
	public void updatePurchaseDetails(PurchaseDetails purchaseDetails) {
		
		ht.update(purchaseDetails);
	}

	@Override
	
	public void deletePurchaseDetails(Integer id) {
		
		ht.delete(new PurchaseDetails(id));

	}

	@Override
	
	public PurchaseDetails getOnePurchaseDetails(Integer id) {
		
		return ht.get(PurchaseDetails.class, id);
	}

	@Override
	
	public List<PurchaseDetails> getAllPurchaseDetailss() {
		
		return ht.loadAll(PurchaseDetails.class);
	}



}
