package it.team4tech.familybalance.utils;

import com.google.gson.annotations.SerializedName;

public enum Type {
	
	@SerializedName("extra")
	EXTRA("extra"),
	@SerializedName("ordinary")
	ORDINARY("ordinary"),
	@SerializedName("ricorsive")
	RICORSIVE("ricorsive");
	
	private String value;
	
	private Type(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
