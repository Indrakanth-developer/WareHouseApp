package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseDetails {

	@Id
	@GeneratedValue
	private Integer id;
	
	//has-a-var
	@ManyToOne
	private Item item;
	
	private Integer quantity;
	
	//order codes and status
	private String orderCode;
	
	private String status;

	public PurchaseDetails(Integer id, Item item, Integer quantity) {
		super();
		this.id = id;
		this.item = item;
		this.quantity = quantity;
	}

	public PurchaseDetails(Integer id) {
		super();
		this.id = id;
	}

	public PurchaseDetails() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaseDetails [id=" + id + ", item=" + item + ", quantity=" + quantity + ", orderCode=" + orderCode
				+ ", status=" + status + "]";
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PurchaseDetails(String status) {
		super();
		this.status = status;
	}
	
	
	
}
