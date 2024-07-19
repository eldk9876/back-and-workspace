package com.kh.polymorphism.practice1.model;


public class Mypage {
//	private Mypage m = new Mypage();

	
	private String name;
	private int age;
	private int coupon;
	private String bookList;

	
	
	
	public Mypage() {
	}
	
	
	public Mypage(String name, int age, int coupon, String bookList) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
	}
	
	public Mypage(String string) {
		this.bookList = bookList;
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
	
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public String getBookList() {
		return bookList;
	}
	public void setBookList(String i) {
		this.bookList = i;
	}
	
	
	@Override
	public String toString() {
		return "Mypage [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList=" + bookList + "]";
	}


	public void setBookList(int int1) {
		// TODO Auto-generated method stub
		
	}


	
/*
	public Mypage info() {
		return m;
	}
	*/

	
	
}
