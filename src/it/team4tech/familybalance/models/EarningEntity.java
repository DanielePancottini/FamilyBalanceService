package it.team4tech.familybalance.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import it.team4tech.familybalance.utils.Type;

@Entity
public class EarningEntity {

	@Id
	@GeneratedValue
	private Integer earningId;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type earningType;
	
	@Column(nullable = false)
	private String earningName;

	@Column(nullable = false)
	private String earningDescription;

	@Column(nullable = false)
	private Double earningValue;
	
	@ManyToOne(optional = false)
	@JoinColumn(insertable = false, updatable = false)
	private FamilyEntity earningFamily;
	
	//GETTERS & SETTERS

	public FamilyEntity getEarningFamily() {
		return earningFamily;
	}

	public void setEarningFamily(FamilyEntity earningFamily) {
		this.earningFamily = earningFamily;
	}

	public Integer getEarningId() {
		return earningId;
	}

	public void setEarningId(Integer earningId) {
		this.earningId = earningId;
	}

	public Type getEarningType() {
		return earningType;
	}

	public void setEarningType(Type earningType) {
		this.earningType = earningType;
	}

	public String getEarningName() {
		return earningName;
	}

	public void setEarningName(String earningName) {
		this.earningName = earningName;
	}

	public String getEarningDescription() {
		return earningDescription;
	}

	public void setEarningDescription(String earningDescription) {
		this.earningDescription = earningDescription;
	}

	public Double getEarningValue() {
		return earningValue;
	}

	public void setEarningValue(Double earningValue) {
		this.earningValue = earningValue;
	}
	
}
