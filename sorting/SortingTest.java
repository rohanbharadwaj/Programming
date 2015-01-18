package sorting;

import java.util.Arrays;

public class SortingTest {
	
public static void main(String[] args) {
	BubbleSort obj = new BubbleSort();
	int a[] = {-34,13,-12,3,24,783,56};
	System.out.println("Before Sorting : "+Arrays.toString(a));
	obj.sort(a);
	System.out.println("Bubble Sort : "+Arrays.toString(a));
	
	SelectionSort obj1 = new SelectionSort();
	int[] array1 = {221,23,-13,3,45,4};
	System.out.println("Before Sorting : "+Arrays.toString(array1));
	obj1.sort(array1);
	System.out.println("Selectiom Sort :"+Arrays.toString(array1));
	
	MergeSort obj2 = new MergeSort();
	int[] array2 = {221,23,-13,3,45,42};
	System.out.println("Before Sorting : "+Arrays.toString(array2));
	obj2.sort(array2);
	System.out.println("Merge Sort :"+Arrays.toString(array2));
}
}
