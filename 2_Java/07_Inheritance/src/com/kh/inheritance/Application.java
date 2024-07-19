package com.kh.inheritance;

import com.kh.inheritance.child.Notebook;
import com.kh.inheritance.child.SmertPhone;

public class Application {

	public static void main(String[] args) {
		
		//Notebook notebook = new Notebook("애플","app-01","맥북 프로 16",3400000,"M3");
		
		//System.out.println(notebook);
		//SmertPhone smartPhone = new SmertPhone("삼성","sam-02","갤럭시 S24",1500000,"SKT");
		SmertPhone smartPhone = new SmertPhone();
		smartPhone.setBrand("삼성");
		smartPhone.setpCode("sam-02");
		smartPhone.setName("갤럭시 S24");
		smartPhone.setPrice(1500000);
		smartPhone.setAgency("SKT");
		
		
	}

}
