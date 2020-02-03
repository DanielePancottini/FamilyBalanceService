package it.team4tech.familybalance.domain;

import it.team4tech.familybalance.utils.Type;

/**
 * 
 * This class represents the family cost
 * 
 * @author Daniele Pancottini
 *
 */
public class Cost {

	private Integer costId;
	private Type costType;
	private String costName;
	private String costDescription;
	private Double costValue;
	private Family costFamily;

	//GETTERS & SETTERS
	
	public Family getCostFamily() {
		return costFamily;
	}
	public void setCostFamily(Family costFamily) {
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
