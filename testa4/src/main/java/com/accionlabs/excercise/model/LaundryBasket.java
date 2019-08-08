package com.accionlabs.excercise.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LaundryBasket {
	
	Map<String, Integer> sockTypesMap = new HashMap<String,Integer>();
	/* this is model class
	 * Objective: while adding the sockType, we need to calculate total count and keep in hashmap
	 * String : key - contains SockTypes, Green
	 * Integer: value - contains SockType count
	 */
	public void addSock(final String sockType) {
		Integer sockTypeCount = sockTypesMap.get(sockType);
		if (sockTypeCount == null) {
			sockTypesMap.put(sockType, 1);
		} else {
			sockTypesMap.put(sockType, ++sockTypeCount);
		}
	}
	
	public int getSockCount() {
		return sockTypesMap.size();
	}
	public Set<String> getSockTypes() {
		return sockTypesMap.keySet();		
	}
	
	public int getSockTypeCount(String sockType) {
		return sockTypesMap.get(sockType);
	}
}
