package it.team4tech.familybalance.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FamilyEntity {

	@Id
	@GeneratedValue
	private Integer familyId;
	
	@Column(nullable = false)
	private String familyName;
	
	@OneToMany(mappedBy = "costFamily", cascade = CascadeType.REMOVE)
	private List<CostEntity> familyCosts;
	
	@OneToMany(mappedBy = "earningFamily", cascade = CascadeType.REMOVE)
	private List<EarningEntity> familyEarnings;
	
	//GETTERS & SETTERS
	
	public List<CostEntity> getFamilyCosts() {
		return familyCosts;
	}
	public void setFamilyCosts(List<CostEntity> familyCosts) {
		this.familyCosts = familyCosts;
	}
	public List<EarningEntity> getFamilyEarnings() {
		return familyEarnings;
	}
	public void setFamilyEarnings(List<EarningEntity> familyEarnings) {
		this.familyEarnings = familyEarnings;
	}
	public Integer getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
}
