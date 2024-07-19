package com.kh.musicController;

import java.util.ArrayList;
import java.util.Collections;


import com.kh.mainmenu.Application;
import com.kh.music.Music;



public class MusicController extends Object {

	
	Music music = new Music();

	private ArrayList<Music> list = new ArrayList<>();
	
	
			//1. 마지막 위치에 노래 추가
	public void MusicLastAdd(String musicname, String vocalistname) {
		

		list.add(new Music(vocalistname, musicname));
		
	}
	
			//2. 첫 위치에 노래 추가
			public void MusicFirstAdd(String musicname, String vocalistname) {
			

			list.add(0, new Music(vocalistname, musicname));
			
		}
		
	
	
	
	
/*
	//3.전체 곡 목록 출력
			public void musicAll() {
				Music List = musicAll();
				for(Music L : List) {
					if(L!=null) System.out.println(L);
				}
			}
			
	*/
		//3.전체 곡 목록 출력
		public ArrayList<Music> musicAll() {
			System.out.println("저장된 노래 수 : " + list.size());
			System.out.println("리스트가 비어있는가? " + list.isEmpty() );
			return list;
			
		}
	
	
	// 4. 노래 찾기 확인용
		public Music Music(String musicname) {
			
			
			
			for(Music m : list) {
				if(m.getMusicname().contains(musicname)) {
					
				}
				System.out.println(m);
			}
			//	System.out.println(list.getMusicname());
			return null;
			}

	
	/*
	System.out.println("이거 나오나 : "+list.get(0));
		
		
		for(Music p : list) {
			System.out.println("이것도"+p);
			}
		*/
		

		//5. 특정 노래 삭제
		public boolean MusicDelete(String musicname) {
			System.out.println("******* 특정 곡 삭제 *******");
			System.out.println("삭제할 곡 명 ");
			
			
			
			
			
			return list.remove(musicname);
			
			
			
			
			
				
	}
	
	
		//6.특정 곡 수정
		public void MusicCorrect() {
			System.out.println("******* 특정 곡 수정 *******");
					
	//		list.set(new Music());
					
			
				
					
		}
	
		
		//7.가수 명 내림차순
		public ArrayList<Music> VocalistnameDescendinGorder() {
			System.out.println("******* 가수 명 내림차순 *******");
			
			ArrayList<Music> cloneList = (ArrayList<Music>) list.clone();
			Collections.sort(cloneList,new Music(compare(music, music)));
			return cloneList;		
			
			
			Collections.sort(compare(music, music));
			Collections.reverse(list);
				System.out.println(list);	
			
				
					
		}
		
		 public int compare(Music o1, Music o2) {
				return o2.getVocalistname().compareTo(o1.getVocalistname());
			}
		 
		//8.가수 명 오름차순
		public void VocalistameAscending() {
			System.out.println("******* 곡 명 오름차순 *******");
					
			Collections.sort(list);
			System.out.println(list);
					
			
		
					
		}

			public int compare1(Music o1, Music o2) {
			return o1.getMusicname().compareTo(o2.getMusicname());
		}

	
	
	
	
	
	


		
	}
	
	
	
	
	
