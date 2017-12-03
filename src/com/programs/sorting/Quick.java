package com.programs.sorting;

public class Quick {
	
	public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
		int pivot = partition(array, startIdx, endIdx);
		if (startIdx < pivot - 1) {
			recursiveQuickSort(array, startIdx, pivot - 1);
		}
		if (endIdx > pivot) {
			recursiveQuickSort(array, pivot, endIdx);
		}
	}

	public static int partition(int[] array, int left, int right) {
		int pivot = array[left];
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot)
				right--;
			if (left <= right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				left++;
				right--;
			}
		}
		return left;
	}
}
