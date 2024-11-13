package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;


/*
 *  REST (Representational State Transfer) : API를 설계하는 아키텍처
 * 
 *  RESTful : REST 원칙을 준수하는 방식
 * 
 *  API (Application Programming Interface)
 *  : 서로 다른 애플리케이션들이 서로 데이터를 주고받을 수 있게 하는 도구
 * 
 * 
 * 
 * */




@RestController
@RequestMapping("/api/*") // HTTp:localhost:8080/api



public class BoardController {

		private String path = "\\\\192.168.10.51\\upload\\";
	
	
		@Autowired
		private BoardService BS;
		
		
	// CRUD : Create - Post, Read - Get ,Update - put, Delete - Delete
		
		// Create - Post
		
		@PostMapping("/board")
		public ResponseEntity write(Board board) throws IllegalStateException, IOException {
		 // 1. 파일 업로드 처리
		 String url = fileUpload(board.getFile());
		 board.setUrl(url);
					 
		 // 2. 해당 파일 URL과 함께 title, content DB에 저장
		 BS.add(board);
		 System.out.println(board);
					 
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
		
		
		
		// Read - Get
				 @GetMapping("/board")
				    public ResponseEntity list(Paging paging) {
				 
				 	List<Board> list = BS.list(paging);
				 	
				 	for(Board b : list) {
				 		LocalDateTime date = b.getDate();
				 		Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
				 		b.setFormatDate(formatDate);
				 	}
				 
					// model.addAttribute("list", list);
					// model.addAttribute("paging",new Paging(paging.getPage(), BS.total()));
					 return ResponseEntity.status(HttpStatus.OK).body(new BoardDTO(list, new Paging(paging.getPage(), BS.total()))); // 제이슨 형태로 뿌려줌
				 }

		// Read - Get : 1개 가져오기
		
		@GetMapping("/board/{no}")
		public ResponseEntity view(@PathVariable int no) {
			Board board = BS.select(no);
			System.out.println(board);
			if(board!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(board);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //<- 보낼일이 없으면 빌드
		}
				 
		
		// Update - put
		@PutMapping("/board")
		 public ResponseEntity update(Board vo) throws IllegalStateException, IOException {
//			 System.out.println(vo);
//			 System.out.println(vo.getFile().isEmpty());
			 if(!vo.getFile().isEmpty()) {
						// 파일이 비어있지 않다면 기존 이미지 삭제(delete)
				 if(vo.getUrl()!=null) { // 기존 이미지가 null이 아닌경우
					 
				 
						 File file = new File(path + vo.getUrl());
						 file.delete();
				 }
						 // 새 이미지 등록
						 String url = fileUpload(vo.getFile());
						 vo.setUrl(url);		
			 } 
			 BS.update(vo);
			 
			 return ResponseEntity.status(HttpStatus.OK).build();
		 }
		

		
		//Delete - Delete
		
		@DeleteMapping("/board/{no}")
		 public ResponseEntity delete(@PathVariable int no) {
			 // 업로드한 파일 삭제(필요한 건 URL)
			 Board board = BS.select(no);
			 if(board.getUrl()!=null) {
				 File file = new File(path + board.getUrl());
				 file.delete();
			 }
			 BS.delete(no);
			 return ResponseEntity.status(HttpStatus.OK).build();
		 }
		 
		
		// -----------------------------------------------------------
		
		
		
		
		
				 
		
		public String fileUpload(MultipartFile file) throws IllegalStateException, IOException {
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + file.getOriginalFilename();
			
			File copyFile = new File(path + fileName);
			file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
			return 	copyFile.getAbsolutePath();
			
		}
		
	
		
		@PostMapping("/multiUpload")
		public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
				
				for(MultipartFile file : files) {
					fileUpload(file);			
					
			}
			
			
			return "redirect:/";
		}
		
		
	
		
		
		
//		 @GetMapping("/list")
//		    public String list(Model model) {
//		        // 게시글 목록을 모델에 추가
//			 
//			 ArrayList<Board> s =  BS.list();
//			 model.addAttribute("s",  s);
//			 
//		        return "list"; // list.jsp를 반환
//		 }
		 
//		
		 
		 
	 
		 @GetMapping("/write")
		 public String write() {
			return "write";
			 
		 }
		 
//		@PostMapping("/write")
//		public void write(Board board) throws IllegalStateException, IOException {
//			System.out.println(board.getFile());
//
//			String file = fileUpload(board.getFile());
//				
//			board.setUrl(file);	
//			
//			BS.add(board);
//			
//			
//		}
		
		
		
		
		 
		 
		 
		 
		 
		 
	
		
	
	
}