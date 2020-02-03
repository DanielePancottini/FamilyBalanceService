package it.team4tech.familybalance.domain;

import it.team4tech.familybalance.utils.Type;

/**
 * 
 * Class representing the family earning
 * 
 * @author Daniele Pancottini
 *
 */
public class Earning {

	private Integer earningId;
	private Type earningType;
	private String earningName;
	private String earningDescription;
	private Double earningValue;
	private Family earningFamily;
	
	//GETTERS & SETTERS

	public Family getEarningFamily() {
		return earningFamily;
	}
	public void setEarningFamily(Family earningFamily) {
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
