package it.team4tech.familybalance.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.team4tech.familybalance.utils.Type;

@Entity
public class CostEntity {

	@Id
	@GeneratedValue
	private Integer costId;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type costType;
	
	@Column(nullable = false)
	private String costName;
	
	@Column(nullable = false)
	private String costDescription;
	
	@Column(nullable = false)
	private Double costValue;
	
	@ManyToOne(optional = false)
	@JoinColumn
	private FamilyEntity costFamily;

	//GETTERS & SETTERS
	
	public FamilyEntity getCostFamily() {
		return costFamily;
	}

	public void setCostFamily(FamilyEntity costFamily) {
		this.costFamily = costFamily;
	}

	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public Type getCostType() {
		return costType;
	}

	public void setCostType(Type costType) {
		this.costType = costType;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public String getCostDescription() {
		return costDescription;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}

	public Double getCostValue() {
		return costValue;
	}

	public void setCostValue(Double costValue) {
		this.costValue = costValue;
	}
	
}
