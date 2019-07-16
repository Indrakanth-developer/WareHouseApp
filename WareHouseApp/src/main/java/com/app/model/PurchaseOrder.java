package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String orderCode;
	//has-a-variable
	@ManyToOne
	private ShipmentType shipmentType;
	
	@ManyToOne
	private WhUserType whVendor;
	
	private String referenceNumber;
	private String qualityCheck;
	@Column(name="purchase_status")
	private String status;
	private String description;
	
	//purchaseDetail has-a
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<PurchaseDetails> purchaseDetails;
	
	
	public PurchaseOrder() {
		super();
		status="OPEN";
	}
	public PurchaseOrder(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ShipmentType getShipmentType() {
		return shipmentType;
	}
	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}
	public WhUserType getWhVendor() {
		return whVendor;
	}
	public void setWhVendor(WhUserType whVendor) {
		this.whVendor = whVendor;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", orderCode=" + orderCode + ", shipmentType=" + shipmentType + ", whVendor="
				+ whVendor + ", referenceNumber=" + referenceNumber + ", qualityCheck=" + qualityCheck + ", status="
				+ status + ", description=" + description + ", purchaseDetails=" + purchaseDetails + "]";
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public List<PurchaseDetails> getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(List<PurchaseDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	
	
	
}
