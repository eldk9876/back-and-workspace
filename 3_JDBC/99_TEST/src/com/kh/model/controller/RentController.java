package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Rent;

public class RentController {
	
	private RentDAO rent = new RentDAO();
	
	// 1. 책 대여
		public boolean rentBook(int memberNo, int bookNo) {
			// 같은 책을 여러 사용자가 대여할 수 있는지? 책이 1권이라고 가정!
			// 다른 사람은 대여 못하게! 본인 뿐만 아니라 다른 사람도 대여 못하게
			
			try {
				if(rent.checkRentBook(bookNo)) {
					// 이미 대여된 책이 없으면 대여 가능!
					rent.rentBook(memberNo, bookNo);
					return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			return false;
		}
		// 2. 내가 대여한 책 조회
		public ArrayList<Rent> printRentBook(int memberNo) {

			try {
				return rent.printRentBook(memberNo) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
			
		}
		// 3. 대여 취소
		public boolean deleteRent(int no) {
			try {
				if(rent.deleteRent(no) == 1 )return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
			
		}
		
			
		
		
		
		
		
		
		
		
}
