package com.kh.music;

import java.util.ArrayList;
import java.util.Objects;







public class Music implements Comparable<Music> {
	
	private	String musicname;
	private String vocalistname;
	
	public Music() {
	}

	public Music(String musicname, String vocalistname) {
		this.musicname = musicname;
		this.vocalistname = vocalistname;
	}

	public String getMusicname() {
		return musicname;
	}

	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}

	public String getVocalistname() {
		return vocalistname;
	}

	public void setVocalistname(String vocalistname) {
		this.vocalistname = vocalistname;
	}

	@Override
	public String toString() {
		return vocalistname + " - " + musicname + "]";
	}

	/*
	
	//가수 명
	 public int compare(Music o1, Music o2) {
		return o2.getVocalistname().compareTo(o1.getVocalistname());
	}
	
	*/
	
	// 곡 명 
	 
		
	@Override
	public int compareTo(Music o) {
		return 0;
	}
	
	
	
	
	
}
