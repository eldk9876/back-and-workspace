package com.kh.polymorphism.practice1.model;

public class Menu {

	private String name;
	private int age;
	private int coupon1;
	private boolean coupon2;
	private String bookList;
	private String title;
	private int accessAge;
	
	public Menu() {
	}
	
	public Menu(String name, int age, int coupon1, boolean coupon2, String bookList, String title, int accessAge) {
		this.name = name;
		this.age = age;
		this.coupon1 = coupon1;
		this.coupon2 = coupon2;
		this.bookList = bookList;
		this.title = title;
		this.accessAge = accessAge;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon1() {
		return coupon1;
	}
	public void setCoupon1(int coupon1) {
		this.coupon1 = coupon1;
	}
	public boolean isCoupon2() {
		return coupon2;
	}
	public void setCoupon2(boolean coupon2) {
		this.coupon2 = coupon2;
	}
	public String getBookList() {
		return bookList;
	}
	public void setBookList(String bookList) {
		this.bookList = bookList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAccessAge() {
		return accessAge;
	}
	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	
	@Override
	public String toString() {
		return "Menu [name=" + name + ", age=" + age + ", coupon1=" + coupon1 + ", coupon2=" + coupon2 + ", bookList="
				+ bookList + ", title=" + title + ", accessAge=" + accessAge + "]";
	}
	
	
	
	
	
}
