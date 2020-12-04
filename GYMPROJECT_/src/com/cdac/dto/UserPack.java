package com.cdac.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class UserPack {

	@Id
	@GeneratedValue
	private int cartId;
	@ManyToOne
	@JoinColumn(name="uId")
	private User user;

	@ManyToOne
	@JoinColumn(name="pId")
	private GymPackage gymPackage;
	public UserPack() {
		super();
	}
	public UserPack(int cartId, User user, GymPackage gymPackage) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.gymPackage = gymPackage;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public GymPackage getGymPackage() {
		return gymPackage;
	}
	public void setGymPackage(GymPackage gymPackage) {
		this.gymPackage = gymPackage;
	}
	@Override
	public String toString() {
		return "UserPack [cartId=" + cartId + ", user=" + user + ", gymPackage=" + gymPackage + "]";
	}
	
	
}
