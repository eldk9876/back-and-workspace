package com.kh.map;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
 * properties
 * - HashMap 구버전인 Hashtable(Object, Object)을 상속받아 구현한 것
 * - (String, String) 형태로 단순화된 컬렉션 클래스
 * - 주로 환경설정과 관련된 속성(property)을 저장하는데 사용
 * 
 * 
 * 
 * */


public class B_Properties {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// 키값 중복X, 순서 X
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		
		Enumeration en = prop.propertyNames();
		while(en.hasMoreElements()) {
			String key = (String) en.nextElement();
			//prop.getProperty(key);
			String value = prop.getProperty(key);
			System.out.println(key + " : " + value);
		}
		
		//prop.entrySet();
		Set<Entry<Object,Object>> entrySet = prop.entrySet();
		for(Entry<Object,Object> enter : entrySet) {
			System.out.println(enter.getKey() + " : " + enter.getValue());
		}
		
		
		
		
		
		
		
	}

	
}
