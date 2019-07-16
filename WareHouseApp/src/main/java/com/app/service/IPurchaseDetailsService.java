package com.app.service;

import java.util.List;

import com.app.model.PurchaseDetails;

public interface IPurchaseDetailsService {

	public Integer savePurchaseDetails(PurchaseDetails purchaseDetails);
	public void updatePurchaseDetails(PurchaseDetails purchaseDetails);
	public void deletePurchaseDetails(Integer id);
	public PurchaseDetails getOnePurchaseDetails(Integer id);
	public List<PurchaseDetails> getAllPurchaseDetailss();
	
	
}
