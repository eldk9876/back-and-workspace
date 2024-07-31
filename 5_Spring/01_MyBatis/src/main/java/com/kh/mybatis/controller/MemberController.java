package com.kh.mybatis.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	/*private MemberService service;
	
	public MemberController(MemberService service) {
		this.service = service;
	}*/
	//-> 시작
	@Autowired //위와 같음
	private MemberService service;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allMember", service.allMember());
		
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}
	
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}
	
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vo", service.login(vo));
		return "redirect:/";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("vo");
		if(member!=null)session.invalidate();
			return "redirect:/";
	}
	
	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		if(vo.getId() == null)vo.setId(member.getId());
		service.update(vo);
		
		if(vo.getName()==null)vo.setName(member.getName());
		session.setAttribute("vo", vo);
		
		//session.setAttribute("vo",vo);
		//service.update(vo);
		/*
		if(vo.getName() == null) {
			session = request.getSession();
		session.setAttribute("vo", service.update(vo));
		}*/
		return "redirect:/";
		
	}

	
}
