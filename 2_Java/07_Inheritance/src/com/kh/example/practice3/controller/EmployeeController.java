package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController  {
	
	private Employee employee = new Employee();
	
	public void add(int empNo, String name, char gender, String phone) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		
		//super(empNo, name, gender, phone, dept, salary, bonus);
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	}
	public void modify(String phone) {
	
		/*	phone = phone;
		return phone;*/
		employee.setPhone(phone);
		
	}
	public void modify(int salary) {
		/*salary = salary;
		return salary;*/
		employee.setSalary(salary);
	}
	public void modify(double bonus) {
		//bonus = bonus;
	//	return bonus;
		employee.setBonus(bonus);
		
	}
	
		public Employee info() {
			return employee;
		}
		
	}
	
	
	
	
	
	
//}
