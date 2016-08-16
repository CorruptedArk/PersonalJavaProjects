package dev.corruptedark.weightedrandom;

public class WeightedItem <T> {
	
	private T item;
	private double start, end, weight;
	private int count = 0;
	
	public WeightedItem(T item, double weight){
		this.item = item;
		this.weight = weight;
	}
	
	public void increment(){
		count++;
	}
	
	public void setStart(double start){
		this.start = start;
	}
	
	public void setEnd(double end){
		this.end = end;
	}
	
	public double getStart(){
		return start;
	}
	
	public double getEnd(){
		return end;
	}
	
	public int getCount(){
		return count;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public T getItem(){
		return item;
	}

}
