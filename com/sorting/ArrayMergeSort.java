package com.problemas.mergesort;

import java.util.Arrays;

public class ArrayMergeSort{
	
	public int[] merge(int[] array){		
		if(array.length <= 1){
			return array;
		}
		
		int middle = (array.length)/2;
		int[] left = Arrays.copyOfRange(array, 0, middle);
		int[] right = Arrays.copyOfRange(array, middle, array.length);
		
		left = merge(left);
		right = merge(right);
		
		return merge(left, right);
	}
	
	private int[] merge(int[] left, int[] right){
		int i = 0;
		int j = 0;
		int k = 0;
		int[] resultado = new int[left.length+right.length];
		while(i < left.length && j < right.length){
			if(left[i] <= right[j]){
				resultado[k] = left[i++];
			} else {
				resultado[k] = right[j++];
			}
			k++;
		}
		
		while(i < left.length){
			resultado[k++] = left[i++];
		}
		
		while(j < right.length){
			resultado[k++] = right[j++];
		}
		
		return resultado;
	}
	
	public static void main(String[] args){
		int[] array = new int[]{400, 8, 2699, 6, 9, 5, 2, 10, 59};
		ArrayMergeSort mergeSort = new ArrayMergeSort();
		int[] res = mergeSort.merge(array);
		System.out.print("Inicial: ");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
			if(i != array.length-1){
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("Resultado: ");
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i]);
			if(i != res.length-1){
				System.out.print(", ");
			}
		}
	}
}
