package com.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/doc")
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	//1. Show doc Page
	@RequestMapping("/reg")
	public String showDocumentPage(Model map) {
		//form backing object
		map.addAttribute("document", new Document());
		map.addAttribute("list", service.getFileIdsAndFileNames());
		return "Documents";
	}
	
	//2. Upload Doc page
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadDocument(@RequestParam CommonsMultipartFile fileData,Model map) {
		if(fileData!=null) {
		Document doc=new Document();
		//set name of the file
		doc.setFileName(fileData.getOriginalFilename());
		//set in byte array format
		doc.setFileData(fileData.getBytes());
		Integer id=service.saveDocument(doc);
		map.addAttribute("message", "Uploaded "+id+" record successfully");
		}
		return "redirect:reg";
	}
	
	//3. Doc download
	@RequestMapping("/download")
	public void downloadDocument(@RequestParam String id,HttpServletResponse resp) {
		//Fetch data from service layer
		Document doc=service.getOneDocument(Integer.parseInt(id));
		//Construct Servlet Response object
		//Add Head part= downloadable and file naming
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		//Add body
		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
