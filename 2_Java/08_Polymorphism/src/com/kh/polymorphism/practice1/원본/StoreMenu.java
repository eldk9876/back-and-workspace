package com.kh.polymorphism.practice1.model;

public class StoreMenu {

	
	private String title;
	private boolean coupon;
	private int accessAge;
	
	public StoreMenu() {
	}
	
	public StoreMenu(String title, boolean coupon, int accessAge) {
		this.title = title;
		this.coupon = coupon;
		this.accessAge = accessAge;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean getCoupon() {
		return coupon;
	}
	public void setCoupon(boolean b) {
		this.coupon = b;
	}
	public int getAccessAge() {
		return accessAge;
	}
	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	
	@Override
	public String toString() {
		return "StoreMenu [title=" + title + ", coupon=" + coupon + ", accessAge=" + accessAge + "]";
	}
	 

	
}
