package algorithm.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { 8,4,3,5,6,1,2,-1,-1,0,56,3,2,9,5,6,-1 };
		quickSort(array, 0, array.length - 1);
		Arrays.asList(array).forEach(System.out::print);
	}

	private static void quickSort(Integer[] array, Integer low, Integer high) {

		if (low < high) {
			Integer pivot = array[(low + high) / 2];
			Integer index = partition(array, low, high, pivot);
			quickSort(array, index, high);
			quickSort(array, low, index - 1);
		}
	}

	private static Integer partition(Integer[] array, Integer low, Integer high, Integer pivot) {
		while (low <= high) {
			while (low <= high && array[low] < pivot) {
				low++;
			}
			while (low <= high && array[high] > pivot) {
				high--;
			}

			if (low <= high) {
				swap(array, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(Integer[] array, Integer low, Integer high) {
		Integer temp = array[low];
		array[low] = array[high];
		array[high] = temp;
	}

}
