package com.problemas.mergesort;

import java.util.List;
import java.util.ArrayList;

public class ArrayMergeSortGeneric<T extends Comparable<T>>{
	
	public List<T> merge(List<T> list){		
		if(list.size() <= 1){
			return list;
		}
		
		int middle = (list.size())/2;
		List<T> left = list.subList(0, middle);
		List<T> right = list.subList(middle, list.size());
		
		left = merge(left);
		right = merge(right);
		
		return merge(left, right);
	}
	
	private List<T> merge(List<T> left, List<T> right){
		int i = 0;
		int j = 0;
		int k = 0;
		int size = left.size() + right.size();
		List<T> resultado = new ArrayList<T>(size);
		while(i < left.size() && j < right.size()){
			if(left.get(i).compareTo(right.get(j)) <= 0){
				resultado.add(left.get(i++));
			} else {
				resultado.add(right.get(j++));
			}
		}
		
		while(i < left.size()){
			resultado.add(left.get(i++));
		}
		
		while(j < right.size()){
			resultado.add(right.get(j++));
		}
		
		return resultado;
	}
	
	public static void main(String[] args){
		List<Integer> array = new ArrayList<Integer>();
		array.add(new Integer(400));
		array.add(new Integer(8));
		array.add(new Integer(2699));
		array.add(new Integer(6));
		array.add(new Integer(9));
		array.add(new Integer(5));
		array.add(new Integer(2));
		array.add(new Integer(10));
		array.add(new Integer(59));
		ArrayMergeSortGeneric<Integer> mergeSort = new ArrayMergeSortGeneric<Integer>();
		List<Integer> res = mergeSort.merge(array);
		System.out.print("Inicial: ");
		for(int i = 0; i < array.size(); i++){
			System.out.print(array.get(i));
			if(i != array.size()-1){
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
