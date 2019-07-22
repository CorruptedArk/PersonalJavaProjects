package dev.corruptedark.weightedrandom;

import java.util.ArrayList;

public class RandomPicker {

	public static void main(String[] args) {
		ArrayList<WeightedItem<String>> itemList = new ArrayList<WeightedItem<String>>();
		itemList.add(new WeightedItem<String>("A", 30));
		itemList.add(new WeightedItem<String>("B", 45));
		itemList.add(new WeightedItem<String>("C", 5));
		itemList.add(new WeightedItem<String>("D", 20));
		
		double totalWeight = 0;
		
		for(int i = 0; i < itemList.size(); i++){
			itemList.get(i).setStart(totalWeight);
			totalWeight += itemList.get(i).getWeight();
			itemList.get(i).setEnd(totalWeight);
		}
		
		
		for(int i = 0; i < 100; i++){
			double n = Math.random()*totalWeight%totalWeight;
			for(int j = 0; j < itemList.size(); j++){
				if(itemList.get(j).getStart() <= n && n < itemList.get(j).getEnd()){
					itemList.get(j).increment();
					break;
				}
			}
		}
		
		for(int i = 0; i < itemList.size(); i++){
			String item = itemList.get(i).getItem();
			double weight = itemList.get(i).getWeight();
			int count = itemList.get(i).getCount();
			System.out.println(item+": "+weight+" "+count);
		}
		
		return;
	}
	
	

}
