package com.damoim.controller;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.damoim.model.vo.Membership;
import com.damoim.model.vo.MembershipLocation;
import com.damoim.model.vo.MembershipType;
import com.damoim.model.dto.CommentDTO;


import com.damoim.model.dto.MemberListDTO;

import com.damoim.model.dto.MembershipDTO;

import com.damoim.service.MembershipMeetingService;
import com.damoim.model.dto.SearchDTO;
import com.damoim.service.LocationTypeService;
import com.damoim.service.MainCommentService;
import com.damoim.service.MembershipService;
import com.damoim.model.vo.LocationCategory;
import com.damoim.model.vo.MainComment;
import com.damoim.model.vo.Member;
import com.damoim.model.vo.MembershipUserList;
import com.damoim.model.vo.TypeCategory;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class MembershipController {
	// 클럽 생성 관련 컨트롤

	@Autowired
	private MembershipService service;

	// 댓글관련 서비스
	@Autowired
	private MainCommentService commentService;

	// 08-22 채승훈 클럽메인페이지에 지역과 타입 추가
	@Autowired
	private LocationTypeService locationTypeservice;

	@Autowired
	private MembershipMeetingService meetingService;
	/*
	 * 
	 * */

	


	/*
	 * 성일 카운트 관련 VO에 합쳐버림 성철 댓글 대댓글 글 관련 로직 추가
	 */

	@GetMapping("/{membershipCode}") // 클럽 홍보 페이지 각각 맞춰 갈수있는거
	public String main(@PathVariable("membershipCode") Integer membershipCode, MemberListDTO memberListDTO,
			Model model) {
		// 홍보페이지에 membership 관련 정보 + 호스트 정보
		System.out.println(membershipCode);
		MembershipUserList list = service.main(membershipCode);
		list.setCount((service.membershipUserCount(membershipCode)));

		model.addAttribute("main", list);  
		model.addAttribute("allMember", service.MembershipAllRegular(membershipCode));

		ArrayList<MainComment> commList = commentService.allMainComment(membershipCode); // 일반댓글
		ArrayList<CommentDTO> dtoList = new ArrayList<CommentDTO>(); // 합칠예정
		

		for (int i = 0; i < commList.size(); i++) {
			CommentDTO commentDTO = new CommentDTO().builder().mainCommentCode(commList.get(i).getMainCommentCode())
					.mainCommentText(commList.get(i).getMainCommentText())
					.mainCommentDate(commList.get(i).getMainCommentDate()).id(commList.get(i).getMember().getId())
					.nickname(commList.get(i).getMember().getNickname())
					.memberImg(commList.get(i).getMember().getMemberImg())
					.membershipCode(commList.get(i).getMembershipCode()).recoment(new ArrayList<>()).build();

			dtoList.add(commentDTO);
			ArrayList<MainComment> recommList = commentService.mainReComment(membershipCode,
					commentDTO.getMainCommentCode());
			if (recommList.size() > 0) {
				for (int j = 0; j < recommList.size(); j++) {
					CommentDTO recommentDTO = new CommentDTO().builder()
							.mainCommentCode(recommList.get(j).getMainCommentCode())
							.mainCommentText(recommList.get(j).getMainCommentText())
							.mainCommentDate(recommList.get(j).getMainCommentDate())
							.id(recommList.get(j).getMember().getId())
							.nickname(recommList.get(j).getMember().getNickname())
							.memberImg(recommList.get(j).getMember().getMemberImg())
							.membershipCode(recommList.get(j).getMembershipCode())
							.mainParentsCommentCode(commList.get(i).getMainCommentCode()).build();

					commentDTO.getRecoment().add(recommentDTO);
				}

			}
		}

		model.addAttribute("comment", dtoList);
		System.out.println("커맨트 dio " + dtoList);
		// 08-22 채승훈 클럽페이지 에 로케이션 타입 정보 추가
		model.addAttribute("location", locationTypeservice.locationList(membershipCode));
		model.addAttribute("type", locationTypeservice.typeList(membershipCode));

		return "mainboard/main";
	}

	/*
	 * 성철 해당 클럽에 가입된 회원이 그클럽에 정보와 클럽 가입 현황 볼수있는 페이지 이동
	 * 
	 * 
	 */
	@GetMapping("/club/{membershipCode}") // 클럽 페이지 이동
	public String membershipPage(@PathVariable("membershipCode") Integer membershipCode, MemberListDTO memberListDTO,
			Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Member mem = (Member) authentication.getPrincipal();
		
		boolean ck = false;
		
		for(MemberListDTO dto: mem.getMemberListDTO()) {
			if(dto.getMembershipCode() == membershipCode && !dto.getListGrade().equals("guest")) {
				ck = true;
			}
		}
		if(!ck) {
			System.out.println("일단함 확인");
			return "error";
		}

		
		System.out.println("로그인 정보 " + mem);
		// 해당클럽 정보 다담음
		System.out.println(membershipCode);
		MembershipUserList list = service.main(membershipCode);
		list.setCount((service.membershipUserCount(membershipCode)));
		// 호스트정보
		model.addAttribute("main", list);
		// 해당클럽에 가입신청된 모든 유저정보

		// 0903 성일 어차피 승인은 멤버관리 페이지에서 하기 때문에 모든 인원을 알려주는거 보다 regular 이상 회원만 jsp로 전달
		// model.addAttribute("allMember" , service.MembershipAllInfo(membershipCode));
		
		model.addAttribute("allMember", service.MembershipAllRegular(membershipCode));
		model.addAttribute("adminList", service.adminUser(membershipCode));

		model.addAttribute("allmeet", meetingService.allMeetings(membershipCode));
		System.out.println(meetingService.allMeetings(membershipCode));

		// 08-22 채승훈 클럽페이지 에 로케이션 타입 정보 추가
		model.addAttribute("location", locationTypeservice.locationList(membershipCode));
		model.addAttribute("type", locationTypeservice.typeList(membershipCode));

		return "membership/membershipPage";
	}

	/*
	 * 성철 일단 클럽 호스트가 가입 승인대기인원 -> 일반 회원으로 바꾸는기능
	 */
	@ResponseBody
	@PostMapping("/agreeMember") // 클럽 회원가입 승인
	public void agreeMemeber(MemberListDTO member) {
		// 일단은 호스트일때만 클럽 회원 승인기능
		System.out.println("어그리멤버");
		service.agreeMemeber(member);
	}

	/*
	 * 
	 * */
	@GetMapping("/makeMembership") // 클럽 생성페이지로 이동
	public String makeMembership(SearchDTO search, Model model) {
		model.addAttribute("locLaNameList", locationTypeservice.locLaNameList());
		model.addAttribute("typeLaNameList", locationTypeservice.typeLaNameList());
		return "mypage/makeMembership";
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	/*
	 * ???
	 * 
	 * 
	 * 영민 클럽 생성기능 추가
	 *
	 * 성철 만들어진거에 사진첨부만 추가
	 */
	@PostMapping("/makeMembership") // 클럽 생성
	public String makeMembership(MembershipDTO dto, MultipartFile file, String LB, String TB) throws Exception {
		System.out.println("지역 확인 : " + LB); // 인천 = 중구, 미추홀구, 남동구
		System.out.println("유형 확인 : " + TB); // 스터디 = 코딩, 자격증, 토론
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Member mem = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("-----------------------------------");

		// -- membership_name, membership_img, membership_info, membership_max,
		// membership_accession_text, membership_simple_text
		Membership membership = Membership.builder().membershipName(dto.getMembershipName())
				.membershipMax(Integer.parseInt(dto.getMembershipMax()))
				.membershipAccessionText(dto.getMembershipAccessionText())
				.membershipSimpleText(dto.getMembershipSimpleText()).build();
	
		service.makeMembership(membership);

		int code = service.makeMembershipCode(dto.getMembershipName());
		Path directoryPath = Paths.get(
				"\\\\192.168.10.51\\damoim\\membership\\" + code + "\\");
		Files.createDirectories(directoryPath);
		String fileName = fileUpload(file, code);
		membership.setMembershipImg(fileName);

		service.membershipImg(membership);
		
		String locLaName = LB.split(" = ")[0];
		String[] locLaSName = LB.split(" = ")[1].split(", ");
		LocationCategory lc = LocationCategory.builder().locLaName(locLaName).build();

		for (String s : locLaSName) {
			lc.setLocSName(s);
			int locationCode = service.findLocationCode(lc);

			MembershipLocation location = MembershipLocation.builder().locSmallCode(locationCode).membershipCode(code)
					.build();
			System.out.println("지역 확인 : " + location);
			service.makeLocationMembership(location); // MembershipLocation
		}

		String typeLaName = TB.split(" = ")[0];
		String[] typeSName = TB.split(" = ")[1].split(", ");
		TypeCategory tc = TypeCategory.builder().typeLaName(typeLaName).build();

		for (String s : typeSName) {
			tc.setTypeSName(s);
			int typeCode = service.findTypeCode(tc);

			MembershipType type = MembershipType.builder().typeSmallCode(typeCode).membershipCode(code).build();
			System.out.println("타입 확인 : " + type);
			service.makeTypeMembership(type);
		}
		System.out.println(mem.getName());
		MemberListDTO list = new MemberListDTO();
				list.setId(mem.getId());
				list.setListGrade("host");
				list.setMembershipCode(membership.getMembershipCode());
		// 호스트로 보유중인 클럽 유무 확인
		System.out.println("등급 확인 : " + list);
		service.host(list);
		ArrayList<MemberListDTO> dtolist =	(ArrayList<MemberListDTO>) mem.getMemberListDTO();
		dtolist.add(list);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/";
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	/*
	 * 성철 세션에 맴버가 해당 클럽에 가입 X 상황일시 신청가능한 메서드
	 */
	@PostMapping("/membershipApply") // 클럽 회원가입 신청
	public String membershipApply(MemberListDTO member) {
		// 클럽 가입 신청
		service.membershipApply(member);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Member mem = (Member) authentication.getPrincipal();
		ArrayList<MemberListDTO> list = (ArrayList<MemberListDTO>) mem.getMemberListDTO();
		list.add(member);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return "redirect:/" + member.getMembershipCode();
	}
	
	/*
	 * 성철
	 * 가입 탈퇴 , 신청취소
	 * */
	@ResponseBody
	@PostMapping("/deleteList")
	public void deleteList(int membershipCode) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Member mem = (Member) authentication.getPrincipal();
		service.deleteList(new MemberListDTO().builder()
				.id(mem.getId()).membershipCode(membershipCode).build());
		
		ArrayList<MemberListDTO> list = (ArrayList<MemberListDTO>) mem.getMemberListDTO();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMembershipCode() == membershipCode) {
				System.out.println("삭제될 DTO : " + list.get(i));
				list.remove(i);
				break;
				
			}
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("세션변경도 완료");
	}

	/*
	 * 성철 : 클럽 홍보글 작성 페이지
	 */

	@GetMapping("/club/{membershipCode}/membershipPromotionDetail")
	public String membershipPromotionDetail(@PathVariable("membershipCode") Integer membershipCode, Model model) {
		System.out.println(membershipCode);
		System.out.println("맴버쉽" + service.selectMembership(membershipCode));
		model.addAttribute("memInfo", service.selectMembership(membershipCode));
		model.addAttribute("code", membershipCode);
		return "membership/membershipPromotionDetail";
	}



	/*
	 * 성철 파일 삽입 메서드 해당맴버쉽 프로필사진 !!
	 * 
	 */
	public String fileUpload(MultipartFile file, int code) throws IllegalStateException, IOException {
		if (file.getOriginalFilename() == "") {
			System.out.println("NULL 리턴");
			return null;
		}
		UUID uuid = UUID.randomUUID(); // 랜덤 파일명 부여
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		File copyFile = new File("\\\\192.168.10.51\\damoim\\membership\\" + Integer.toString(code) + "\\" + fileName);
		file.transferTo(copyFile);
		System.out.println("에 파일1개 추가!");
		return fileName;
	}


	/*
	 * 영민 클럽명 중복 체크
	 * 
	 */
	@ResponseBody
	@PostMapping("/membershipNameCheck")
	public boolean membershipNameCheck(Membership membership) {
		return service.membershipNameCheck(membership) == null;
	}
	/*
	 * 영민 클럽 정보 업데이트 기능
	 * 
	 * 
	 */

//	@GetMapping("/updateMembership")
//	public String updateMembership(@PathVariable("membershipCode") int membershipCode, Model model) {
//		System.out.println(membershipCode);
//		MembershipUserList list =  service.main(membershipCode);
//		list.setCount((service.membershipUserCount(membershipCode)));
////		model.addAttribute(null, model);
//		return "membership/updateMembership";
//	}

//	@PostMapping("/updateMembership")
//		public String updateMembership(@PathVariable("membershipCode")Integer membershipCode, Membership membership,MembershipDTO dto, Model model) throws IOException {
//		// 홍보페이지에 membership 관련 정보 + 호스트 정보
//				MembershipUserList list =  service.main(membershipCode);
//				list.setCount((service.membershipUserCount(membershipCode)));
//				
//				model.addAttribute("updateMembership", list);	
//				
//		membership.getFile();
//		membership.setMembershipImg(null);
//		System.out.println(membership);
//		service.updateMembership(membership);
//		Membership m = Membership.builder()
//					.membershipCode(membership.getMembershipCode())
//					.membershipImg(fileUpload(membership.getFile(), membership.getMembershipCode()))
//					.membershipName(dto.getMembershipName())
//					.membershipAccessionText(dto.getMembershipAccessionText())
//					.membershipSimpleText(dto.getMembershipSimpleText())
//					.membershipMax(Integer.parseInt(dto.getMembershipMax()))
//					.build();
//		service.membershipImg(m);
//		MemberListDTO dtolist = new MemberListDTO();
//		dtolist.setId(dto.getId());
//		dtolist.setListGrade(dto.getListGrade());
//		dtolist.setMembershipCode(membership.getMembershipCode());
//		// 호스트로 보유중인 클럽 유무 확인
//		service.host(dtolist);
//		System.out.println(dtolist);
//
////	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////	Membership mship = (Membership) authentication.getPrincipal();
//	return "redirect:/myMembership";
//		
//	}
//	}
	/*
	 * 성철 파일 삽입 메서드 해당맴버쉽 프로필사진 !!
	 * 
	 */

	/*
	 * 성철 파일 삭제 메서드 해당유저 프로필사진 변경시 사용!! 실 사용때는 조건에 만약 보내준 링크가 null이면 변하지 않도록
	 */
	public void fileDelete(String file, int code) throws IllegalStateException, IOException {
		if (file == null) {
			System.out.println("삭제할 파일이 없습니다");
		} else {
			System.out.println("삭제될 URL : " + file);
			File f = new File("\\\\192.168.10.51\\damoim\\membership\\" + Integer.toString(code) + "\\" + file);
			f.delete();

		}

	}
	
	
	/* 성일
	 * 어드민이나 호스트이냐 따라서 서로다른 맴버쉽 관리 페이지 이동처리
	 * */

	/*
	 * 멤버관리 페이지 호스트와 관리자만 접속 가능 등급 설정 및 회원 강퇴 기능 구현
	 * 
	 */
	@GetMapping("/management")
	public String management(Integer membershipCode, Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Member mem = (Member) authentication.getPrincipal();
		
		
	boolean check = false;
		
		for (int i=0; i<mem.getMemberListDTO().size(); i++) {
			if(mem.getMemberListDTO().get(i).getMembershipCode() == membershipCode && !(mem.getMemberListDTO().get(i).getListGrade().equals("guest") || mem.getMemberListDTO().get(i).getListGrade().equals("regular")) ) {
				check = true;
				
			}
			
		}

		if (!check) {
			
			return "error";
		}

		model.addAttribute("allMember", service.MembershipAllInfo(membershipCode));
		model.addAttribute("host", service.main(membershipCode));


		List<String> hosts = new ArrayList<String>();

		for (int i = 0; i < service.adminUser(membershipCode).size(); i++) {

			if (service.ifHost(service.adminUser(membershipCode).get(i).getId()) != null) {

				String id = service.ifHost(service.adminUser(membershipCode).get(i).getId()).getId();

				hosts.add(id);

			}

		}

		model.addAttribute("otherHost", hosts);
		// 들어온 사람의 id랑
		// 해당 클럽의 호스트인 사람의 id가 일치
		// 해당 클럽의 호스트인 사람 찾는 xml 필요
		System.out.println("접속");

		return "membership/management";
	}

	/*
	 * 성철 일단 클럽 호스트가 가입 승인대기인원 -> 일반 회원으로 바꾸는기능 성일 클럽 회원 관리 페이지에서 승인, 강퇴,호스트업그레이드
	 * 등등처리
	 */
	@ResponseBody
	@PostMapping("/gradeUpdate")
	public int gradeUpdate(MemberListDTO member) {
		System.out.println("ajax 호출 ");

		System.out.println(member);

		int code = member.getMembershipCode();

		service.agreeMemeber(member);

		return code;

	}

}
