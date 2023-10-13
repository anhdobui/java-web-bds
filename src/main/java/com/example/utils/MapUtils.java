package com.example.utils;

import java.util.Map;

public class MapUtils {
	public static <T> T getObject(Map<String,Object> maps, String key, Class<T> tClass) {
		try {
			Object obj = maps.getOrDefault(key, null);
			if(obj != null) {
				if(tClass.getTypeName().equals("java.lang.Long")) {
					obj = obj != "" ? Long.valueOf(obj.toString()) : null; 
				}else if(tClass.getTypeName().equals("java.lang.Integer")) {
					obj = obj != "" ? Integer.valueOf(obj.toString()) : null;
				}else if(tClass.getTypeName().equals("java.lang.String")) {
					obj = obj.toString().equals("") ? null : obj.toString();
				}
				return tClass.cast(obj);
			}
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
}
