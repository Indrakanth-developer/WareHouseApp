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

import com.app.charts.OrderMethodCharts;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	//Service layer HAS-A variable link
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodCharts charts;
	@Autowired
	private ServletContext context;
	
	//1. Register page
	@RequestMapping("/reg")
	public String registerOrderMethod(ModelMap map) {
		
		//form backing object for spring forms
		map.addAttribute("orderMethod", new OrderMethod());
		
		return "OrderMethodRegister";
	}
	
	//2. Save page
	@RequestMapping("/save")
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,ModelMap map)
	{
		//call to service layer to save
		Integer id=service.saveOrderMethod(orderMethod);
		
		//return save operation result
		map.addAttribute("message", "Saved your OrderMethod with ID: "+id+"Succesfully");
		
		//give fresh object to page after saving the previous object
		map.addAttribute("orderMethod",new OrderMethod());
		
		return "OrderMethodRegister";
	}
	
	//3. View All page
	@RequestMapping("/viewall")
	public String viewAllOrderMethods(ModelMap map){
		map.addAttribute("list",service.getAllOrderMethods());
		return "OrderMethodData";
	}

	//4. Delete a record by id
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer id,ModelMap map) {
		
		//delete a record
		service.deleteOrderMethod(id);
		//send updated records to page
		map.addAttribute("list", service.getAllOrderMethods());
		
		return "OrderMethodData";
		
	}
	
	//5. Edit page
		@RequestMapping("/edit")
		public String editShipmentType(@RequestParam Integer id,ModelMap map)
		{
			//call service layer to fetch particular object
			OrderMethod orderMethod=service.getOneOrderMethod(id);
			//add to page form backing object
			map.addAttribute("orderMethod",orderMethod);
					
			return "OrderMethodEdit";
			
		}
		
		//6. Update Record from Edit Page
		@RequestMapping("/update")
		public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
			//save updated details to database
			service.updateOrderMethod(orderMethod);
			//send updated data to OrderMethodDataPage
			map.addAttribute("mylist", service.getAllOrderMethods());
			//print updated message on OrderMethodDataPage
			map.addAttribute("message", "Updated Record with ID: "+orderMethod.getId()+" Successfully");
			
			return "OrderMethodData";
		}
		
		//7. View One OrderMethod Record
		@RequestMapping("/view")
		public String viewOneOrderMethod(@RequestParam Integer id,ModelMap map) {
			
			//fetch details from database and pass to ui
			map.addAttribute("obj", service.getOneOrderMethod(id));
			
			return "OrderMethodViewOne";
		}
	
		//8. Excel Export
		@RequestMapping("/excel")
		public ModelAndView excelOrderMethod(@RequestParam(value="id",required=false)Integer id) {
			ModelAndView m=new ModelAndView();
			m.setView(new OrderMethodExcelView());
			if(id==null)
			{//all rows
				m.addObject("list", service.getAllOrderMethods());
			}else
			{//only specific row
				m.addObject("list", Arrays.asList(service.getOneOrderMethod(id)));
			}
			return m;
		}

		//9. Pdf Export
		@RequestMapping("/pdf")
		public ModelAndView pdfOrderMethod(@RequestParam(value="id",required=false)Integer id) {
			ModelAndView m=new ModelAndView();
			m.setView(new OrderMethodPdfView());
			if(id==null) {
				//all rows
				m.addObject("list", service.getAllOrderMethods());
				}else {
					//specific row
					m.addObject("list", service.getOneOrderMethod(id));
				}
			return m;
			
		}
		
		//10. Generate Charts
		@RequestMapping("/charts")
		public String generateOrderMethodModeCharts() {
			
			//send path and object array as input
			charts.generatePieChart(context.getRealPath("/"), service.getOrderMethodModesCount());
			
			//bar chart
			charts.generateBarChart(context.getRealPath("/"), service.getOrderMethodModesCount());
			
			return "OrderMethodCharts";
		}
		
		
		
		
		
}
