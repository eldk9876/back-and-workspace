package com.kh.mainmenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.kh.music.Music;
import com.kh.musicController.MusicController;




public class Application {

	
	Scanner sc = new Scanner(System.in);
	MusicController con = new MusicController();

	public static void main(String[] args) {
	
		Application a = new Application();
		a.mainmenu();
		
		
		
	}

		public void mainmenu () {
			
			while(true) {
				System.out.println("====== 메인 메뉴 ======");
				System.out.printf
						 ("1. 마지막 위치에 곡 추가\n"
						+ "2. 첫 위치에 곡 추가\n"
						+ "3. 전체 곡 목록 출력\n"
						+ "4. 특정 곡 검색\n"
						+ "5. 특정 곡 삭제\n"
						+ "6. 특정 곡 수정\n"
						+ "7. 가수 명 내림차순 정렬\n"
						+ "8. 곡 명 오름차순 정렬\n"
						+ "9. 종료");
				try {
				System.out.println("\n메뉴 번호 입력 : ");
				int seleck = Integer.parseInt(sc.nextLine());
				
				switch (seleck) {
				case 1:
					MusicLastAdd();
					break;
					
				case 2:
					MusicFirstAdd();
					break;
				
				case 3:
					musicAll();
					break;
					
				case 4:
					MusicSearch();
					break;
					
				case 5:
					MusicDelete();
					break;
				
				case 6:
					MusicCorrect();
					break;
				
				case 7:
					VocalistnameDescendinGorder();
					break;
					
				case 8:
					VocalistameAscending();
					break;
				
				case 9:
					System.out.println("종료");
						
					return;
					

				default:
					break;
				}	
				}catch(NumberFormatException e){
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
		}
	
			
			
			
		}//1.마지막 위치에 곡 추가
		public void MusicLastAdd() {
			
			System.out.println("******* 마지막 위치에 곡 추가  *******");
			System.out.println("곡 명 : ");
			String musicname = sc.nextLine();
			
			System.out.println("가수 명 : ");
			String vocalistname = sc.nextLine();
			
			con.MusicLastAdd(vocalistname, musicname);
			
			System.out.println("추가 성공 !");
			
		}
		//2.첫 위치에 곡 추가
		public void MusicFirstAdd() {
			
			System.out.println("******* 첫 위치에 곡 추가  *******");
			System.out.println("곡 명 : ");
			String musicname = sc.nextLine();
			
			System.out.println("가수 명 : ");
			String vocalistname = sc.nextLine();
			
			con.MusicFirstAdd(vocalistname, musicname);
			
			System.out.println("추가 성공 !");
			
		}
		
		
		//3.전체 곡 목록 출력
		public void musicAll() {
			System.out.println("******* 전체 곡 목록 출력 *******");
			
			ArrayList<Music> list = con.musicAll();
			System.out.println(list);
			
			
			/*int sum = 0;
			for(int i = 0; i < list.size(); i++) {
				list.get(i);
				System.out.println(list.get(i));
				
			}*/
	
	}
		
		
		
		
		//4.특정 곡 검색
		public void MusicSearch() {
			System.out.println("******* 특정 곡 검색 *******");
			System.out.println("검색할 곡 명 :");
			String select = sc.nextLine();
			con.MusicSearch(select);
			
			
			//con.MusicSearch(musicname);
	
			//ArrayList<Music> list = con.MusicSearch(musicname);
		/*	
			System.out.println("리스트가 비어있는가? " + list.isEmpty() );
			
			for(Music p : list) {
				System.out.println(list);
			}
		
			try {
				con.MusicSearch();
			}catch(IndexOutOfBoundsException e){
				System.out.println("목록에 노래가 없습니다 다른 메뉴를 선택해주세요");
			}
			*/
			
		}
		
		//5.특정 곡 삭제
		public void MusicDelete() {
			System.out.println("******* 검색할 곡 명 *******");
			String musicname = sc.nextLine();
			con.MusicDelete(musicname);
			
					
					
				//con.MusicDelete();
					
		}
		
		//6.특정 곡 수정
				public void MusicCorrect() {
					System.out.println("******* 특정 곡 수정 *******");
							
					
							
							
						con.MusicCorrect();
							
				}
				//7.가수 명 내림차순
				public void VocalistnameDescendinGorder() {
							
							
						con.VocalistnameDescendinGorder();
							
				}
				//8.가수 명 오름차순
				public void VocalistameAscending() {
					

						con.VocalistameAscending();
							
				}
				
		
		
		
	}


