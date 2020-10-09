package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
	
	private Map<String, Integer> snackStockMap = new HashMap<String, Integer>();
	
	public Map<String, Integer> snackStock(List<String> input, int stock) {
		
		for(int i = 0; i < input.size(); i++) {
		snackStockMap.put(input.get(i), stock);
		}
		
		return snackStockMap;
		}
	
	public Integer removeSnack(String input, int stock) {
		return snackStockMap.put(input, stock - 1);
	}
	
	public Map<String, Integer> snacksLeft(String input, int stock) {
		return snackStockMap;
	}
	
}
