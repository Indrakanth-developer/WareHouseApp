package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseDetails;
import com.app.model.PurchaseOrder;
import com.app.service.IItemService;
import com.app.service.IPurchaseDetailsService;
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
	@Autowired
	private IItemService itemService;

	@Autowired
	private IPurchaseDetailsService purchaseDetailsService;



	//1. Reg page
	@RequestMapping("/reg")
	public String registerPurchaseOrderPage(Model map) {

		map.addAttribute("purchaseOrder", new PurchaseOrder());
		map.addAttribute("shipments", shipmentService.getAllShipmentTypes());
		map.addAttribute("vendors", whUserService.getWhUsersByType("Vendor"));
		return "PurchaseOrderRegister";

	}

	//2. Save page
	@RequestMapping("/save")
	public String savePurchaseOrderPage(@ModelAttribute PurchaseOrder purchaseOrder,Model map) {


		map.addAttribute("purchaseOrder", new PurchaseOrder());
		map.addAttribute("shipments", shipmentService.getAllShipmentTypes());
		map.addAttribute("vendors", whUserService.getWhUsersByType("Vendor"));
		map.addAttribute("message", "Saved with id: "+service.savePurchaseOrder(purchaseOrder)+" Successfully");
		return "PurchaseOrderRegister";
	}

	//3. All purchase orders
	@RequestMapping("/viewall")
	public String viewAllPurchaseOrders(Model map) {
		map.addAttribute("list", service.getAllPurchaseOrders());
		return "PurchaseOrderData";

	}
	//4. Edit page
	@RequestMapping("/edit")
	public String editPurchaseOrder(@RequestParam Integer id,Model map) {
		map.addAttribute("purchaseOrder", service.getOnePurchaseOrder(id));
		return "PurchaseOrderEdit";
	}

	//5. Update order
	@RequestMapping("/update")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Model map) {
		service.updatePurchaseOrder(purchaseOrder);
		//updated data
		map.addAttribute("list", service.getAllPurchaseOrders());
		map.addAttribute("message", "Record updated successfully");
		return "PurchaseOrderData";
	}
	//6. delete order
	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam Integer id, Model map) {
		service.deletePurchaseOrder(id);
		//updated data
		map.addAttribute("list", service.getAllPurchaseOrders());
		map.addAttribute("message", "Record deleted successfully");
		return "PurchaseOrderData";
	}
	//7. view one order
	@RequestMapping("/view")
	public String viewOnePurchaseOrder(@RequestParam Integer id,Model map) {
		map.addAttribute("purchaseOrder", service.getOnePurchaseOrder(id));
		return "PurchaseOrderViewOne";
	}

	//8. Purchase Details Items page
	@RequestMapping("/item")
	public String itemPurchaseOrder(@RequestParam Integer id,Model map) {
		PurchaseOrder purchaseOrder=service.getOnePurchaseOrder(id);
		PurchaseDetails purchaseDetails=new PurchaseDetails();
		purchaseDetails.setOrderCode(purchaseOrder.getOrderCode());
		List<PurchaseDetails> list=purchaseDetailsService.getAllPurchaseDetailss();
		if(list.isEmpty()||list==null)
			purchaseDetails.setStatus("OPEN");
		else
			purchaseDetails.setStatus("PICKING");
		map.addAttribute("purchaseDetails", purchaseDetails);
		map.addAttribute("items", itemService.getAllItems());
		//table- fetch all purchase details
		map.addAttribute("list", purchaseDetailsService.getAllPurchaseDetailss());
		
		return "PurchaseDetailsAddItems";
	}

	//9. Purchase Details Add To cart
	@RequestMapping("/add")
	public String itemAddToCartPurchaseOrder(@ModelAttribute(value="purchaseDetails")PurchaseDetails oldPurchaseDetails,Model map) {
		//save to db
		purchaseDetailsService.savePurchaseDetails(oldPurchaseDetails);

		PurchaseDetails purchaseDetails=new PurchaseDetails("PICKING");
		purchaseDetails.setOrderCode(oldPurchaseDetails.getOrderCode());
		//fresh form backing object
		map.addAttribute("purchaseDetails", purchaseDetails);
		//dynamic drop down
		map.addAttribute("items", itemService.getAllItems());

		//table- fetch all purchase details
		map.addAttribute("list", purchaseDetailsService.getAllPurchaseDetailss());


		return "PurchaseDetailsAddItems";
	}

	//10. PurchaseDetails Delete operation
	@RequestMapping("/deleteitem")
	public String deletePurchaseItem(@RequestParam Integer id,Model map,@ModelAttribute(value="purchaseDetails")PurchaseDetails oldPurchaseDetails) {
		purchaseDetailsService.deletePurchaseDetails(id);
		PurchaseDetails purchaseDetails=new PurchaseDetails();
		purchaseDetails.setOrderCode(oldPurchaseDetails.getOrderCode());
		map.addAttribute("items", itemService.getAllItems());
		List<PurchaseDetails> list=purchaseDetailsService.getAllPurchaseDetailss();
		if(list.isEmpty()||list==null)
			purchaseDetails.setStatus("OPEN");
		else
			purchaseDetails.setStatus("PICKING");
		map.addAttribute("purchaseDetails", purchaseDetails);
		map.addAttribute("list", list);

		return "PurchaseDetailsAddItems";
	}
}
