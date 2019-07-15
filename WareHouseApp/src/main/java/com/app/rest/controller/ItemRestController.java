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

import com.app.model.Item;
import com.app.service.IItemService;

@RestController
@RequestMapping("/rest/item")
public class ItemRestController {

	@Autowired
	private IItemService service;
	
	//1. Fetch one based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneItem(@PathVariable Integer id){
		Item item=service.getOneItem(id);
		ResponseEntity<?> responseEntity =null;
		if(item!=null)
		responseEntity=new ResponseEntity<Item>(item,HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
			
		return responseEntity;
	}
	
	//2. Fetch all records
	@GetMapping("/getall")
	public ResponseEntity<?> getAllItems(){
		List<Item> list=service.getAllItems();
		ResponseEntity<?> responseEntity =null;
		if(list.isEmpty()||list==null)
			responseEntity=new ResponseEntity<String>("Data Not Available",HttpStatus.NOT_FOUND);
		else
			responseEntity=new ResponseEntity<List<Item>>(list,HttpStatus.OK);
		return responseEntity;
	}
	
	//3. Delete a record
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneItem(@PathVariable Integer id){
		try {
			service.deleteItem(id);
			return new ResponseEntity<String>("Deleted Record with id: "+id+" Successfully",HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Record with id: "+id+" Not Found",HttpStatus.NOT_FOUND);
			
		}
	}
	
	//4. Save a record
	@PostMapping("/save")
	public ResponseEntity<String> saveOneItem(@RequestBody Item item){
		
		return new ResponseEntity<String>("Saved with id: "+service.saveItem(item)+" Successfully",HttpStatus.OK);
	}
	
	//5. update a record
	@PutMapping
	public ResponseEntity<String> updateOneItem(@RequestBody Item item){
		service.updateItem(item);
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	
}
