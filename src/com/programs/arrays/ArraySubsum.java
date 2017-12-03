package com.programs.arrays;

import java.util.HashMap;

//Asked by Samba for Snapwiz on 27-Nov-2017
public class ArraySubsum {

	public static boolean printSubsumEqualsToTarget(int[] arr, int targetSum) {

		int targetSubsum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Value of i :: "+i);
			if(arr[i]==targetSum)
				return true;
			targetSubsum += arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				targetSubsum += arr[j];

				System.out.println("Value of j :: "+j);
				System.out.println("TargetSubSum :: "+targetSubsum);
				if (targetSubsum == targetSum)
					return true;
				else if (targetSubsum > targetSum)
					break;
			}
			targetSubsum = 0;
		}
		return false;
	}

	public static Boolean printTargetSumSubarray(int arr[], int targetSum) {
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			System.out.println("Sum:: "+sum);
			System.out.println("Map:: "+hM);
			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == targetSum || sum == targetSum || hM.get(sum) != null) {
				System.out.println("Subarray with target Sum from " + hM.get(sum) + 1 + " to " + i);
				return true;
			}
			// Add sum to hash map
			hM.put(sum, i);
		}
		// We reach here only when there is no subarray with 8 sum
		return false;
	}

	public static void main(String args[]) {
		int[] arr = { 6, 5, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Array Contains Subsum 8:: " + printSubsumEqualsToTarget(arr, 8));
		System.out.println("Array Contains Subsum 8 - No 2nd Loop:: " + printTargetSumSubarray(arr, 8));
	}
}
