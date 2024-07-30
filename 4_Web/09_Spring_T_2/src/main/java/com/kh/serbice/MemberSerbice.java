package com.kh.serbice;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.DAO.ex.MemberDAO;
import com.kh.model.vo.ex.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberSerbice {
	
	@Autowired
	private MemberDAO dao;
	
	
	

	public void register(Member vo) throws SQLException {
	
			dao.register(vo.getId(), vo.getPassword(), vo.getName());
	}
		
	
	public Member login(Member vo) throws SQLException {
		
		return  dao.login(vo.getId(), vo.getPassword());
	
	}
	
	
	
	public Member find(String id) throws SQLException {	
	
				return dao.search(id);
	}
		
		
	
		public List<Member> allMember( ) throws SQLException {
			
			
		return dao.all();

		}
		
		
		@GetMapping("logout")
		public String logout(HttpServletRequest request) {	
			
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			if(member != null) {
				session.invalidate();
			}
			
			return "redirect:/";
		
		
		
	
		
		

	

}}
