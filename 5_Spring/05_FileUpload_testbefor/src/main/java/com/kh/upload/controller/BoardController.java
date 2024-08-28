package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;

@Controller
public class BoardController {

	
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		
		@PostMapping("/upload")
		public String upload(MultipartFile file) throws IllegalStateException, IOException {
			System.out.println("upload!");
			System.out.println("파일 이름 : " + file.getOriginalFilename());
			System.out.println("파일 사이즈 : " + file.getSize());
			System.out.println("파일 파라미터명 : " + file.getName());
			
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + file.getOriginalFilename();
			
			File copyFile = new File("D:\\upload\\" + fileName);
			file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
			
			
			
			return "redairect:/";
		}
		
		public String fileUpload(MultipartFile file) throws IllegalStateException, IOException {
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + file.getOriginalFilename();
			
			File copyFile = new File("D:\\upload\\" + fileName);
			file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
			fileUpload(file);
			
			return "redairect:/";
			
		}
		
		@PostMapping("/multiUpload")
		public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
			
			
				for(MultipartFile file : files) {
					fileUpload(file);
					
					
			}
			
			
			return "redirect;/";
		}
		
		
		@PostMapping("/write")
		public void write(List<Board> board) {
			
			for(Board b: board) {
				System.out.println(b);
			}
			
		
//			<div class="container">
//			<h1>게시물 등록</h1>
//			<form action="/write" method="post" enctype="multipart/form-data">
//			<div class = "from-group">
//			<label>Title</label>
//			<input class= "form-control" name="title">
//			</div>
//			<div class = "from-group">
//			<label>Content</label>
//			<textarea class= "form-control" name="content" row="10"></textarea>
//			</div>
//			<div class = "from-group">
//			<label>Add File</label>
//			<input class= "form-control" name="file" type="file" accept="image/*">
//			</div>
//			<button type="submit" class="btn btn-outline-warning"> 등록 </button>
//			</form> 
//			</div>

			
			
			
			
			
			
			
		}
		
		
}
