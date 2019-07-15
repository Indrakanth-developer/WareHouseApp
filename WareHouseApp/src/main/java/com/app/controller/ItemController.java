package com.app.controller;

import java.util.Arrays;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.charts.ItemCharts;
import com.app.model.Item;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUoMService;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;

@Controller
@RequestMapping("/item")
public class ItemController {
	// SERVICE LAYER HAS A VARIABLE
	@Autowired
	private IItemService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ItemCharts charts;
	
	//module integration with uom
	@Autowired
	private IUoMService uomService;
	@Autowired
	private IOrderMethodService orderMethodService;
	
	//1. DISPLAY REGISTER PAGE
	@RequestMapping("/reg")
	public String itemRegiser(ModelMap map)
	{
		//form backing object
		map.addAttribute("item", new Item());
		//module integration drop down
		map.addAttribute("uoms", uomService.getAllUoMs());
		map.addAttribute("orderMethods", orderMethodService.getAllOrderMethods());
		//return view name
		return "ItemRegister";
	}
	
	//2. SAVING DETAILS TO DATABASE
	@RequestMapping("/save")
	public String itemSave(@ModelAttribute Item item,ModelMap map) {
		//save to DB
		Integer id=service.saveItem(item);

		//give updated message to UI page
		String message="Saved Item with ID: "+id+" Successfully !!";
		map.addAttribute("message", message);
		return "ItemRegister";
	}
	//3. VIEW ALL ITEM RECORDS
	
	@RequestMapping("/viewall")
	public String viewAllItems(ModelMap map)
	{
		//fetch records from db
		map.addAttribute("list", service.getAllItems());
		
		return "ItemData";
		
	}
	//4. DELETE A ITEM RECORD
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam Integer id,ModelMap map) {
		
		//delete the record
		service.deleteItem(id);
		//send updated data to ItemData Page
		map.addAttribute("list", service.getAllItems());
		//send Message to UI
		String message="Deleted Item Record with ID: "+id+" Successfully !!";
		map.addAttribute("message", message);
		
		return "ItemData";
	}
	
	//5. EDIT A ITEM RECORD
	@RequestMapping("/edit")
	public String editItem(@RequestParam Integer id,ModelMap map) {
		//fetch record from db
		map.addAttribute("item", service.getOneItem(id));
		//module integration drop down
		map.addAttribute("uoms", uomService.getAllUoMs());
		map.addAttribute("orderMethods", orderMethodService.getAllOrderMethods());
		
		return "ItemEdit";
	}
	
	//6. UPDATE ITEM RECORD FROM EDIT PAGE
	@RequestMapping("/update")
	public String updateItem(@ModelAttribute Item item,ModelMap map) {
		
		//update to db
		service.updateItem(item);
		//fetch updated db  details to display in ItemData page
		map.addAttribute("list", service.getAllItems());
		map.addAttribute("message", "Updated Record Successfully!!");
		return "ItemData";
	}
	
	//7. VIEW ONE ITEM RECORD
	@RequestMapping("view")
	public String viewOneItem(@RequestParam Integer id, ModelMap map) {
		//fetch details from db
		map.addAttribute("obj",service.getOneItem(id));

		return "ItemViewOne";
	}

	//8. Excel Export
	@RequestMapping("/excel")
	public ModelAndView generateItemExcel(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ItemExcelView());
		if(id==null) {
			m.addObject("list", service.getAllItems());
		}
		else {
			m.addObject("list", Arrays.asList(service.getOneItem(id)));
		}
		return m;
	}
	//9. Pdf View
	@RequestMapping("/pdf")
	public ModelAndView generateItemPdf(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView(new ItemPdfView());
		if(id==null) {//all rows
			m.addObject("list", service.getAllItems());
		}else
		{//selected id row 
			m.addObject("list", Arrays.asList(service.getOneItem(id)));
		}
		return m;
	}
	
	//10. Chart Generators
	@RequestMapping("/charts")
	public String generateItemCharts() {
		
		System.out.println(service.getBaseCurrencies());
		//pie chart
		charts.generateItemPieChart(context.getRealPath("/"), service.getBaseCurrencies());
		//bar chart
		charts.generateItemBarChart(context.getRealPath("/"), service.getBaseCurrencies());
		
		return "ItemCharts";
	}
	
}
