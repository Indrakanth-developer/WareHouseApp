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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whusertype")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;
	
	//1. Fetch one based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneWhUserType(@PathVariable Integer id){
		WhUserType whUserType=service.getOneWhUserType(id);
		ResponseEntity<?> responseEntity =null;
		if(whUserType!=null)
		responseEntity=new ResponseEntity<WhUserType>(whUserType,HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
			
		return responseEntity;
	}
	
	//2. Fetch all records
	@GetMapping("/getall")
	public ResponseEntity<?> getAllWhUserTypes(){
		List<WhUserType> list=service.getAllWhUserTypes();
		ResponseEntity<?> responseEntity =null;
		if(list.isEmpty()||list==null)
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
		else
			responseEntity=new ResponseEntity<List<WhUserType>>(list,HttpStatus.OK);
		return responseEntity;
	}
	
	//3. Delete a record
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneWhUserType(@PathVariable Integer id){
		try {
			service.deleteWhUserType(id);
			return new ResponseEntity<String>("Deleted Record with id: "+id+" Successfully",HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Record with id: "+id+" Not Found",HttpStatus.NOT_FOUND);
			
		}
	}
	
	//4. Save a record
	@PostMapping("/save")
	public ResponseEntity<String> saveOneWhUserType(@RequestBody WhUserType whUserType){
		
		return new ResponseEntity<String>("Saved with id: "+service.saveWhUserType(whUserType)+" Successfully",HttpStatus.OK);
	}
	
	//5. update a record
	@PutMapping
	public ResponseEntity<String> updateOneWhUserType(@RequestBody WhUserType whUserType){
		service.updateWhUserType(whUserType);
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	
}
