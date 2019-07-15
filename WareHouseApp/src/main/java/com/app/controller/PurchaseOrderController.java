package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IShipmentTypeService shipmentService;
	@Autowired
	private IWhUserTypeService whUserService;
	
	//1. Reg page
	@RequestMapping("/reg")
	public String registerPurchaseOrderPage(ModelMap map) {
		
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		map.addAttribute("shipments", shipmentService.getAllShipmentTypes());
		map.addAttribute("vendors", whUserService.getWhUsersByType("Vendor"));
		return "PurchaseOrderRegister";
		
	}
}
