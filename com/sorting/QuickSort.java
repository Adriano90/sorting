package com.problemas.quicksort;

import java.util.List;
import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>>{
	
	public List<T> sort(List<T> list){
		
		if(list == null || list.size()==0){
			return list;
		}
		
		T pivot = choosePivot(list);
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		
		for(int i = 0; i< list.size(); i++){
			T element = list.get(i);
			if(list.get(i) == pivot){
				continue;
			}
			if(element.compareTo(pivot) <= 0){
				left.add(element);
			} else {
				right.add(element);
			}
		}
		
		List<T> result = new ArrayList<T>();
		
		result.addAll(sort(left));
		result.add(pivot);
		result.addAll(sort(right));
		
		return result;
	}
	
	private T choosePivot(List<T> list){
		return list.get(list.size()/2);
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(400));
		list.add(new Integer(8));
		list.add(new Integer(2699));
		list.add(new Integer(6));
		list.add(new Integer(9));
		list.add(new Integer(2));
		list.add(new Integer(10));
		list.add(new Integer(59));
		
		QuickSort<Integer> quickSort= new QuickSort<Integer>();
		List<Integer> res = quickSort.sort(list);
		
		System.out.print("Inicial: ");
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i));
			if(i != list.size()-1){
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("Resultado: ");
		for(int i = 0; i < res.size(); i++){
			System.out.print(res.get(i));
			if(i != res.size()-1){
				System.out.print(", ");
			}
		}
	}
	
}
