package com.damoim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.damoim.model.vo.Membership;
import org.springframework.web.bind.annotation.PostMapping;

import com.damoim.model.dto.MemberListDTO;
import com.damoim.model.dto.MembershipDTO;
import com.damoim.service.MembershipService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.damoim.model.vo.Member;
import com.damoim.model.vo.Membership;
import com.damoim.model.vo.MembershipUserList;
import com.damoim.service.MembershipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MembershipController {
	// 클럽 생성 관련 컨트롤 
	@Autowired
	private MembershipService membershipservice;

	@Autowired
	private MembershipService service;
//	 @GetMapping("/")
// 	public String index(Model model) {
//		model.addAttribute("allClub",membershipservice.allClub());
//		 return "index";
// 		
// 	
// 	}
	
	@GetMapping("/createclub")
	public String createclub(){
		return "mypage/createclub";
		
	}
	
	@PostMapping("/createclub")// 클럽 생성 메서드
	public String createclub(Membership membership, String infoMedium, String infoLong) {
		System.out.println(membership);
		Membership mship = membership;
		String info = mship.getMembershipInfo();
		info += "#"+ infoMedium + "#" + infoLong; //첫번째와 두번째와 세번째 @로 나눠서 같이 저장
		System.out.println(info);
		mship.setMembershipInfo(info);
		membershipservice.createclub(membership); // 클럽 생성 로직 호출
		System.out.println(membership);
     return "mypage/makeMembership"; // 클럽 생성 후 인덱스 페이지로 리다이렉션
         
}	
	
	@GetMapping("/createclub2")
	public String createclub2(){
		return "mypage/createclub2";
		
	}
	
	@PostMapping("/createclub2")// 클럽 생성 메서드
	public String createclub2(Membership membership, String infoMedium, String infoLong) {
		System.out.println(membership);
		Membership mship = membership;
		String info = mship.getMembershipInfo();
		info += "#"+ infoMedium + "#" + infoLong; //첫번째와 두번째와 세번째 @로 나눠서 같이 저장
		System.out.println(info);
		mship.setMembershipInfo(info);
		membershipservice.createclub(membership); // 클럽 생성 로직 호출
		System.out.println(membership);
     return "mypage/makeMembership"; // 클럽 생성 후 인덱스 페이지로 리다이렉션
         
}	
	
	
	
	
	@GetMapping("/{membershipCode}") // 클럽 홍보 페이지 각각 맞춰 갈수있는거
	public String main(@PathVariable("membershipCode") Integer membershipCode, MemberListDTO memberListDTO, Model model,
			HttpServletRequest request) {

		System.out.println(service.main(membershipCode).getListCode());
		// 홍보페이지에 membership 관련 정보 + 호스트 정보
		model.addAttribute("main", service.main(membershipCode));
		// 현재 가입된 인원수
		model.addAttribute("membershipUserCount", service.membershipUserCount(membershipCode));
		HttpSession session = request.getSession();
		// 로그인한 회원의 id 정보 가져오기 위함
		Member mem = (Member) session.getAttribute("mem");

		if (mem != null) { // 로그인 유무 확인 . 널포인트 에러 방지
			// 가입한 클럽 인지 확인을 위한 아이디 정보 가져오기
			memberListDTO.setId(mem.getId());
			// 해당클럽 안에서의 등급 가져오기
			System.out.println("checkMember : " +service.checkMember(memberListDTO));
			model.addAttribute("checkMember", service.checkMember(memberListDTO));

		}

		return "mainboard/main";
	}
	 
	 @GetMapping("/{membershipCode}club") // 클럽 페이지 이동
		public String membershipPage(@PathVariable("membershipCode") Integer membershipCode,MemberListDTO memberListDTO, Model model,HttpServletRequest request) {
		 	// 클럽 페이지에 membership 관련 정보 + 호스트 정보
		 	model.addAttribute("main",service.main(membershipCode));
		 	// 현재 가입된 인원수
			model.addAttribute("membershipUserCount", service.membershipUserCount(membershipCode));
			// 로그인된 회원 정보		
			List<MembershipUserList> list = service.MembershipAllInfo(membershipCode);
			// 해당클럽 모든 유저 정보 불러오기
			model.addAttribute("allMember" , service.MembershipAllInfo(membershipCode));
			return "membership/membershipPage";
		}
	 
	 @PostMapping("/agreeMember") // 클럽 회원가입 승인
	 public void agreeMemeber(MemberListDTO member) {
		 // 일단은 호스트일때만 클럽 회원 승인기능
		 service.agreeMemeber(member);
		System.out.println("승인");
		
		
	 }
	 
	 
	@GetMapping("/makeMembership") // 클럽 생성페이지로 이동
	public String makeMembership() {
		return "/mypage/makeMembership";
	}
	
	@PostMapping("/makeMembership") // 클럽 생성
	public String makeMembership(MembershipDTO dto) {
		Membership membership = Membership.builder()
				.membershipName(dto.getMembershipName())
				.membershipInfo(dto.getMembershipInfo())
				.membershipMax(Integer.parseInt(dto.getMembershipMax())
						).build();
		// 클럽생성?
		service.makeMembership(membership);

		MemberListDTO list = new MemberListDTO();
				list.setId(dto.getId());
				list.setListGrade(dto.getListGrade());
				list.setMembershipCode(membership.getMembershipCode());
		// 호스트로 보유중인 클럽 유무 확인
		service.host(list);

		return "redirect:/";
	}

	@PostMapping("/membershipApply") // 클럽 회원가입 신청
	public String membershipApply(MemberListDTO member) {
		// 클럽 가입 신청 
		service.membershipApply(member);

		return "redirect:/";
	}
	}

	
	

