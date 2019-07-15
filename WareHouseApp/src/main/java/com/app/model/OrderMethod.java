package com.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="order_method_tab")
public class OrderMethod {

	@Id
	@GeneratedValue
	private Integer id;
	private String orderMode;
	private String orderCode;
	private String executionType;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String>orderAccept;
	private String description;
	
	
	
	
	public OrderMethod(Integer id, String orderMode, String orderCode, String executionType, List<String> orderAccept,
			String description) {
		super();
		this.id = id;
		this.orderMode = orderMode;
		this.orderCode = orderCode;
		this.executionType = executionType;
		this.orderAccept = orderAccept;
		this.description = description;
	}
	public OrderMethod(Integer id) {
		super();
		this.id = id;
	}
	public OrderMethod() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
	public List<String> getOrderAccept() {
		return orderAccept;
	}
	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", executionType="
				+ executionType + ", orderAccept=" + orderAccept + ", description=" + description + "]";
	}
	
	
	
}
