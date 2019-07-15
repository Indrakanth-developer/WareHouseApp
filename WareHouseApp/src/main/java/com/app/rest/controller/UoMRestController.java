package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.UoM;
import com.app.service.IUoMService;

@RestController
@RequestMapping("/rest/uom")
public class UoMRestController {

	@Autowired
	private IUoMService service;
	
	//1. Fetch one based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneUoM(@PathVariable Integer id){
		UoM uoM=service.getOneUoM(id);
		ResponseEntity<?> responseEntity =null;
		if(uoM!=null)
		responseEntity=new ResponseEntity<UoM>(uoM,HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
			
		return responseEntity;
	}
	
	//2. Fetch all records
	@GetMapping("/getall")
	public ResponseEntity<?> getAllUoMs(){
		List<UoM> list=service.getAllUoMs();
		ResponseEntity<?> responseEntity =null;
		if(list.isEmpty()||list==null)
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
		else
			responseEntity=new ResponseEntity<List<UoM>>(list,HttpStatus.OK);
		return responseEntity;
	}
	
	//3. Delete a record
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneUoM(@PathVariable Integer id){
		try {
			service.deleteUoM(id);
			return new ResponseEntity<String>("Deleted Record with id: "+id+" Successfully",HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Record with id: "+id+" Not Found",HttpStatus.NOT_FOUND);
			
		}
	}
	
	//4. Save a record
	@PostMapping("/save")
	public ResponseEntity<String> saveOneUoM(@RequestBody UoM uoM){
		
		return new ResponseEntity<String>("Saved with id: "+service.saveUoM(uoM)+" Successfully",HttpStatus.OK);
	}
	
	//5. update a record
	@PutMapping
	public ResponseEntity<String> updateOneUoM(@RequestBody UoM uoM){
		service.updateUoM(uoM);
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	
}
