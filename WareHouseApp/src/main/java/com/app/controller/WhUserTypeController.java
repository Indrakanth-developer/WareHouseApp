package com.app.controller;

import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.charts.WhUserTypeCharts;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	// Service Layer HAS-A variable
	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WhUserTypeCharts charts;
	
	//1. Register Page
	@RequestMapping("/reg")
	public String registerWhUserType(ModelMap map) {
	WhUserType whUserType=new WhUserType();
	map.addAttribute("whUserType", whUserType);
		return "WhUserTypeRegister";
	}

	//2. Saving Registration Details
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveWhUserType(@ModelAttribute WhUserType whUserType,ModelMap map) {
		Integer id=service.saveWhUserType(whUserType);
		String message="Successfully saved WhUserType with ID: "+ id;
		//Sending message to UI
		map.addAttribute("message",message);
		
		return "WhUserTypeRegister";		
	}

	//3. View All WhUserType records
	@RequestMapping("/viewall")
	public String viewAllWhUserTypes(ModelMap map) {
		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("list", list);		
		return "WhUserTypeData";
	}
	
	//4. Delete a WhUserType Record
	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam Integer id,ModelMap map)
	{
		//delete WhUserType
		service.deleteWhUserType(id);

		//Refresh Data for WhUserTypeData Page
		List<WhUserType> list=service.getAllWhUserTypes();
		
		//Send Updated data and confirmation to WhUserTypeData page
		String message="WhUserType Record with WhUserType ID: "+id+" Deleted Succesfully !!";
		//send updated data
		map.addAttribute("list", list);
		//send confirmation message
		map.addAttribute("message", message);		
		
		return "WhUserTypeData";
	}
	
	//5. Edit page
	@RequestMapping("/edit")
	public String editWhUserType(@RequestParam Integer id,ModelMap map)
	{
		//call service layer to fetch particular object
		WhUserType whUserType=service.getOneWhUserType(id);
		//add to page form backing object
		map.addAttribute("whUserType",whUserType);
				
		return "WhUserTypeEdit";
		
	}
	
	//6. Update Record from Edit Page
	@RequestMapping("/update")
	public String updateWhUserType(@ModelAttribute WhUserType whUserType,ModelMap map) {
		//save updated details to database
		service.updateWhUserType(whUserType);
		//send updated data to WhUserTypeDataPage
		map.addAttribute("list", service.getAllWhUserTypes());
		//print updated message on WhUserTypeDataPage
		map.addAttribute("message", "Updated Record with ID: "+whUserType.getId()+" Successfully");
		
		return "WhUserTypeData";
	}

	//7. View One WhUserType Record
	@RequestMapping("/view")
	public String viewOneWhUserType(@RequestParam Integer id,ModelMap map) {
		//fetch record from db
		WhUserType s=service.getOneWhUserType(id);
		//give it to WhUserTypeViewOne Page
		map.addAttribute("obj", s);
		return "WhUserTypeViewOne";
		
	}
	
	//8. Excel Export
	@RequestMapping("/excel")
	public ModelAndView excelWhUserType(@RequestParam(value="id",required=false)Integer id) {
		
		ModelAndView m=new ModelAndView();
		//set view object
		m.setView(new WhUserTypeExcelView());
		//set data
		m.addObject("list", service.getAllWhUserTypes());
	
		return m;
	}
	
	//9. Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView pdfWhUserType(@RequestParam(value="id",required=false)Integer id) {
		
		ModelAndView m=new ModelAndView();
		//set view object
		m.setView(new WhUserTypePdfView());
		//provide data
		m.addObject("list", service.getAllWhUserTypes());
		return m;
	}
	
	//10. Charts
	@RequestMapping("/charts")
	public String generateWhUserTypeCharts() {
		
		//Call Pie Chart method
		charts.generateWhUserTypePieChart(context.getRealPath("/"), service.getUserTypes());
		
		//Call Bar Chart method
		charts.generateWhUserTypeBarChart(context.getRealPath("/"), service.getUserTypes());
				
		return "WhUserTypeCharts";
	}
	
	
}
