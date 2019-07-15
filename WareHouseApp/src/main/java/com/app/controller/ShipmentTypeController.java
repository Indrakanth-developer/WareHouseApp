package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.charts.ShipmentTypeModeCharts;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	// Service Layer HAS-A variable
	@Autowired
	private IShipmentTypeService service;
	//To fetch Servlet real path for chart generators 
	@Autowired
	private ServletContext context;
	//Chart Generator class HAS-A variables
	@Autowired
	private ShipmentTypeModeCharts chart;
	
	
	
	//1. Register Page
	@RequestMapping("/reg")
	public String registerShipmentType(ModelMap map) {
	ShipmentType shipmentType=new ShipmentType();
	map.addAttribute("shipmentType", shipmentType);
		return "ShipmentTypeRegister";
	}

	//2. Saving Registration Details
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		Integer id=service.saveShipmentType(shipmentType);
		String message=id+" Successfully saved Shipmment !!";
		//Sending message to UI
		map.addAttribute("message",message);
		
		return "ShipmentTypeRegister";		
	}

	//3. View All Shipment records
	@RequestMapping("/viewall")
	public String viewAllShipmentTypes(ModelMap map) {
		List<ShipmentType> list=service.getAllShipmentTypes();
		map.addAttribute("list", list);		
		return "ShipmentTypeData";
	}
	
	//4. Delete a shipment Type Record
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer id,ModelMap map)
	{
		//delete shipment
		service.deleteShipmentType(id);

		//Refresh Data for ShipmentTypeData Page
		List<ShipmentType> list=service.getAllShipmentTypes();
		
		//Send Updated data and confirmation to ShipmenttypeData page
		String message="ShipmentType Record with Shipment ID: "+id+" Deleted Succesfully !!";
		//send updated data
		map.addAttribute("list", list);
		//send confirmation message
		map.addAttribute("message", message);		
		
		return "ShipmentTypeData";
	}
	
	//5. Edit page
	@RequestMapping("/edit")
	public String editShipmentType(@RequestParam Integer id,ModelMap map)
	{
		//call service layer to fetch particular object
		ShipmentType shipmentType=service.getOneShipmentType(id);
		//add to page form backing object
		map.addAttribute("shipmentType",shipmentType);
				
		return "ShipmentTypeEdit";
		
	}
	
	//6. Update Record from Edit Page
	@RequestMapping("/update")
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		//save updated details to database
		service.updateShipmentType(shipmentType);
		//send updated data to ShipmentTypeDataPage
		map.addAttribute("mylist", service.getAllShipmentTypes());
		//print updated message on ShipmentTypeDataPage
		map.addAttribute("message", "Updated Record with ID: "+shipmentType.getId()+" Successfully");
		
		return "ShipmentTypeData";
	}

	//7. View One ShipmentType Record
	@RequestMapping("/view")
	public String viewOneShipmentType(@RequestParam Integer id,ModelMap map) {
		//fetch record from db
		ShipmentType s=service.getOneShipmentType(id);
		//give it to ShipmentTypeViewOne Page
		map.addAttribute("obj", s);
		return "ShipmentTypeViewOne";
		
	}
	
	//8. Excel Export
	@RequestMapping("/excel")
	public ModelAndView excelShipmentType(@RequestParam(value="id", required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		
		if(id==null)
		{//for loading all rows
			m.addObject("list", service.getAllShipmentTypes());
		}else
		{//for loading specific row
			m.addObject("list", Arrays.asList(service.getOneShipmentType(id)));
		}
		return m;
	}
	
	
	//9. PDF Export
	@RequestMapping("/pdf")
	public ModelAndView pdfShipmentType(@RequestParam(value="id",required=false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		
		if(id==null) {//for all rows
			List<ShipmentType> list=service.getAllShipmentTypes();
			m.addObject("list", list);
		}else
		{//for specific row
		m.addObject("list", Arrays.asList(service.getOneShipmentType(id)));
}
		return m;
	}
	
	//10. Generate Charts
	@RequestMapping("/charts")
	public String generateShipmentTypeModeCharts() {
		
		//fetch Data
		List<Object[]> list=service.getShipmentTypeModesCount();
		
		//fetch path
		String path=context.getRealPath("/");
		
		//call Pie chart Generator method
		chart.generateShipmentTypePieCharts(path, list);
		
		//call Bar Chart Generator method
		chart.generateShipmentTypeBarChart(path, list);
		
		return "ShipmentTypeCharts";
	}
	
	
}