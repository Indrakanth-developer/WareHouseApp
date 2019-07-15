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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {

	@Autowired
	private IShipmentTypeService service;
	
	//1. Fetch one based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneShipmentType(@PathVariable Integer id){
		ShipmentType shipmentType=service.getOneShipmentType(id);
		ResponseEntity<?> responseEntity =null;
		if(shipmentType!=null)
		responseEntity=new ResponseEntity<ShipmentType>(shipmentType,HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
			
		return responseEntity;
	}
	
	//2. Fetch all records
	@GetMapping("/getall")
	public ResponseEntity<?> getAllShipmentTypes(){
		List<ShipmentType> list=service.getAllShipmentTypes();
		ResponseEntity<?> responseEntity =null;
		if(list.isEmpty()||list==null)
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
		else
			responseEntity=new ResponseEntity<List<ShipmentType>>(list,HttpStatus.OK);
		return responseEntity;
	}
	
	//3. Delete a record
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneShipmentType(@PathVariable Integer id){
		try {
			service.deleteShipmentType(id);
			return new ResponseEntity<String>("Deleted Record with id: "+id+" Successfully",HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Record with id: "+id+" Not Found",HttpStatus.NOT_FOUND);
			
		}
	}
	
	//4. Save a record
	@PostMapping("/save")
	public ResponseEntity<String> saveOneShipmentType(@RequestBody ShipmentType shipmentType){
		
		return new ResponseEntity<String>("Saved with id: "+service.saveShipmentType(shipmentType)+" Successfully",HttpStatus.OK);
	}
	
	//5. update a record
	@PutMapping
	public ResponseEntity<String> updateOneShipmentType(@RequestBody ShipmentType shipmentType){
		service.updateShipmentType(shipmentType);
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	
}
