package com.kh.example.practice3.model;

public class Practice3Employee extends Object {

	private int empNo;
	private String name;
	private char gender;
	private String phone;
	private String dept;
	private int salary;
	private double bonus;
	public int setEmpNo;
	public String setName;
	public char setGender;
	public String setPhone;
	
	public Practice3Employee() {
	}
	
	public Practice3Employee(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		this.empNo = empNo;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.dept = dept;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	/*
	@Override
	public String toString() {
		return super.toString() "Employee [empNo=" + empNo + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", dept="
				+ dept + ", salary=" + salary + ", bonus=" + bonus + "]";
	}*/
	
	
	
	
}
