package com.damoim.controller;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.damoim.model.dto.MemberLocTypeDTO;

import com.damoim.model.dto.SearchDTO;
import com.damoim.model.dto.searchAjaxDTO;
import com.damoim.model.vo.LocationCategory;
import com.damoim.model.vo.Member;

import com.damoim.model.vo.TypeCategory;
import com.damoim.service.LocationTypeService;
import com.damoim.service.MembershipService;

// 승훈 - 0814 수정

@Controller
public class LocationTypeController {
	
	@Autowired
	private LocationTypeService locationTypeservice;

	@Autowired
	private MembershipService memberService;
	
	public List<MemberLocTypeDTO> locationTypeList(SearchDTO search) {
		
		
		
		// '세종' 안에 null 이 아니면 '세종시' 넣고
		if(search.getLocationSName()!=null) {
			search.setLocationSNameList(new ArrayList<>(Arrays.asList(search.getLocationSName().split(","))));	
		}
		if(search.getTypeSName()!=null) {
			search.setTypeSNameList(new ArrayList<>(Arrays.asList(search.getTypeSName().split(","))));
		}
		

		// Location type 확인후 MemberShipCode 뽑기
		List<Integer> membershipCodes = locationTypeservice.searchList(search);		
		
		List<MemberLocTypeDTO> list = new ArrayList<MemberLocTypeDTO>();
		

		// 모든 정보 합쳐서 리스트로 뿌리기
		if(membershipCodes.size()!=0) {
			// 위에서 뽑아온 코드를 다시 searchDTO에 저장
			search.setMembershipCodes(membershipCodes);
			// 받아온 코드로 다시 memberLocTypeList 관련된 지역 및 타입 가져오기 
			list = locationTypeservice.memberLocTypeList(search);

			for(MemberLocTypeDTO dto : list) {
				//그리고 dto에 만든 리스트에 또 넣기
				List<LocationCategory> locations = locationTypeservice.locationList(dto.getMembershipCode());
				List<TypeCategory> types = locationTypeservice.typeList(dto.getMembershipCode());
				Member member = locationTypeservice.selectMemberNickName(dto.getMembershipCode());
				dto.setLocations(locations);
				dto.setTypes(types);
				dto.setNickname(member.getNickname());
				dto.setId(member.getId());
				dto.setMemberImg(member.getMemberImg());
				dto.setMemberLocation(member.getMemberLocation());
				dto.setMemberType(member.getMemberType());
				dto.setCount(locationTypeservice.allMemberShipUser(dto.getMembershipCode()));
			}
		}
		
		return list;
	}
	
	
	// 화면단에 뿌리기
	@GetMapping("/")
	public String locationType(Model model, SearchDTO search) {
		
		model.addAttribute("list", locationTypeList(search));
		System.out.println(locationTypeList(search).get(1).getMemberImg());
		// 화면 상단바
		model.addAttribute("locLaNameList", locationTypeservice.locLaNameList());
		model.addAttribute("typeLaNameList", locationTypeservice.typeLaNameList());
		
	
		
		
		
		return "index";
	}
	
	@ResponseBody
	@GetMapping("list")
	public List<MemberLocTypeDTO> list(SearchDTO search) {	
		return locationTypeList(search);
	}
	
	@ResponseBody
	@GetMapping("locationSList")
	public List<String> locationSList(String laName,Model model) {
		return locationTypeservice.locSNameList(laName);
	}
	
	@ResponseBody
	@GetMapping("typeSName")
	public List<String> typeSName(String typeLaName) {
		return locationTypeservice.typeSNameList(typeLaName);
	}
}
