package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_tab")
public class Item {

	@Id
	@GeneratedValue
	@Column(name="itemid")
	private Integer id;
	private String itemCode;
	private String itemWidth;
	private String itemLength;
	private String itemHeight;
	private Double baseCost;
	private String baseCurrency;
	

	public Item(String itemCode, String itemWidth, String itemLength, String itemHeight, Double baseCost,
			String baseCurrency) {
		super();
		this.itemCode = itemCode;
		this.itemWidth = itemWidth;
		this.itemLength = itemLength;
		this.itemHeight = itemHeight;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
	}
	public Item(Integer id) {
		super();
		this.id = id;
	}
	public Item() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}
	public String getItemLength() {
		return itemLength;
	}
	public void setItemLength(String itemLength) {
		this.itemLength = itemLength;
	}
	public String getItemHeight() {
		return itemHeight;
	}
	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemCode=" + itemCode + ", itemWidth=" + itemWidth + ", itemLength=" + itemLength
				+ ", itemHeight=" + itemHeight + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + "]";
	}

	
}
