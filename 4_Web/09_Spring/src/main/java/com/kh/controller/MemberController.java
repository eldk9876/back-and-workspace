package com.kh.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.model.DAO.ex.MemberDAO;
import com.kh.model.vo.ex.MemberEx;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(MemberEx member) {
		try {
			dao.register(member.getId(), member.getPassword(), member.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
		
}
