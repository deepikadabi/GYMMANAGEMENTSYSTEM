package com.cdac.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue
	private int uId;
	private String uName;
	private String uEmail;
	private String uPass;
	private int uNum;
	private int uAge;
	private String uDate;
	private String uBloodGroup;
	private String uCity;
	@ManyToOne
	@JoinColumn(name="pId")
	private GymPackage gymPackage;
	
	public User() {
		super();
	}
	public User(int uId, String uName, String uEmail, String uPass, int uNum, int uAge, String uDate,
			String uBloodGroup, String uCity) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPass = uPass;
		this.uNum = uNum;
		this.uAge = uAge;
		this.uDate = uDate;
		this.uBloodGroup = uBloodGroup;
		this.uCity = uCity;
	}
	
	public User(int uId) {
		super();
		this.uId = uId;
	}
	
	
	
	public GymPackage getGymPackage() {
		return gymPackage;
	}
	public void setGymPackage(GymPackage gymPackage) {
		this.gymPackage = gymPackage;
	}
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public int getuNum() {
		return uNum;
	}
	public void setuNum(int uNum) {
		this.uNum = uNum;
	}
	public int getuAge() {
		return uAge;
	}
	public void setuAge(int uAge) {
		this.uAge = uAge;
	}
	public String getuDate() {
		return uDate;
	}
	public void setuDate(String uDate) {
		this.uDate = uDate;
	}
	public String getuBloodGroup() {
		return uBloodGroup;
	}
	public void setuBloodGroup(String uBloodGroup) {
		this.uBloodGroup = uBloodGroup;
	}
	public String getuCity() {
		return uCity;
	}
	public void setuCity(String uCity) {
		this.uCity = uCity;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uPass=" + uPass + ", uNum=" + uNum
				+ ", uAge=" + uAge + ", uDate=" + uDate + ", uBloodGroup=" + uBloodGroup + ", uCity=" + uCity
				+ ", gymPackage=" + gymPackage + "]";
	}
	
	
}
