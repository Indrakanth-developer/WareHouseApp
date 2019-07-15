package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.charts.UoMCharts;
import com.app.model.UoM;
import com.app.service.IUoMService;
import com.app.view.UoMExcelView;
import com.app.view.UoMPdfView;

@Controller
@RequestMapping("/uom")
public class UoMController {

	// SERVICE LAYER HAS A VARIABLE
	@Autowired
	private IUoMService service;

	@Autowired
	private UoMCharts charts;
	@Autowired
	private ServletContext context;
	
	
	//1. UOM REGISTER PAGE
	@RequestMapping("/reg")
	public String registerUoM(ModelMap map) {
		UoM uoM=new UoM();
		map.addAttribute("uoM", uoM);
		return "UoMRegister";
	}

	//2. SAVING DETAILS TO DATABASE
	@RequestMapping("/save")
	public String saveUoM(@ModelAttribute UoM uoM,ModelMap map) {
		Integer id=service.saveUoM(uoM);
		String message="Saved "+id+" UoM Details Successfully";
		map.addAttribute("message", message);
		return "UoMRegister";
	}


	//3. View All Shipment records
	@RequestMapping("/viewall")
	public String viewAllUoMTypes(ModelMap map) {
		List<UoM> list=service.getAllUoMs();
		map.addAttribute("list", list);		
		return "UoMData";
	}


	//4. Delete a shipment Type Record
	@RequestMapping("/delete")
	public String deleteUoM(@RequestParam Integer id,ModelMap map)
	{
		//delete shipment
		service.deleteUoM(id);

		//Refresh Data for ShipmentTypeData Page
		List<UoM> list=service.getAllUoMs();

		//Send Updated data and confirmation to ShipmenttypeData page
		String msg="UoM Record with UoM ID: "+id+" Deleted Succesfully !!";
		//send updated data
		map.addAttribute("list", list);
		//send confirmation msg
		map.addAttribute("message", msg);

		return "UoMData";
	}

	//5. Edit Page
	@RequestMapping("/edit")
	public String editUoM(@RequestParam Integer id,ModelMap map) {
		//fetch data with given id from database
		UoM uoM=service.getOneUoM(id);
		//give details to UI
		map.addAttribute("uoM", uoM);

		return "UoMEdit";
	}

	//6. Update Record from Edit Page
	@RequestMapping("/update")
	public String updateUoM(@ModelAttribute UoM uoM,ModelMap map) {
		//save updated details to database
		service.updateUoM(uoM);
		//send updated data to UoMDataPage
		map.addAttribute("list", service.getAllUoMs());
		//send message confirmation to UoMDataPage
		map.addAttribute("message", "Updated Record with ID: "+uoM.getId()+" Successfully");

		return "UoMData";

	}

	//7. View One UoM Record
	@RequestMapping("/view")
	public String viewOneUoM(@RequestParam Integer id,ModelMap map) {
		//fetch record from db
		UoM u=service.getOneUoM(id);
		//give it to UoMViewOne Page
		map.addAttribute("obj", u);
		return "UoMViewOne";

	}

	//8. Excel Export
	@RequestMapping("/excel")
	public ModelAndView excelUoM(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UoMExcelView());
		if(id==null) {
			//send all rows
			m.addObject("list", service.getAllUoMs());
		}else
		{//send specified row
			m.addObject("list", Arrays.asList(service.getOneUoM(id)));

		}
		return m;
	}

	//9. Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView pdfUoM(@RequestParam(value="id",required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UoMPdfView());
		if(id==null) {
			//send all rows
			m.addObject("list", service.getAllUoMs());

		}else
		{m.addObject("list", Arrays.asList(service.getOneUoM(id)));
		}
		return m;
	}

	//10. Chart Generator
	
	@RequestMapping("/charts")
	public String generateUoMTypeCharts() {
		
		//pass real path and UoM Data Pie chart
		charts.generateUoMPieChart(context.getRealPath("/"), service.getUoMTypes());
		
		//pass real path and UoMData Bar chart
		charts.generateUoMBarChart(context.getRealPath("/"), service.getUoMTypes());
		return "UoMCharts";
	}
	
	
}
