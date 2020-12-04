package com.cdac.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GymPackage {
	@Id
	@GeneratedValue
	private int pId;
	private String pName;
	private String pTime;
	private String pMonth;
	private float pCharge;
	
	public GymPackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GymPackage(int pId, String pName, String pTime, String pMonth, float pCharge) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pTime = pTime;
		this.pMonth = pMonth;
		this.pCharge = pCharge;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	public String getpMonth() {
		return pMonth;
	}

	public void setpMonth(String pMonth) {
		this.pMonth = pMonth;
	}

	public float getpCharge() {
		return pCharge;
	}

	public void setpCharge(float pCharge) {
		this.pCharge = pCharge;
	}

	@Override
	public String toString() {
		return "GymPackage [pId=" + pId + ", pName=" + pName + ", pTime=" + pTime + ", pMonth=" + pMonth + ", pCharge="
				+ pCharge + "]";
	}

	public GymPackage(int pId) {
		super();
		this.pId = pId;
	}
	
	
	
	
}
