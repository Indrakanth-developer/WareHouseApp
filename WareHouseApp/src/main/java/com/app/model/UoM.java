package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uom_tab")
public class UoM {

	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer id;
	
	private String uomType;
	private String uomModel;
	private String uomDescription;
	public UoM() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getUomDescription() {
		return uomDescription;
	}
	public void setUomDescription(String uomDescription) {
		this.uomDescription = uomDescription;
	}
	@Override
	public String toString() {
		return "UoM [id=" + id + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDescription="
				+ uomDescription + "]";
	}
	public UoM(Integer id) {
		super();
		this.id = id;
	}
	public UoM(Integer id, String uomType, String uomModel, String uomDescription) {
		super();
		this.id = id;
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.uomDescription = uomDescription;
	}

	
}
